/**
 * 
 */
package block_1_MoreLess;

/**
 * @author artem.stepanov
 *
 */
public class View {

    /**
     * Text constant
     */
    public static final String PRPSL = "Please, enter your number...";
    /**
     * Text constant
     */
    public static final String WRNG_DATA = "You've entered incorrect data! Please try again!";
    /**
     * Text constant
     */
    public static final String PRVS_ATTMPTS = "Previous attempts -";
    /**
     * Text constant
     */
    public static final String WIN = "You win! Really my number was - ";
    /**
     * Text constant
     */
    public static final String GUESS_LESS = "I guess the number less than - ";
    /**
     * Text constant
     */
    public static final String GUESS_MORE = "I guess the number more than - ";
    /**
     * Text constant
     */
    public static final String SRC_PRMTR = "Incorrect source parametrs! Program will terminate! Please try again!";

    /**
     * Method to print the message to console
     * @param message String
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Method to print the message to console
     * @param message String
     * @param value int
     */
    public void printMessage(String message, int value){
        System.out.println(message + value);
    }


	
}