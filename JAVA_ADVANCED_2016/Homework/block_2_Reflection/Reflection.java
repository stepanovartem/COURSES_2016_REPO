/**
 * 
 */
package block_2_Reflection;

import java.lang.reflect.*;


/**
 * @author artem.stepanov
 *
 */
public class Reflection {
	
	@SuppressWarnings("rawtypes")
	Class clazz;
	
	@SuppressWarnings("rawtypes")
	Class superclazz;
	
	Field[] fields;
	Method[] methods;
	int mods;
	
	Reflection(String className) throws Exception{
		clazz = Class.forName(className);
		superclazz = clazz.getSuperclass();
		fields = clazz.getDeclaredFields();
		methods = clazz.getDeclaredMethods();
	}
	
	
	void getClassDescription(){
		
		System.out.println(clazz.getPackage().equals(null)?"":clazz.getPackage());
		System.out.println();
			
		
		
		System.out.println(getClassModifiers() + "class " + clazz.getSimpleName() + (getSuperClass() ? " extends " + superclazz.getCanonicalName():"")+ " {");
		
		
		
		System.out.println(getFields());
		System.out.println(getMethods());
		
		
		System.out.println("}");
		
	}
	
	
	/**
	 * This method returns class modifiers (public, abstract, final)
	 * @return String
	 */
	private String getClassModifiers(){
		
		mods = clazz.getModifiers(); 
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
	private boolean getSuperClass(){
		
		if (superclazz.equals(Object.class) || superclazz.equals(null)) return false;
		
		return true;
	}
	
	/**
	 * This method returns all class fields with modifiers
	 * @return String
	 */
	private String getFields(){
		
		String fieldsModifiers;
		
		fieldsModifiers = "";
		
		if (fields.length != 0){
			for(int i = 0; i<fields.length; i++){
				mods = fields[i].getModifiers();
				fieldsModifiers = fieldsModifiers.concat("    "+(Modifier.toString(mods).equals("")?"":Modifier.toString(mods)+" ")+fields[i].getType().getSimpleName() + " "+fields[i].getName()+";\n");
			}
		}
		
		return fieldsModifiers;
	}
	
	
	private String getMethods(){
		
		String methodsModifiers;
		methodsModifiers = "";
		
		
		if (methods.length != 0){
			for(int i = 0; i<methods.length; i++){
				mods = methods[i].getModifiers();
				methodsModifiers = methodsModifiers.concat("    "+(Modifier.toString(mods).equals("")?"":Modifier.toString(mods)+" ")+methods[i].getName()+methods[i].getParameterTypes().toString()+";\n");
			}
		}
		
		return methodsModifiers;
	}
	
}
