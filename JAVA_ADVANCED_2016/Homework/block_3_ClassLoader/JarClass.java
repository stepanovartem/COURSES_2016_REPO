package block_3_ClassLoader;

import java.util.Enumeration;
import java.util.jar.*;

public class JarClass {

	private String nameJarFile;
	

	

	
    public JarClass(String nameJarFile) throws Exception {
    	
    	this.nameJarFile = nameJarFile;    	
    	unjarchivator();
				
    	
	}
    
    
	@SuppressWarnings("resource")
	private void unjarchivator() throws Exception{
    	
				
    	JarFile jF = new JarFile(nameJarFile);
    	Enumeration<JarEntry> entries = jF.entries();
    	JarEntry jE;
    	Reflection rflctn = new Reflection(nameJarFile);
    	while(entries.hasMoreElements()){
    		jE = entries.nextElement();
    		if (!jE.isDirectory() && jE.getName().contains(".class")) {
    			if (!(rflctn.processFind(normalizeClassName(jE.getName())) == null)) prinMessage(normalizeClassName(jE.getName()));
    		}
    	}
    }
    
    
    private void prinMessage(String message){
    	System.out.println(message);
    }
    
    private String normalizeClassName(String className){
    	return className.replace('/', '.');
    }

}