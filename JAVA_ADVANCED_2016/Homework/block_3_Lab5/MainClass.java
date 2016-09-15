/**
 * 
 */
package block_3_Lab5;


/**
 * @author artem.stepanov
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Computer PC = new Computer();
		TabletPC tPC = new TabletPC();
		
		Computer comp = tPC;		
		System.out.println(comp.toString());
		comp = PC;
		System.out.println(comp.toString());

	}

}
