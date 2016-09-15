/**
 * 
 */
package block_3_ClassLoader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author artem.stepanov
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		File file = null;
		URL url = null;
		Class tmp = null;
		ClassLoader loader = null;
		Class myClass = null;
		
		try {
			tmp = Class.forName(myClass.getCanonicalName(),true, loader);
			System.out.println("Class downloaded to JRE");
		} catch (Exception e) {
			System.out.println("Class is not download to system now");
		}
		
		file = new File("C:/TMP/javax.mail-1.4.5.jar");
        url = file.toURI().toURL();
        URL[] urls = {url};
        loader = new URLClassLoader(urls);
		myClass = loader.loadClass("javax.mail.search.SearchTerm");
        System.out.println(myClass.getCanonicalName());
		for(int i = 0; i < myClass.getDeclaredMethods().length; i++){
			System.out.println(myClass.getDeclaredMethods()[i].getName());
		}
		
		try {
			tmp = Class.forName(myClass.getCanonicalName(),true, loader);
			System.out.println("Class downloaded to JRE");
		} catch (Exception e) {
			System.out.println("Class is not download to system now");
		}
		
	}

}
