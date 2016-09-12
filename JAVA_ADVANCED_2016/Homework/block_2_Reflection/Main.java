/**
 * 
 */
package block_2_Reflection;

/**
 * @author stepanov_artem
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Reflection rflctn = new Reflection("block_1.Controller");
		rflctn.getClassDescription();
	}

}
