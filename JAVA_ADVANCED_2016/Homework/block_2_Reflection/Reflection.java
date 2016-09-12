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
	
	@SuppressWarnings("rawtypes")
	Constructor[] cnstrctr;
	Field[] fields;
	Method[] methods;
	int mods;
	
	Reflection(String className) throws Exception{
		clazz = Class.forName(className);
		superclazz = clazz.getSuperclass();
		cnstrctr = clazz.getConstructors();
		fields = clazz.getDeclaredFields();
		methods = clazz.getDeclaredMethods();
	}
	
	
	void getClassDescription(){
		
		System.out.println(clazz.getPackage().equals(null)?"":clazz.getPackage());
		System.out.println();
			
		
		
		System.out.println(getClassModifiers() + "class " + clazz.getSimpleName() + (getSuperClass() ? " extends " + superclazz.getCanonicalName():"")+ " {");
		
		
		System.out.print(getConstructors());
		System.out.print(getFields());
		System.out.print(getMethods());
		
		
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
		
		if (!clazz.getName().equals(Object.class.getName()) && (superclazz.equals(Object.class) || superclazz.equals(null))) return false;
		
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
			System.out.println();
			for(int i = 0; i<fields.length; i++){
				mods = fields[i].getModifiers();
				fieldsModifiers = fieldsModifiers.concat("    "+(Modifier.toString(mods).equals("")?"":Modifier.toString(mods)+" ")+fields[i].getType().getSimpleName() + " "+fields[i].getName()+";\n");
			}
		}
		
		return fieldsModifiers;
	}
	
	/**
	 * This method describes all methods in the Class
	 * @return String
	 */
	private String getMethods(){
		
		String methodsModifiers;
		methodsModifiers = "";
		
		
		if (methods.length != 0){
			System.out.println();
			for(int i = 0; i<methods.length; i++){
				mods = methods[i].getModifiers();
				methodsModifiers = methodsModifiers.concat("    "+(Modifier.toString(mods).equals("")?"":Modifier.toString(mods)+" ")+methods[i].getReturnType().getSimpleName()+" "+methods[i].getName()+"(");
				for(int j = 0; j<methods[i].getParameters().length; j++){
					methodsModifiers = methodsModifiers.concat(methods[i].getParameters()[j].getType().getSimpleName()+" "+methods[i].getParameters()[j].getName()+(j<methods[i].getParameters().length-1?",":""));
				}
				methodsModifiers = methodsModifiers.concat(");\n");
			}
		}
		
		return methodsModifiers;
	}
	
	private String getConstructors(){
		
		String classConstructors;
		classConstructors = "";
		
		if (cnstrctr.length != 0){
			System.out.println();
			for(int i = 0; i < cnstrctr.length ; i++){
				mods = cnstrctr[i].getModifiers();
				classConstructors = classConstructors.concat("    "+(Modifier.toString(mods).equals("public")?"":Modifier.toString(mods)+" ")+cnstrctr[i].getDeclaringClass().getSimpleName()+"(");
				for(int j = 0; j < cnstrctr[i].getParameters().length; j++){
					classConstructors = classConstructors.concat(cnstrctr[i].getParameters()[j].getType().getSimpleName()+" "+cnstrctr[i].getParameters()[j].getName()+(j<cnstrctr[i].getParameters().length-1?",":""));
				}
				classConstructors = classConstructors.concat(");\n");
			}
		}
		
		return classConstructors;
	}
	
}
