import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The PoisePMS module.  This is the main driver code for the Database Application.
 * @author Henri Branken
 *
 */
public class PoisePMS { 
	static final String DATABASE = "PoisePMS";
	static final String TABLE_NAME = "projects";
	static final String PORT_NUMBER = "3306";
	static final String CONNECTION_URL = "jdbc:mysql://localhost:" + PORT_NUMBER + "/" + DATABASE + "?useSSL=false";
	static final String USER_NAME = "otheruser";
	static final String PWD = "swordfish";
	static final String MENU = "\nPlease select a Menu Item Number follwed by pressing ENTER:\n" +
							   "[1]  Add a new Project to the Database\n" + 
							   "[2]  Add a new Person to the Database\n" + 
							   "[3]  Update information about existing projects\n" +
							   "[4]  Update information about existing people\n" +
							   "[5]  Delete a project\n" +
							   "[6]  Delete a project and all the people associated with it\n" +
							   "[7]  Delete a person\n" +
							   "[8]  Finalize an existing project\n" +
							   "[9]  Show unfinished projects\n" +
							   "[10] Show projects that are past their due date\n" +
							   "[11] Select and show a project by project number\n" +
							   "[12] Select and show a project by project name\n" +
							   "[0]  Exit the main menu\n";	
	// The driver code:
	/**
	 * The driver code.  For each `while` iteration, the `MENU` is displayed to the user.
	 * From that, the user needs to select which option he would like to proceed with, and then press ENTER.
	 * @param args Not Applicable.
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException{
		try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PWD);
			 Statement statement = connection.createStatement();
			 Scanner sc = new Scanner(System.in);)
		{
			// Initialise a negative `userInput` integer.
			// Keep iterating the `while` loop until `userInput` becomes 0 (i.e. the user wants to exit).
			int userInput = -1;
			while (userInput != 0) {
				System.out.println(MENU);
				userInput = Integer.parseInt(sc.nextLine());
				
				/*
				+---------------------------------------------------------+
				|----------[1] Add a new Project to the Database----------|
				+---------------------------------------------------------+
				*/				
				if (userInput == 1) {
					Implement.implementAddNewPrj(statement);
				}
				
				/*
				+--------------------------------------------------------+
				|----------[2] Add a new Person to the Database----------|
				+--------------------------------------------------------+
				*/	
				else if (userInput == 2) {
					Implement.implementAddNewPerson(statement);
				}
				/*
				+------------------------------------------------------------------+
				|----------[3] Update information about existing projects----------|
				+------------------------------------------------------------------+
				*/
				else if (userInput == 3) {
					Implement.implementUpdateInfo(statement);
				}
				/*
				+------------------------------------------------------------------+
				|-----------[4] Update information about existing people-----------|
				+------------------------------------------------------------------+
				*/
				else if (userInput == 4) {
					// What person would they like to update?  > typeOfPerson
					Implement.implementUpdatePerson(statement);
				}
				/*
				+------------------------------------------+
				|-----------[5] Delete a project-----------|
				+------------------------------------------+
				*/
				else if (userInput == 5) {
					Implement.implementDeleteProject(statement);
				}
				/*
				+--------------------------------------------------------------------------------+
				|-----------[6] Delete a project and all the people associated with it-----------|
				+--------------------------------------------------------------------------------+
				*/
				else if (userInput == 6) {
					Implement.implementDeleteProjectAndPeople(statement);
				}
				/*
				+-----------------------------------------+
				|-----------[7] Delete a person-----------|
				+-----------------------------------------+
				*/
				else if (userInput == 7) {
					Implement.implementDeletePerson(statement);
				}
				/*
				+------------------------------------------------------+
				|-----------[8] Finalise an existing project-----------|
				+------------------------------------------------------+
				*/
				else if (userInput == 8) {
					Implement.implementFinaliseProject(statement);
				}
				/*
				+--------------------------------------------------+
				|-----------[9] Show Unfinished Projects-----------|
				+--------------------------------------------------+
				*/
				else if (userInput == 9) {
					Display.printUnfinishedProjects(statement);
					Implement.pauseExecution();
				}
				/*
				+---------------------------------------------------------------------+
				|-----------[10] Show Projects that are Past their Due Date-----------|
				+---------------------------------------------------------------------+
				*/
				else if (userInput == 10) {
					Display.printPastDueDate(statement);
					Implement.pauseExecution();
				}
				/*
				+----------------------------------------------------------------------+
				|-----------[11] Select and show a project by project number-----------|
				+----------------------------------------------------------------------+
				*/
				else if (userInput == 11) {
					Implement.implementShowByPrjNo(statement);
				}
				/*
				+--------------------------------------------------------------------+
				|-----------[12] Select and show a project by project name-----------|
				+--------------------------------------------------------------------+
				*/
				else if (userInput == 12) {
					Implement.implementShowByPrjName(statement);
				}
				/*
				+--------------------------------------------+
				|-----------[0] Exit the main menu-----------|
				+--------------------------------------------+
				*/
				else if (userInput == 0) {
					Implement.implementExitProgram();
					break;
				}
				/*
				+----------------------------------------+
				|-----------Invalid User Input-----------|
				+----------------------------------------+
				*/
				else {
					Implement.implementInvalidInput();
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Some error has occured.  See the Stack Trace below:\n");
			e.printStackTrace();
		}
	}
}