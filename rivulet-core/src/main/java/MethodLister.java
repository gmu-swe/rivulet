import edu.columbia.cs.psl.phosphor.org.objectweb.asm.ClassReader;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.tree.ClassNode;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.tree.MethodNode;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class MethodLister {
	public static void main(String[] args) throws Throwable{
		ClassReader cr = new ClassReader(new FileInputStream(args[0]));
		ClassNode cn = new ClassNode();
		cr.accept(cn,ClassReader.SKIP_CODE);

		ArrayList<String> methods = new ArrayList<>();
		for(Object o : cn.methods)
		{
			MethodNode mn = (MethodNode) o;
			methods.add(cn.name+"."+mn.name+mn.desc);
		}
		Collections.sort(methods);
		for(String s : methods)
			System.out.println(s);
	}
}
