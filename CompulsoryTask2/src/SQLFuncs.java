import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SQLFuncs {
	
	static final String PAUSE_MSG = "\nPlease press ENTER to continue.\n";
	static final String ISOLATE_ERR = "A problem occurred while trying to isolate a row from a table.\n";
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * A method that implements the `.executeUpdate()` method to bring alterations to the Table, or to display it in a certain format.
	 * Via this method, we can perform the following SQL functionality: (1) INSERT INTO TABLE_NAME . . ., (2) UPDATE TABLE_NAME . . ., and
	 * (3) DELETE FROM TABLE_NAME . . .
	 * @param query The SQL query to be executed.
	 * @param statement A Direct Line to the database for running our queries.
	 * @throws SQLException Could not execute the SQL query for some reason.  See the error Stack Trace.
	 */
	public static void executeUpdate(Statement statement, String query) throws SQLException {
		try {
			// Try executing the SQL `query`.
			int rowsAffected = statement.executeUpdate(query);
			
			// Print out the number of rows, if any, affected by the SQL query execution.
			System.out.println("Query Complete, " + rowsAffected + " rows affected.\n");
			
			System.out.println(PAUSE_MSG);
			sc.nextLine();
		}
		
		catch (SQLException e) {
			System.out.println("An error occurred while trying to `executeUpdate` the following SQL Query:\n" + 
						       query + ".\n" + 
							   "See the stack trace below:\n");
			e.printStackTrace();
		}
	}
	
	public static void performSelectPrjNoPrjName(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				text = resultSet.getInt("prj_no") + " -> " + resultSet.getString("prj_name");
				System.out.println(text);
			}
		}
		catch (SQLException e) {
			System.out.println("An error occurred while trying to `executeQuery` the following SQL Query:\n" + 
	       			           query + ".\n" + 
		   			           "See the stack trace below:\n");
			e.printStackTrace();
		}
	}
	
	public static void performSelectPrjToBeFinalised(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				text = resultSet.getInt("prj_no") + ", " + resultSet.getString("prj_name") + ", " + resultSet.getString("status") + ".";
				System.out.println(text);
			}
		}
		catch (SQLException e) {
			System.out.println("An error occurred while trying to `executeQuery` the following SQL Query:\n" + 
	       			           query + ".\n" + 
		   			           "See the stack trace below:\n");
			e.printStackTrace();
		}
	}
	
	public static void performSelectProjects(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				text  = "Project Number: " + resultSet.getInt("prj_no") + "\n";
				text += "Project Name:  " + resultSet.getString("prj_name") + "\n";
				text += "Project Due Date:  " + resultSet.getDate("prj_due_dte") + "\n";
				text += "Project Manager Name:  " + resultSet.getString("pm_name") + "\n";
				text += "Architect Name:  " + resultSet.getString("archt_name") + "\n";
				text += "Contractor Name:  " + resultSet.getString("contr_name") + "\n";
				text += "Customer First Name:  " + resultSet.getString("cust_fname") + "\n";
				text += "Customer Surname:  " + resultSet.getString("cust_lname") + "\n";
				text += "Structural Engineer Name:  " + resultSet.getString("struct_eng_name") + "\n";
				text += "Building Type:  " + resultSet.getString("bldg_type") + "\n";
				text += "Physical Address:  " + resultSet.getString("phys_addr") + "\n";
				text += "ERF Number:  " + resultSet.getInt("erf_no") + "\n";
				text += "Total Fee:  " + resultSet.getDouble("total_fee") + "\n";
				text += "Total Paid to Date:  " + resultSet.getDouble("total_ptd") + "\n";
				text += "Status:  " + resultSet.getString("status") + "\n";
				text += "Completion Date:  " + resultSet.getDate("complt_dte") + "\n";
				text += Display.SEPARATOR + "\n";
				
				System.out.println(text);
			}
		}
		catch (SQLException e) {
			System.out.println("An error occurred while trying to `executeQuery` the following SQL Query:\n" + 
				       			query + ".\n" + 
					   			"See the stack trace below:\n");
			e.printStackTrace();
		}
	}	
	
	public static void performSelectArchitects(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				
				text  = "Architect Name:  " + resultSet.getString("name") + "\n";
				text += "Architect Phone Number:  " + resultSet.getString("tel_no") + "\n";
				text += "Architect Email:  " + resultSet.getString("email") + "\n";
				text += "Architect Physical Address:  " + resultSet.getString("phys_addr") + "\n";
				text += Display.SEPARATOR + "\n";
				System.out.println(text);
			}
		}
		catch (SQLException e) {
			System.out.println("An error occurred while trying to `executeQuery` the following SQL Query:\n" + 
				       			query + ".\n" + 
					   			"See the stack trace below:\n");
			e.printStackTrace();
		}
	}
	
	public static void performSelectCustomers(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				
				text  = "Customer Name:  " + resultSet.getString("fname") + " " + resultSet.getString("lname") + "\n";
				text += "Customer Phone Number:  " + resultSet.getString("tel_no") + "\n";
				text += "Customer Email:  " + resultSet.getString("email") + "\n";
				text += "Customer Physical Address:  " + resultSet.getString("phys_addr") + "\n";
				text += Display.SEPARATOR + "\n";
				System.out.println(text);
			}
		}
		catch (SQLException e) {
			System.out.println("An error occurred while trying to `executeQuery` the following SQL Query:\n" + 
				       			query + ".\n" + 
					   			"See the stack trace below:\n");
			e.printStackTrace();
		}
	}
	
	public static void performSelectContractors(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				
				text  = "Contractor Name:  " + resultSet.getString("name") + "\n";
				text += "Contractor Phone Number:  " + resultSet.getString("tel_no") + "\n";
				text += "Contractor Email:  " + resultSet.getString("email") + "\n";
				text += "Contractor Physical Address:  " + resultSet.getString("phys_addr") + "\n";
				text += Display.SEPARATOR + "\n";
				System.out.println(text);
			}
		}
		catch (SQLException e) {
			System.out.println("An error occurred while trying to `executeQuery` the following SQL Query:\n" + 
				       			query + ".\n" + 
					   			"See the stack trace below:\n");
			e.printStackTrace();
		}
	}
	
	public static void isolateAndPrintPrjRow(Statement statement, String identifier) throws SQLException {
		String query;
		
		int theInt;
		
		try {
			theInt = Integer.parseInt(identifier);
			// If the parsing is successful, then `identifier` has to be an Integer, in this case the Project Id.
			query = "SELECT * FROM PROJECTS WHERE prj_id = " + theInt;
		}
		catch (NumberFormatException e) {
			// `identifier` has to be a String.  In this case, the Project Name.
			query = "SELECT * FROM PROJECTS WHERE prj_name = " + identifier;
		}
		
		try {
			// Isolate the project entry of interest, and display it to the user on the console.			
			System.out.println("\nThe Project entry of interest is as follows:\n");
			
			performSelectProjects(statement, query);				
			// The user must press ENTER to continue
			System.out.println(PAUSE_MSG);
			sc.nextLine();
		}
		catch (SQLException e) {
			System.out.println(ISOLATE_ERR);
			e.printStackTrace();
		}
	}
	
	public static void isolateAndPrintArchtRow(Statement statement, String archt_name) throws SQLException {
		String query;

		query = "SELECT * FROM ARCHITECTS WHERE archt_name = " + archt_name;
		
		try {
			// Isolate the architect entry of interest, and display it to the user on the console.			
			System.out.println("\nThe Architect entry of interest is as follows:\n");
			
			performSelectArchitects(statement, query);				
			// The user must press ENTER to continue
			System.out.println(PAUSE_MSG);
			sc.nextLine();
		}
		catch (SQLException e) {
			System.out.println(ISOLATE_ERR);
			e.printStackTrace();
		}
	}
	
	public static void isolateAndPrintCustRow(Statement statement, String fname, String lname) throws SQLException {
		String query;

		query = "SELECT * FROM CUSTOMERS WHERE fname = " + fname + " AND lname = " + lname;
		
		try {
			// Isolate the architect entry of interest, and display it to the user on the console.			
			System.out.println("\nThe Customer Entry of interest is as follows:\n");
			
			performSelectCustomers(statement, query);		
			// The user must press ENTER to continue
			System.out.println(PAUSE_MSG);
			sc.nextLine();
		}
		catch (SQLException e) {
			System.out.println(ISOLATE_ERR);
			e.printStackTrace();
		}
	}
	
	public static void isolateAndPrintContrRow(Statement statement, String contr_name) throws SQLException {
		String query;

		query = "SELECT * FROM CUSTOMERS WHERE contr_name = " + contr_name;
		
		try {
			// Isolate the architect entry of interest, and display it to the user on the console.			
			System.out.println("\nThe Contractor Entry of Interest is as follows:\n");
			
			performSelectContractors(statement, query);				
			// The user must press ENTER to continue
			System.out.println(PAUSE_MSG);
			sc.nextLine();
		}
		catch (SQLException e) {
			System.out.println(ISOLATE_ERR);
			e.printStackTrace();
		}
	}
}
