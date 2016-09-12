/**
 * 
 */
package block_2_Reflection;

/**
 * @author artem.stepanov
 *
 */
public class Reflection {
	
	@SuppressWarnings("rawtypes")
	Class clazz;
	
	Reflection(String className) throws Exception{
		clazz = Class.forName(className);
	}
	
	
	void getClassDescription(){
		
		System.out.println(clazz.getPackage().equals(null)?"":clazz.getPackage());
		System.out.println();
		System.out.println();
	}
	
}
