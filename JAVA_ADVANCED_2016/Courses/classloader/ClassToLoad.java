/**
 * 
 */
package classloader;

/**
 * @author stepanov_artem
 *
 */
public class ClassToLoad implements Printable{

	static{
		System.out.println("class ClassToLoad");
	}

	public void print(String delimeter) {
		
		System.out.println(delimeter + "Hello from ClassToLoad instance");
		
	}

}
