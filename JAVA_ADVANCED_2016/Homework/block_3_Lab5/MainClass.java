/**
 * 
 */
package block_3_Lab5;


import java.lang.reflect.Method;

/**
 * @author artem.stepanov
 *
 */
public class MainClass {

	/**
	 * @param args

	 * @throws Exception 

	 */
	public static void main(String[] args) throws Exception {

		TabletPC tPC = new TabletPC();
		
		@SuppressWarnings("rawtypes")
		Class clazz = tPC.getClass();
		
		Method[] method = clazz.getMethods();
		
		System.out.println(tPC.toString());
		for(Method m : method){
			My_Annot annot = m.getAnnotation(My_Annot.class);
			if (annot != null) m.invoke(tPC);
		}
		System.out.println(tPC.toString());


		Class[] interf = clazz.getInterfaces();
		
		for(Class i: interf){
			System.out.println(i.getCanonicalName());
		}
	}

}
