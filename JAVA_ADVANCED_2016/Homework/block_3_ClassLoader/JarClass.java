package block_3_ClassLoader;

import java.io.IOException;
import java.util.*;
import java.util.jar.*;

public class JarClass {
	
	private HashMap<String, Class<?>> cache = new HashMap<String, Class<?>>();	   

    private String jarFileName;
    private String packageName;       

    private final static String WARNING = "Warning : No jar file found.";



    public JarClass(String jarFileName, String packageName) {    

        this.jarFileName = jarFileName;        

        this.packageName = packageName;

       
        cacheClasses();
    }
    
    private void cacheClasses(){
    	
    	try {         
            @SuppressWarnings("resource")
			JarFile jarFile = new JarFile(jarFileName);
            @SuppressWarnings("rawtypes")
			Enumeration entries = jarFile.entries();
            
            
            while (entries.hasMoreElements()){
            	JarEntry jarEntry = (JarEntry) entries.nextElement();
            	System.out.println(jarEntry.getName());
            }

        	}

        catch (IOException IOE) {
            System.out.println(WARNING);
        }
    	
    }
	
	
}
