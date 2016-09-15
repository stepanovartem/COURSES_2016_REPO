package block_3_ClassLoader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.*;

public class JarClass {

	private String nameJarFile;
	
	private File file;
	private URL url;
	private URL[] urls = {url};
	ClassLoader mainCL;
	

	
    public JarClass(String nameJarFile) throws Exception {
    	
    	this.nameJarFile = nameJarFile;    	
    	unjarchivator();
				
    	
	}
    
    
	@SuppressWarnings("resource")
	private void unjarchivator() throws Exception{
    	
		
		file = new File("C:/TMP/javax.mail-1.4.5.jar");
    	url = file.toURI().toURL();
    	mainCL = new URLClassLoader(urls);
		
    	JarFile jF = new JarFile(file);
    	Enumeration<JarEntry> entries = jF.entries();
    	JarEntry jE;
    	Reflection rflctn = new Reflection();
    	
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