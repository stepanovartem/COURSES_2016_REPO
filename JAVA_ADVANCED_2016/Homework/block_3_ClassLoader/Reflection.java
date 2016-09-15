/**
 * 
 */
package block_3_ClassLoader;

import java.lang.reflect.Method;


/**
 * @author artem.stepanov
 *
 */
public class Reflection extends ClassLoader{
	
	@SuppressWarnings("rawtypes")
	private Class clazz;
	private Method[] method;
	
	
	@SuppressWarnings("rawtypes")
	public Class processFind(String className) throws Exception{
		System.out.println(className.replaceAll(".class",""));
		clazz = Class.forName(className.replaceAll(".class",""));
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
