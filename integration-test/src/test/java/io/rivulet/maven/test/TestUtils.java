package io.rivulet.maven.test;

public class TestUtils {
	public static int source()
	{
		return 10;
	}

	public static void sink(int in) {
	}

	/* Generic sink. */
	public static <T> void sink(T obj) {
		return;
	}

	/* Generic source returns the supplied object. */
	public static <T> T objSource(T obj) {
		return obj;
	}

	/* A generic sink that throws an ArrayOutOfBoundsException */
    public static <T> void exceptionThrowingSink(T obj) {
        int[] i = new int[1];
        int x = i[3];
    }

	/* A generic sink that throws, catches and rethrows an ArrayOutOfBoundsException */
    public static <T> int exceptionRethrowingSink(T obj) {
		try {
			int[] arr = new int[1];
			int x = arr[2];
			return x;
		} catch (Exception e) {
			throw e;
		}
	}

	/* A generic sink that throws an RuntimeException */
	public static <T> void exceptionThrowingSink2(T obj) {
		throw new RuntimeException("Exception throw in sink");
	}
}
