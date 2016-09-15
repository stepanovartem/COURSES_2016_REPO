/**
 * 
 */
package block_3_ClassLoader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * @author artem.stepanov
 *
 */
public class Reflection {
	
	@SuppressWarnings("rawtypes")
	private Class clazz;
	private Method[] method;
	private File file;
	private URL url;
	private URL[] urls = {url};
	ClassLoader mainCL;
	
	public Reflection(String nameJarFile) throws Exception {
		file = new File(nameJarFile);
    	url = file.toURI().toURL();
    	mainCL = new URLClassLoader(urls);
	}
	
	@SuppressWarnings("rawtypes")
	public Class processFind(String className) throws Exception{
		clazz = mainCL.loadClass(className.replaceAll(".class",""));
		method = clazz.getDeclaredMethods();
		if (findMainMethod()) return clazz;
		return null;
	}
	
	
	private boolean findMainMethod(){
		for(int i=0; i<method.length; i++){
			if (method[i].getName().equals("main")) return true;
		}
		return false;
	}
	
}
