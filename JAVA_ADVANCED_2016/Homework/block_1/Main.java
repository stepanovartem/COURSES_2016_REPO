/**
 * 
 */
package block_1;

/**
 * @author artem.stepanov 09.09.2016
 *
 */
public class Main {

	public static void main(String[] args) {
		
		View view = new View();
		Model model = new Model();
		Controller cntrl = new Controller(view,model,args);
		cntrl.processUser();

	}


}