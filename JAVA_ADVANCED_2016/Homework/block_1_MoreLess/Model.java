/**
 * 
 */
package block_1_MoreLess;

import java.util.ArrayList;

/**
 * @author artem.stepanov
 *
 */
public class Model {



	private int myNumber;
	private ArrayList<Integer> arrAttempts = new ArrayList<Integer>();



	private long counter;

	public static final int RAND_MAX = 100;

	/**
	 * The method that generates random number from min to max range
	 * @param min - int
	 * @param max - int
	 */
	void  intRand(int min, int max){
		setMyNumber(min + (int)(Math.random()*(max-min+1)));
		System.out.println(myNumber);
	}

	
	
	/**
	 * @return the myNumber
	 */
	public int getMyNumber() {
		return myNumber;
	}

	/**
	 * @param myNumber the myNumber to set
	 */
	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}
	
	
	/**
     * 
	 * In this method, a comparison of the numbers on the exact match
     * @param number int
     * @return boolean
     */	
	boolean tryToGuess (int number){
		
		if (number == myNumber) {
			return true;			
		}else return false;
	}
	
	
	/**
     * 
	 * 
	 *In this method, a comparison to the more-less
     * @param number int
     * @return boolean
     */	
	boolean comparingNumbers(int number){
		
		if (number > myNumber) {
			return true;			
		}else return false;
	}

	public ArrayList<Integer> getArrAttempts() {
		return arrAttempts;
	}

	public void setArrAttempts(int var) {
		this.arrAttempts.add(var);
	}


	public long getCounter() {
		return counter;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}
}