//class that converts product ID to ISBN number.
public class convert {
	
	final int productIDLength = 12;  //attribute for product ID number length. Used to check for valid product ID number.
	
	public convert() {	//empty constructor
	}
	
	/**
	 * Method that takes in a product ID number, and creates an incomplete ISBN number (missing the error control number).
	 * Incomplete ISBN number is passed to method to calculate error control number.
	 * Incomplete ISBN and error control number are then concatenated to give fully converted ISBN which is returned.
	 * @param productID
	 * @return
	 */
	public String convertToISBN(String productID) {
		String incompleteISBN = productID.substring(3);
		String errControl = ErrContDigit(incompleteISBN);
		String completeISBN = incompleteISBN + errControl;
		return completeISBN;
	}
	/**
	 * Method that calculates the error control digit which is calculated from an incomplete ISBN number
	 * passed from the method convertToISBN.
	 * @param incompleteISBN
	 * @return
	 */
	public String ErrContDigit(String incompleteISBN) {
		String ErrCont = ""; 
		int weightedSum = 0;
		int multiplier = 10;
		
		char[] incompleteCharArray = incompleteISBN.toCharArray();		
		for (int i = 0;i<incompleteCharArray.length;i++) {
			weightedSum += Character.getNumericValue(incompleteCharArray[i]) * multiplier;
			multiplier--;
		}
		
		int weightedSumModulo = weightedSum % 11;
		if (weightedSumModulo == 0) {
			ErrCont = Integer.toString(weightedSumModulo);
		} else {
			ErrCont = Integer.toString(11 - weightedSumModulo);
			if(ErrCont.equals(Integer.toString(10)) ) {
				ErrCont = "x";
			}
		}
		return ErrCont;
		
	}
	/**
	 * method that checks whether the product ID is valid. Takes in a product ID string
	 * and returns a boolean based on whether product ID is valid.
	 * @param productID
	 * @return
	 */
	public boolean validProductID(String productID) {
		char[] productIDCharArray = productID.toCharArray();
		boolean validProductID = false;
		if (productID.length() == productIDLength) {
			validProductID = true;
		}
		for (int i =0; i< productIDCharArray.length ;i++) {
			if (productIDCharArray[i] < '0' || productIDCharArray[i]> '9') {
				validProductID = false;
			}
		}
		return validProductID;
	}
}
