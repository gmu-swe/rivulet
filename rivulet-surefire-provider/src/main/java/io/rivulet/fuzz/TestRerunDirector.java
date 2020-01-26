package io.rivulet.fuzz;

import io.rivulet.FileGatheringVisitor;
import io.rivulet.RerunConfigurationComparator;
import io.rivulet.TestClassGroupingRerunConfigurationComparator;
import io.rivulet.internal.rerun.Replacement;
import io.rivulet.internal.rerun.ReplacementImpl;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import org.apache.maven.surefire.util.TestsToRun;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class TestRerunDirector {

	// Suffix used for configuration files not yet read and processed by a TestRerunDirector
	public static final String RAW_CONFIG_SUFFIX = ".rawReruns";
	// Suffix used for configuration files read or processed by a TestRerunDirector
	public static final String PROCESSED_CONFIG_SUFFIX = ".reruns";
	// List of rerun configuration files
	protected final List<File> rerunConfigFiles;

	public TestRerunDirector(String rerunConfigsPath) {
		List<File> files = new LinkedList<>();
		try {
			files = FileGatheringVisitor.getSortedFiles(rerunConfigsPath, RAW_CONFIG_SUFFIX);
		} catch(IOException e) {
			e.printStackTrace();
			System.err.println("Failed to get rerun configuration files from: " + rerunConfigsPath);
		}
		this.rerunConfigFiles = files;
	}

	public TestRerunDirector(Collection<File> files) {
		this.rerunConfigFiles = new LinkedList<>();
		for(File file : files) {
			if(file.isFile() && file.getName().endsWith(RAW_CONFIG_SUFFIX)) {
				this.rerunConfigFiles.add(file);
			}
		}
	}

	/* Keeps reading collections of rerun configurations from the specified stream until an EOFException is thrown.
	 * Returns a set containing all of the rerun configurations read from the stream. */
	@SuppressWarnings("unchecked")
	private static LinkedHashSet<TestRerunConfiguration> readAllConfigs(File file) {
		LinkedHashSet<TestRerunConfiguration> configs = new LinkedHashSet<>();
		try {
			ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			for(;;) {
				configs.addAll((Collection<TestRerunConfiguration>)stream.readObject());
			}
		} catch(EOFException e) {
			// Exhausted input
		}  catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Failed to read configurations from " + file);
		}
		return configs;
	}

	/* Writes the specified configurations to the specified file. */
	private void writeConfigs(File file, LinkedList<TestRerunConfiguration> configs, int numReruns) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			// Write the total number of configurations - subsequent reruns might remove configurations (if forking)
			oos.writeInt(numReruns);
			// Write the configs
			oos.writeObject(configs);
			// Write that no original violation have been verified yet
			oos.writeObject(new HashSet<String>());
			oos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.err.println("Failed to write rerun configurations to: " + file);
		}
	}

	/* Maps class names to class instances. */
	private HashMap<String, Class<?>> getClassNameMap(TestsToRun testsToRun) {
		HashMap<String, Class<?>> map = new HashMap<>();
		for(Class<?> testClass : testsToRun) {
			map.put(testClass.getName(), testClass);
		}
		return map;
	}

	public List<Class<?>> prepareConfigs(TestsToRun testsToRun) {
		LinkedList<Class<?>> ret = new LinkedList<>();
		HashMap<String, Class<?>> testClassNameMap = getClassNameMap(testsToRun);
		for(File configFile : rerunConfigFiles) {
			// Read the configurations from the file
			LinkedList<TestRerunConfiguration> configs = new LinkedList<>(readAllConfigs(configFile));
			// Sort the configurations
			RerunConfigurationComparator comparator = RerunConfigurationComparator.getInstance();
			Collections.sort(configs, comparator);
			// Merge configurations that specify the same behavior which should be next to each other in the sorted list
			Iterator<TestRerunConfiguration> it = configs.iterator();
			LinkedList<TestRerunConfiguration> previousConfigs = new LinkedList<>();
			while(it.hasNext()) {
				TestRerunConfiguration cur = it.next();
				boolean add = true;
				if(!previousConfigs.isEmpty() && comparator.compare(previousConfigs.peek(), cur) == 0) {
					for(TestRerunConfiguration prev : previousConfigs) {
						if(prev.producesSameRerunBehavior(cur)) {
							// Merge violations that produce the same behavior
							prev.addViolationUniqueIDs(cur.getViolationUIDs());
							it.remove();
							cur = prev;
							add = false;
							break;
						}
					}
				} else {
					previousConfigs.clear();
				}
				if(add) {
					previousConfigs.add(cur);
				}
			}

			//Now, re-sort configs by test class name
			Collections.sort(configs, TestClassGroupingRerunConfigurationComparator.getInstance());

			// Add test class instances for the configurations to the returned list
			it = configs.iterator();
			HashSet<String> testMethodsThisClassRun = new HashSet<>();
			String curTestClass = null;
			TestRerunConfiguration curConfig = null;
			while (it.hasNext()) {
				curConfig = it.next();
				Class<?> testClass = testClassNameMap.get(curConfig.getTestClass());
				if (testClass == null) {
					it.remove();
				} else {
					if (!curConfig.getTestClass().equals(curTestClass) && !testMethodsThisClassRun.add(curConfig.getTestMethod())) {
						curTestClass = curConfig.getTestClass();
						testMethodsThisClassRun.clear();
						ret.add(testClass);
					}
				}
			}
			if(configs.isEmpty()) {
				// Delete the configuration file if there are no reruns for the test
				if(!configFile.delete()) {
					System.err.println("Failed to delete file: " + configFile);
				}
			} else {
				String path = configFile.getAbsolutePath();
				if(path.endsWith(RAW_CONFIG_SUFFIX)) {
					path = path.substring(0, path.length() - RAW_CONFIG_SUFFIX.length());
				}
				// Write the filtered set of configurations back to the file
				writeConfigs(new File(path + PROCESSED_CONFIG_SUFFIX), configs, configs.size());
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		if(args.length == 0) {
			throw new RuntimeException("Usage: TestRerunDirector [rerunConfigPath]");
		}
		String rerunConfigsPath = args[0];
		CountingTestRerunDirector director = new CountingTestRerunDirector(rerunConfigsPath);
		System.out.printf("Total Reruns: %d\n", director.countRerunConfigs());
	}

	private static class CountingTestRerunDirector extends TestRerunDirector {

		CountingTestRerunDirector(String rerunConfigsPath) {
			super(rerunConfigsPath);
		}

		int countRerunConfigs() {
			int count = 0;
			HashMap<String, HashSet<TestRerunConfiguration>> baseSourceMap = new HashMap<>();
			HashMap<Class<?>, HashSet<TestRerunConfiguration>> autoTainterMap = new HashMap<>();
			for(File configFile : rerunConfigFiles) {
				// Read the configurations from the file
				LinkedList<TestRerunConfiguration> configs = new LinkedList<>(readAllConfigs(configFile));
				// Sort the configurations
				RerunConfigurationComparator comparator = RerunConfigurationComparator.getInstance();
				Collections.sort(configs, comparator);
				// Merge configurations that specify the same behavior which should be next to each other in the sorted list
				Iterator<TestRerunConfiguration> it = configs.iterator();
				LinkedList<TestRerunConfiguration> previousConfigs = new LinkedList<>();
				while(it.hasNext()) {
					TestRerunConfiguration cur = it.next();
					boolean add = true;
					if (!previousConfigs.isEmpty() && comparator.compare(previousConfigs.peek(), cur) == 0) {
						for (TestRerunConfiguration prev : previousConfigs) {
							if (prev.producesSameRerunBehavior(cur)) {
								// Merge violations that produce the same behavior
								prev.addViolationUniqueIDs(cur.getViolationUIDs());
								it.remove();
								cur = prev;
								add = false;
								break;
							}
						}
					} else {
						previousConfigs.clear();
					}
					if (add) {
						previousConfigs.add(cur);
					}
				}
				if(!configs.isEmpty()) {
					System.out.printf("File: %s | Count: %d\n", configFile, configs.size());
					count += configs.size();
					for(TestRerunConfiguration c : configs) {
						String key = "Multiple replacements";
						List<Replacement> r = c.getReplacementsCopy();
						if(r.size() == 1 && r.get(0) instanceof ReplacementImpl) {
							key = ((ReplacementImpl) r.get(0)).getTargetedBaseSource();
						}
						if(!baseSourceMap.containsKey(key)) {
							baseSourceMap.put(key, new HashSet<>());
						}
						baseSourceMap.get(key).add(c);
						if(!autoTainterMap.containsKey(c.getAutoTainterClass())) {
							autoTainterMap.put(c.getAutoTainterClass(), new HashSet<>());
						}
						autoTainterMap.get(c.getAutoTainterClass()).add(c);
					}
				}
			}
			System.out.println("\n");
			for(String key : baseSourceMap.keySet()) {
				System.out.printf("baseSource: %s | count: %d\n", key, baseSourceMap.get(key).size());
			}
			System.out.println("\n");
			for(Class<?> key : autoTainterMap.keySet()) {
				System.out.printf("baseSink: %s | count: %d\n", key, autoTainterMap.get(key).size());
			}
			return count;
		}
	}
}
