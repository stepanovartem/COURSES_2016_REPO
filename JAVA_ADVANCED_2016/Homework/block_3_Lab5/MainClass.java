/**
 * 
 */
package block_3_Lab5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author artem.stepanov
 *
 */
public class MainClass {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		Computer pc = new Computer();
		TabletPC tPC = new TabletPC();
		
		Class clazz = tPC.getClass();
		
		Method[] method = clazz.getDeclaredMethods();
		
		System.out.println(clazz.getMethod("toString").getAnnotation(Override.class));
		
		for(Method m : method){
			Annotation[] ann = m.getDeclaredAnnotations();
			for(Annotation a : ann){
				System.out.println(a.toString());
			}
		}

	}

}
