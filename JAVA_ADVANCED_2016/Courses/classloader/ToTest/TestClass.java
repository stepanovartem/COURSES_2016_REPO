package classloader.ToTest;

import classloader.Printable;

public class TestClass {

	public static void main(String[] args) throws Exception {
		
		MyClassLoader clLdr = new MyClassLoader();
		@SuppressWarnings("rawtypes")
		Class clazz = clLdr.loadClass("classloader.ClassToLoad");
		Printable instance = (Printable)clazz.newInstance();
		instance.print("=====");
		
	}

}
