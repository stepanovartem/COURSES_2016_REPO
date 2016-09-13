package classloader.ToTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.*;





public class MyClassLoader extends ClassLoader {
	
	private static final String PATH = "/Users/stepanov_artem/Desktop/COURSES_2016_JAVA_ADVANCED/COURSES_2016_REPO.git/JAVA_ADVANCED_2016/target/classes/";
	
	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		
		String classFileName = PATH + name.replaceAll("\\.","/"+".class");
		
		try {
			byte[] classBytes = FileUtils.readFileToByteArray(new File(classFileName));
			Class<?> clazz = defineClass(name, classBytes, 0, classBytes.length);
			return clazz;
		} catch (IOException e) {
			return super.loadClass(classFileName,resolve);
		}
		
		
	}
	
	
	
}
