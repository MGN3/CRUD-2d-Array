package practica1_MarcelinoGil;

/**
 * @description This class contains the methods in charge of updating the data.
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 14/02/2023
 */
public class UpdateUtilities {

	/**
	 * <ul>
	 * <li>The user chooses a row and user will be requested to modify each field.
	 * </ul>
	 * 
	 * @param arrayString The two dimensional array to be modified.
	 */
	public static void updateRow(String[][] arrayString) {
		int selectedRow;

		// methor getIntBetween is in charge of setting the parameters, in this case,
		// the valid rows to be modified go from 1 to String[][] length, both included.
		selectedRow = Utilities.getIntBetween(1, arrayString.length, "Enter the row you want to update");
		selectedRow -= 1;// -1 to match the array positions.

		// The loop that modifies each field.
		for (int col = 0; col < arrayString[selectedRow].length; col++) {
			arrayString[selectedRow][col] = Utilities.getString("Enter the value for column '" + (col + 1) + "'");
		}
	}

	/**
	 * <ul>
	 * <li>This method receives a two-dimensional array of Strings and String data
	 * to be found in the array. Two for loops will read the entire array and give
	 * the user the option to modify the row or not.
	 * <li>The first for loop modifies the value of a variable whose value is the
	 * number of columns in each row.
	 * <li>The second for loop iterates through each row and column. The If
	 * statement, if a field is not null and updated then compares the value of that
	 * field with the data user is looking for.
	 * <li>The last for loop is the one in charge of updating the row with the user
	 * inputs.
	 * <li>Note that the columnsLength variable is resetted in every for iteration.
	 * This makes the method work in case the two/dimensional array is not squared
	 * or regular.
	 * <li>If there is a match, user will be asked to confirm the update.
	 * <li>The boolean rowDiscarded have been added after tests to avoid the same
	 * confirm question given to the user in case a row has more than one match.
	 * </ul>
	 * 
	 * @param arrayString A two-dimensional array.
	 * @param dataRequest Data to be searched.
	 */
	public static void updateAllMatches(String[][] arrayString, String dataRequest) {
		int coincidencesCount = 0;
		int rowsLength = arrayString.length;
		char confirm = ' ';
		int columnsLength;
		boolean rowDiscarded;// In case there is more than one match in the same row, to avoid same question
								// for each match.

		for (int row = 0; row < rowsLength; row++) {
			columnsLength = arrayString[row].length; // This variable is initialized everytime the loop looks into a
														// new row, for irregular arrays.
			rowDiscarded = false;
			for (int col = 0; col < columnsLength; col++) {
				if (arrayString[row][col] != null && !rowDiscarded && arrayString[row][col].equals(dataRequest)) {
					System.out.print("\n");
					System.out.println("id - Name -- Category -- Price -- Stock -");
					System.out.print((row + 1) + "  "); // Imprime el id autoincremental
					for (int i = 0; i < columnsLength; i++) {
						System.out.print("- " + arrayString[row][i] + " -"); // Imprime cada campo
					}

					confirm = Utilities.getCharMenu('y', 'n', "\nCoincindence number: " + (coincidencesCount + 1)
							+ " Do you want to update the previous data?");

					if (confirm == 'y') {
						for (int i = 0; i < columnsLength; i++) {
							arrayString[row][i] = Utilities.getString("Enter the value for column '" + (col + 1) + "'");
						}
					} else {
						System.out.println("Previous record not modified.");
						rowDiscarded = true;
					}
					coincidencesCount++;
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
	 * <li>This method calls the function getIntBetween so user can update the data
	 * of a specific field.
	 * </ul>
	 * 
	 * @param arrayString
	 */
	public static void updateField(String[][] arrayString) {
		int selectedRow;
		int selectedCol;
		// method getIntBetween is in charge of setting the parameters, in this case,
		// the valid rows to be modified go from 1 to String[][] length, both included.
		selectedRow = Utilities.getIntBetween(1, arrayString.length, "Enter the row");
		selectedRow -= 1;// -1 to match the array positions.
		selectedCol = Utilities.getIntBetween(1, arrayString[selectedRow].length, "Enter the column/field.");
		selectedCol -= 1;

		arrayString[selectedRow][selectedCol] = Utilities
				.getString("Enter the value for column '" + (selectedCol + 1) + "'");
	}
	
}
