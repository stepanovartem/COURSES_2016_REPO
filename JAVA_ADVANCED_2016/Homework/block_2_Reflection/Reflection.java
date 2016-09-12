/**
 * 
 */
package block_2_Reflection;

import java.lang.reflect.Modifier;

/**
 * @author artem.stepanov
 *
 */
public class Reflection {
	
	@SuppressWarnings("rawtypes")
	Class clazz;
	
	@SuppressWarnings("rawtypes")
	Class superclazz;
	
	Reflection(String className) throws Exception{
		clazz = Class.forName(className);
		superclazz = clazz.getSuperclass();
	}
	
	
	void getClassDescription(){
		
		System.out.println(clazz.getPackage().equals(null)?"":clazz.getPackage());
		System.out.println();
			
		
		
		System.out.print(getClassModifiers() + "class " + clazz.getSimpleName() + (getSuperClass() ? " extends " + superclazz.getCanonicalName():"")+ " {");
		
		
		
		
		
		
		System.out.println("}");
		
	}
	
	
	/**
	 * This method returns class modifiers (public, abstract, final)
	 * @return String
	 */
	String getClassModifiers(){
		
		int mods = clazz.getModifiers(); 
		if (Modifier.isPublic(mods)) { 
		    return "public "; 
		} 
		if (Modifier.isAbstract(mods)) { 
			return "abstract "; 
		} 
		if (Modifier.isFinal(mods)) { 
			return "final "; 
		} 
		
		return null;
	}
	
	
	/**
	 * In this method, there is inheritance check. If superclass is Object it will return false. 
	 * Since we know that all classes inherited from class Object as default
	 * @return {@link Boolean}
	 */
	boolean getSuperClass(){
		
		if (superclazz.equals(Object.class)) return false;
		
		return true;
	}
	
}
