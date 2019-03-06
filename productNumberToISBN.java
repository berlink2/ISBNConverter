/**
 * A simple java program for converting 12 digit product ID numbers into ISBN-10 numbers
 * @author Berlian Khatulistiwa
 * 
 */
import java.util.Scanner;

public class productNumberToISBN {
	
	
//main method that runs program
	public static void main(String[] args) {
		String productID = null; //initialization of relevant variables
		String ISBN = null;
		convert convert1 = new convert(); //initialization of convert object that converts productID to ISBN number.
		
		Scanner s = new Scanner(System.in); //scanner for taking in user input
		
		//while loop that continues running until valid product ID is entered.
		boolean running = true;
		while (running) {
			System.out.println("Please enter a product ID number to be converted to an ISBN-10 number:");
			productID = s.nextLine();
			boolean validProductID = convert1.validProductID(productID); //checks if entered digits is a valid product number
			
			if (validProductID ==false) { //if false program continues running
				System.out.println("That is not a valid Product ID number. The product ID number must consist of 12 digits.");
				continue;
				
			} else { //if true product number is converted to ISBN and program is terminated.
				ISBN = convert1.convertToISBN(productID);
				running = false;
				System.out.println("The resulting ISBN-10 number is " + ISBN + ".");
				s.close();
			}
		}

	}

	

}
