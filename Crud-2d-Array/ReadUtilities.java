package practica1_MarcelinoGil;

/**
 * @description This class contains the methods to read the 2d array.
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 14/02/2023
 */
public class ReadUtilities {

	/**
	 * <ul>
	 * <li>This method receives a two-dimensional array of Strings and String data
	 * to be found in the array.
	 * <li>The 'do/while' loop sets the row ,it will stop if there is a match and
	 * therefore dataFound=true.
	 * <li>The second loop is a 'for' that iterates through each column. The 'if'
	 * statement, only in case a field is not null, compares the value of that field
	 * with the data from user input.
	 * <li>Note that the columnsLength variable is resetted in every for iteration.
	 * That makes the methow work in case the two/dimensional array is not squared
	 * or regular.
	 * <li>If there is a match, another for loop will be started and will print each
	 * field. Finally, each match adds 1 to the variable matchesCount. In this case,
	 * I do not return it, but it could be modified to make the method return that
	 * variable if needed for a specific case.
	 * </ul>
	 * 
	 * @param arrayString A two/dimensional array.
	 * @param dataRequest Data to be searched.
	 */
	public static void findFirstMatch(String[][] arrayString, String dataRequest) {
		boolean dataFound = false;
		int row = 0;
		int rowsLength = arrayString.length;
		int columnsLength = arrayString[row].length;

		// The dowhile loop will iterate through every row until dataRequest is found or
		// rowsLength is reached.
		do {
			// This for loop will look into every column of a given row.
			for (int i = 0; i < columnsLength; i++) {
				columnsLength = arrayString[row].length;
				/*-->column length updated in every row in case the String is irregular.
				 */
				if (arrayString[row][i] != null && arrayString[row][i].equals(dataRequest)) {
					System.out.println("The data related to first match:");
					System.out.println("- Name -- Category -- Price -- Stock -");
					for (int j = 0; j < columnsLength; j++) {
						System.out.print("- " + arrayString[row][j] + " -");
					}
					dataFound = true;
					System.out.println('\n');
				}
			}
			row++;
		} while (row < rowsLength && !dataFound);

		if (!dataFound) {
			System.out.println("The data: " + "'" + dataRequest + "'" + " has not been found.");
		}
		System.out.println('\n');
	}

	/**
	 * <ul>
	 * <li>This method receives a two-dimensional array of Strings and String data
	 * to be found in the array. Two for loops will read the entire array.
	 * <li>The first for loop modifies a variable whose value is the number of
	 * columns in each row, for irregular arrays.
	 * <li>The second for loop iterates through each column. The If statement, in
	 * case a field is not null and has not been printed, compares the value of that
	 * field with the data user is looking for.
	 * <li>Note that the columnsLength variable is resetted in every for iteration.
	 * This makes the method work in case the two/dimensional array is not squared
	 * or regular.
	 * <li>If there is a match, another for loop will be started and will print each
	 * field. Finally, each match adds 1 to the variable matchesCount.
	 * <li>The boolean rowPrinted have been added after tests to avoid aditional
	 * print when the row had the same value in different columns.
	 * </ul>
	 * 
	 * @param arrayString A two-dimensional array.
	 * @param dataRequest Data to be searched.
	 */
	public static void findAllMatches(String[][] arrayString, String dataRequest) {
		int coincidencesCount = 0;// This variable might be usefull if something to be returned is needed.
		int rowsLength = arrayString.length;
		int columnsLength = arrayString[0].length;
		boolean rowPrinted;// Flag to avoid printing the same row in case there is more than 1 match in a
							// specific row.

		// First loop iterating through every row.
		for (int row = 0; row < rowsLength; row++) {
			columnsLength = arrayString[row].length;// columnsLength updated for each row
			rowPrinted = false;
			// Second loop iterating through every column of each row.
			for (int col = 0; col < columnsLength; col++) {
				if (arrayString[row][col] != null && !rowPrinted && arrayString[row][col].equals(dataRequest)) {
					// Only print the row if it hasn't been already printed thanks to !rowPrinted
					System.out.print("\n");
					System.out.println("Match number '" + (coincidencesCount + 1) + "'.");
					System.out.println("id - Name -- Category -- Price -- Stock -");
					System.out.print("id" + (row + 1) + "  ");
					// Third loop to print every column of a row that mathes String dataRequest
					for (int i = 0; i < columnsLength; i++) {
						System.out.print("- " + arrayString[row][i] + " -");
					}
					System.out.println('\n');
					coincidencesCount++;
					rowPrinted = true; // The row won't be printed again.

				}
			}
		}
		if (coincidencesCount <= 0) {
			System.out.println("There are " + coincidencesCount + " coincidences for: " + "'" + dataRequest + "'");
		}
		System.out.println('\n');
	}

	/**
	 * <ul>
	 * <li>Shows all the data inside a two/dimensional array.
	 * </ul>
	 * 
	 * @param arrayString The sentence the user will see.
	 */
	public static void showAllData(String[][] arrayString) {
		int rowsLength = arrayString.length;
		int columnsLength;

		System.out.println(" id   -Name--Category--Price--Stock-");
		System.out.print("+------------------------------------------+");

		for (int i = 0; i < rowsLength; i++) {
			columnsLength = arrayString[i].length;// For irregular arrays.
			System.out.print("\n");
			System.out.print(" id" + (i + 1) + " ");
			for (int j = 0; j < columnsLength; j++)
				System.out.print("- " + arrayString[i][j] + " -");
		}
		System.out.println("\n+------------------------------------------+\n");
	}

}
