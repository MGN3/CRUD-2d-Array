package practica1_MarcelinoGil;

/**
 * @description This class contains the methods related to create and add data
 *              into the database.
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 14/02/2023
 */
public class CreateUtilities {

	/**
	 * <ul>
	 * <li>This method will create and return a new array with the number of rows
	 * and columns the user sets. Now its limited to 20 rows and 5 columns, but it
	 * could be changed.
	 * <li>To do so, we call the function getIntBetween for the amount of rows and
	 * the amount of columns.
	 * 
	 * </ul>
	 * 
	 * @return String[][] An empty structure of a two dimensional array of Strings.
	 */
	public static String[][] create2DArray() {

		int rowsLength;
		int columnsLength;
		String[][] returnedArray;

		rowsLength = Utilities.getIntBetween(1, 20, "Introduce the number of rows");
		columnsLength = Utilities.getIntBetween(1, 5, "Introduce the number of columns");

		returnedArray = new String[rowsLength][columnsLength];

		return returnedArray;
	}

	/**
	 * <ul>
	 * <li>This method will ask user to fill the entire twodimensional array of
	 * Strings.
	 * <li>First for loop will iterate through every row and set the value for
	 * columnsLength for the next loop .
	 * <li>The second for loop will ask user to fill every column of the row with
	 * data.
	 * <li>the function ends once the entire array has been filled.
	 * </ul>
	 * 
	 * @param arrayString The 2d array that is going to be modified.
	 */

	public static void fillAllTheArray(String[][] arrayString) {
		int rowsLength = arrayString.length;
		int columnsLength;

		for (int row = 0; row < rowsLength; row++) {
			columnsLength = arrayString[row].length;
			for (int col = 0; col < columnsLength; col++) {
				// This variable is initialized everytime the loop looks into a
				// new row, for irregular arrays.
				System.out.println("Row number: '" + (row + 1) + "'.");
				arrayString[row][col] = Utilities.getString("Value for column '" + (col + 1) + "':");
				System.out.println('\n');
			}
		}
		System.out.println("The database is now full.");
	}

	/**
	 * <ul>
	 * <li>The purpose of this function is to fill every empty row.
	 * <li>The do/while loop will iterate through every row.
	 * <li>The second loop is a while that will keep checking columns until it finds
	 * a not null not empty field. If that is the case, rowEmpty is set false and
	 * the loop will stop.
	 * <li>After that, if a row is empty, user will have to write data inside it,
	 * through a for loop.
	 * <li>The function ends when all the array have been checked for empty rows.
	 * </ul>
	 * 
	 * @param arrayString The 2d array that is going to be modified.
	 */

	public static void fillAllEmptyRows(String[][] arrayString) {
		int row = 0;
		int col = 0;
		int rowsLength = arrayString.length;
		int columnsLength = arrayString[row].length;
		boolean rowEmpty = true;

		do {
			columnsLength = arrayString[row].length;// Checks the amount of columns for each row, for irregular arrays.
			while (col < columnsLength && rowEmpty) {
				if (arrayString[row][col] != null && !arrayString[row][col].isEmpty()) {
					System.out.println("Row '" + (row + 1) + "' contains data.");
					rowEmpty = false;
				}
				col++;
			}

			if (rowEmpty) {
				System.out.println("The row '" + (row + 1) + "' is empty.");
				for (int i = 0; i < columnsLength; i++) { // 'i' variable is the column of a given row
					arrayString[row][i] = Utilities.getString("Enter the value for column '" + (i + 1) + "': ");
				}
			}
			row++;
			col = 0;
			rowEmpty = true;
		} while (row < rowsLength);
		System.out.println("All the empty rows have been filled.");
		System.out.println('\n');
	}

	/**
	 * <ul>
	 * <li>The purpose of this function is to fill the first empty row found.
	 * <li>The do/while loop will iterate through every row.
	 * <li>The second loop is a while that will keep checking columns until it finds
	 * a non/empty column and a
	 * <li>the function ends once the entire array has been filled.
	 * </ul>
	 * 
	 * @param arrayString The 2d array that is going to be modified.
	 */
	public static void fillFirstEmptyRow(String[][] arrayString) {
		int row = 0;
		int col = 0;
		int rowsLength = arrayString.length;
		int columnsLength = arrayString[row].length;
		boolean rowEmpty = true;
		boolean rowFilled = false;

		do {
			columnsLength = arrayString[row].length;// Checks the amount of columns for each row, for irregular arrays.
			while (col < columnsLength && rowEmpty) {
				if (arrayString[row][col] != null && !arrayString[row][col].isEmpty()) {
					System.out.println("Row '" + (row + 1) + "' contains data.");
					rowEmpty = false;
				}
				col++;
			}

			if (rowEmpty) {
				System.out.println("The row '" + (row + 1) + "' is empty.");
				for (int i = 0; i < columnsLength; i++) {
					arrayString[row][i] = Utilities.getString("Enter the value for column '" + (i + 1) + "': ");
				}
				rowFilled = true;
			}
			row++;
			col = 0;
			rowEmpty = true;
		} while (row < rowsLength && rowEmpty && !rowFilled);
		System.out.println("The row '" + (row) + "' have been filled.");
		System.out.println('\n');
		// return row; and modify void for int to return the first row with all its
		// columns empty.
	}

}
