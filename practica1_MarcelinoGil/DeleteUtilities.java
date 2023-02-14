package practica1_MarcelinoGil;

/**
 * @description This class contains the methods related removal operations.
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 14/02/2023
 */
public class DeleteUtilities {

	/**
	 * <ul>
	 * <li>The task is set the database to default values.
	 * </ul>
	 * 
	 * @param rows    The default amount of rows.
	 * @param columns The default amount of columns.
	 * @return String [][]
	 */
	public static String[][] eraseDatabase(int rows, int columns) {
		System.out.println("The database has been set to default values.");
		System.out.println('\n');
		return new String[rows][columns];
	}

	/**
	 * <ul>
	 * <li>Clears the array and sets every field=null.
	 * </ul>
	 * 
	 * @param arrayString 2d array
	 */
	public static void clear2DArray(String[][] arrayString) {
		int rowsLength = arrayString.length;
		int columnsLength;
		char confirm = ' ';

		confirm = Utilities.getCharMenu('y', 'n', "Are you sure?");
		if (confirm == 'y') {
			for (int i = 0; i < rowsLength; i++) {

				columnsLength = arrayString[i].length;

				for (int j = 0; j < columnsLength; j++) {
					arrayString[i][j] = null;
				}
			}
			System.out.println("All the fields have been set 'null'.");
		} else {
			System.out.println("Database not deleted");
		}
		System.out.println('\n');
	}

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
	 * field.
	 * <li>Finally, user will be asked to confirm the removal of the row's data. A
	 * for loop will set each column=null if user sayd 'y'es.
	 * </ul>
	 * 
	 * @param arrayString A two-dimensional array.
	 * @param dataRequest Data to be searched.
	 */
	public static void deleteFirstMatch(String[][] arrayString, String dataRequest) {
		boolean dataFound = false;
		int row = 0;
		int rowsLength = arrayString.length;
		int columnsLength = arrayString[row].length;
		char confirm;

		do {
			for (int col = 0; col < columnsLength; col++) {
				columnsLength = arrayString[row].length;// This variable is initialized everytime the loop looks into a
														// new row, for irregular arrays.
				if (arrayString[row][col] != null && arrayString[row][col].equals(dataRequest)) {
					dataFound = true;
					System.out.println('\n');
					System.out.println("- Name -- Category -- Price -- Stock -");
					for (int i = 0; i < columnsLength; i++) {
						System.out.print("- " + arrayString[row][i] + " -");

					}
					System.out.println('\n');
					confirm = Utilities.getCharMenu('y', 'n', "Do you want to delete the previous data?");
					if (confirm == 'y') {
						for (int i = 0; i < columnsLength; i++) {
							arrayString[row][i] = null;
						}
						System.out.println("Removed");
					} else {
						System.out.println("Record not removed");
					}

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
	 * to be found in the array. Two for loops will read the entire array and give
	 * the user the option to delete the row or not.
	 * <li>The first for loop modifies the value of a variable whose value is the
	 * number of columns in each row.
	 * <li>The second for loop iterates through each column. The If statement, in
	 * case a field is not null and romoval has not been discarded, then compares
	 * the value of that field with the data user is looking for.
	 * <li>Note that the columnsLength variable is restarted in every for iteration.
	 * This makes the method work in case the two/dimensional array is not squared
	 * or regular.
	 * <li>If there is a match, user will be asked to confirm the removal.
	 * <li>The boolean rowDiscarded have been added after tests to avoid the same
	 * confirm question given to the user in case a row has more than one match.
	 * </ul>
	 * 
	 * @param arrayString A two-dimensional array.
	 * @param dataRequest Data to be searched.
	 */
	public static void deleteAllMatches(String[][] arrayString, String dataRequest) {
		int coincidencesCount = 0;
		int rowsLength = arrayString.length;
		char confirm = ' ';
		boolean rowDiscarded;

		for (int row = 0; row < rowsLength; row++) {
			int columnsLength = arrayString[row].length; // This variable is initialized everytime the loop looks into a
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
					System.out.println("\nMatch number: '" + (coincidencesCount + 1)
							+ "'. Do you want to delete the previous data?");
					confirm = Utilities.getCharMenu('y', 'n', "");
					if (confirm == 'y') {
						for (int i = 0; i < columnsLength; i++) {
							arrayString[row][i] = null;
						}
						System.out.println("Match number '" + (coincidencesCount + 1) + "' removed.");
					} else {
						System.out.println("Previous record not removed.");
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
	 * <li>This method calls the function getIntBetween so user can set null the
	 * specific field inside a row.
	 * </ul>
	 * 
	 * @param arrayString
	 */
	public static void deleteField(String[][] arrayString) {
		int selectedRow;
		int selectedCol;
		// methor getIntBetween is in charge of setting the parameters, in this case,
		// the valid rows to be modified go from 1 to String[][] length, both included.
		selectedRow = Utilities.getIntBetween(1, arrayString.length, "Enter the row");
		selectedRow -= 1;// -1 to match the array positions.
		selectedCol = Utilities.getIntBetween(1, arrayString[selectedRow].length, "Enter the column/field.");
		selectedCol -= 1;

		arrayString[selectedRow][selectedCol] = null;
	}

}
