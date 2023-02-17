package practica1_MarcelinoGil;

/**
 * @description This is the main class where all the functions are called and
 *              user can perform different operations.
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 14/02/2023
 */
public class CRUDArray {
	/**
	 * @description Main method that executes the program. There are 4 main options:
	 *              Create, Read, Update, Delete. There is another optiop to finish
	 *              de program.
	 * @param args
	 */
	
	public static void main(String[] args) {

		// This 2d array is initialiced to test the database.

		String[][] product = new String[20][4];
		
		// INICIALIZACIÓN PAR PRUEBAS
		//String[][] product = {{"",""},{" ","1", "hola"},{"1","1", "pepe"},{"3","1", "lola", "pepe"},{"2","1", "lola", "pepe", "juana"}};

		// The selector for the main menu.
		int mainMenuChoice;
		// The selector for the sub menus.
		int menuChoice;
		// Another selector to confirm operations.
		char doSomethingElse = ' ';

		/*
		 * This do/while loop will keep asking the user what to do until the user exits.
		 */
		do {

			// Menu with the availeable options.
			Utilities.mainMenu();

			// Returns the option chosen by the user.
			mainMenuChoice = Utilities.getIntBetween(1, 5, "Select your choice");

			/*
			 * This is the main switch. Each option (execept exit) contain a certain number
			 * of different functionalities.
			 */
			switch (mainMenuChoice) {

			case 1:
				// CREATE

				// Request and return the desired option
				menuChoice = Utilities.getIntBetween(1, 5,
						"Press '1' to set rows and columns quantity. \nPress '2' to fill a row. \nPress '3' to fill all empty rows. \nPress '4' to fill all the table. \nPress '5' to exit.");

				switch (menuChoice) {

				case 1:
					// To create a new empty two-dimensional array of strings. The user chooses the
					// number of rows and columns.
					product = CreateUtilities.create2DArray(product);
					break;

				case 2:
					// To add data in the first empty row
					CreateUtilities.fillFirstEmptyRow(product);
					break;

				case 3:
					// To write data in all the empty rows.
					CreateUtilities.fillAllEmptyRows(product);
					break;

				case 4:
					// To fill every row and column of the database.
					CreateUtilities.fillAllTheArray(product); // REVISAR MENSAJES CONSOLA
					break;

				case 5:
					// Exits sub menu
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 2:
				// READ

				// Request and return the desired option
				menuChoice = Utilities.getIntBetween(1, 4,
						"Press '1' to find the first coincidence. \nPress '2' to find all the coincidences. \nPress '3' to show the whole database. \nPress '4' to exit");
				switch (menuChoice) {

				case 1:
					// Reads the first match of a requested data.
					ReadUtilities.findFirstMatch(product, Utilities.getString("What do you want to find?"));
					break;

				case 2:
					// Reads all the matches of a requested data
					ReadUtilities.findAllMatches(product, Utilities.getString("What do you want to find?"));
					break;

				case 3:
					// Shows the whole database.
					ReadUtilities.showAllData(product);
					break;

				case 4:
					// Exits sub menu.
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 3:
				// UPDATE

				// Request and return the desired option
				menuChoice = Utilities.getIntBetween(1, 3,
						"Press '1' to update a specific row. \nPress '2' to update all the matches for your data request\nPress '3' to exit.");
				switch (menuChoice) {

				case 1:
					// Modifies data in the row selected by user.
					UpdateUtilities.updateRow(product);
					break;

				case 2:
					// To overwrite data in all the rows that match what user is looking for.
					UpdateUtilities.updateAllMatches(product,
							Utilities.getString("What do you want to find and update?"));
					break;

				case 3:
					// Exits sub menu.
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 4:
				// DELETE

				// Request and return the desired option.
				menuChoice = Utilities.getIntBetween(1, 5,
						"Press '1' to remove a row. \nPress '2' to remove all the matches. \nPress '3' to remove every field. \nPress '4' to restart the database. \nPress '5' to exit.");
				switch (menuChoice) {

				case 1:
					// Gives the option to remove a specific row.
					DeleteUtilities.deleteRow(product);
					break;

				case 2:
					// Gives the option to delete the row data in each row where a match occurred.
					DeleteUtilities.deleteAllMatches(product, Utilities.getString("What do you want to delete?"));
					break;

				case 3:
					// Sets the value of each column in each row to 'null'.
					DeleteUtilities.clear2DArray(product);
					break;

				case 4:
					// To erase database.
					product = DeleteUtilities.eraseDatabase(1, 4, product);
					break;
				case 5:
					// Exits sub menu.
					break;

				default:
					// I don't find any chance of getting an invalid value. But just in case.
					break;
				}

				// The user is given the option to execute another task on the database.
				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to do something else?");
				if (doSomethingElse == 'n') {
					mainMenuChoice = 5;
				}
				break;

			case 5:
				// EXIT
				break;

			default:
				// I don't find any chance of getting an invalid value. But just in case:
				break;
			}

		} while (mainMenuChoice != 5);
		System.out.println('\n');
		System.out.println("\u001B[31m" + "+--PROGRAM SHUTDOWN--+");
		System.out.println('\n');
		System.out.println('\n');
	}

}
