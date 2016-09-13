/**
 * 
 */
package block_1_MoreLess;

import java.util.Scanner;

/**
 * @author artem.stepanov
 *
 */
public class Controller{



	/** Constant - maximum number of source parametrs which are yousing in this program*/
	public static final int MAX_SRC_PRMTRS = 2;

	/** Regular expression - checking input data. Mask for the Integer range*/
	public static final String REGEX_NUMBER = "(\\-\\d{1,10})|(\\d{1,10})";

	/** Field - Model*/
    Model model;
	/** Field - View*/
    View view;

	/** Field - mainLbl - label for while */
    boolean mainLbl;

	/** Constructor - Create new object with parametrs
	 * @param view object by class View
	 * @param model object by class Model
	 * @param args String[]
	 */
    public Controller(View view, Model model, String[] args) {
    	
    	this.view = view;
		this.model = model;
    	if (argsChecker(args,MAX_SRC_PRMTRS) && minMaxChecker(args)){
    		this.model.intRand(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    	}else{
			this.model.intRand(0,Model.RAND_MAX);
		}
    	
    }

	/** Main method in class Controller which starts the game*/
    public void processUser(){
    	
    	
        Scanner sc = new Scanner(System.in); 
        
        do{
        	gameStart(inputIntValueWithScanner(sc));
        	model.setCounter(model.getCounter()+1);
        }while(mainLbl);
    }


	/** Method which read the data from console
	 * @param sc object by class Scanner
	 */
    private int inputIntValueWithScanner(Scanner sc) {
    	
    	String number = new String();
    	boolean lbl;



		lbl = true;

    	
    	view.printMessage(View.PRPSL);
    	number = sc.nextLine();
		while(lbl){
			if (number.trim().split(" ").length>1){
				view.printMessage(View.WRNG_DATA + View.PRPSL);
				number = sc.nextLine();
			}else if (!intChecker(number)){
    			view.printMessage(View.WRNG_DATA + View.PRPSL);
				number = sc.nextLine();
    		}else lbl = false;
    	}
    	
        return Integer.parseInt(number);
    }


    /** Method for guessing the number
     * @param number int
     */
    private void gameStart(int number){

    	if (model.tryToGuess(number)) {
    		if (model.getCounter() != 0) view.printMessage(View.PRVS_ATTMPTS+model.getArrAttempts().toString());
			model.setArrAttempts(number);
    		view.printMessage(View.WIN, model.getMyNumber());
    		mainLbl = false;
    	}else if (model.comparingNumbers(number)){
    		if (model.getCounter() != 0) view.printMessage(View.PRVS_ATTMPTS+model.getArrAttempts().toString());
    		view.printMessage(View.GUESS_LESS, number);
    		model.setArrAttempts(number);
    		mainLbl = true;
    	}else {
    		if (model.getCounter() != 0) view.printMessage(View.PRVS_ATTMPTS+model.getArrAttempts().toString());
    		view.printMessage(View.GUESS_MORE, number);
			model.setArrAttempts(number);
    		mainLbl = true;
    	}
    	
    }



    /** The method that checks whether a string is an integer number
     * @param var String
     */
    private boolean intChecker(String var){

    	if(var.matches(REGEX_NUMBER)&&(Long.parseLong(var)<Integer.MAX_VALUE & Long.parseLong(var)>Integer.MIN_VALUE)){
    		return true;
		}else return false;

    }

	/**
	 * The method to validate input source parametrs
	 * @param args String[]
	 * @param MaxSrcPrmtrs  constant MAX_SRC_PRMTRS
	 * @return  boolean
	 * @see #MAX_SRC_PRMTRS
	 */
    private boolean argsChecker(String[] args, int MaxSrcPrmtrs){
    	
    	if (args.length == 1 || args.length > MaxSrcPrmtrs){
    		view.printMessage(View.SRC_PRMTR);
    		System.exit(0);
    	}else if(args.length == MaxSrcPrmtrs){
    		for(int i = 0; i<args.length; i++){
    			if(!intChecker(args[i])){    				
    				view.printMessage(View.SRC_PRMTR);
    				System.exit(0);	
    			}
    		}
    		return true;
    	}
		return false;
    }

	/**
	 * In this method checking that min value less then max value from source parametrs
	 * @param args String[]
	 * @return boolean
	 */
	private boolean minMaxChecker(String[] args){

    	if (!(Integer.parseInt(args[0])<Integer.parseInt(args[1]))){
    		view.printMessage(View.SRC_PRMTR);
    		System.exit(0);
    	}
    	return true;
    }


    

}