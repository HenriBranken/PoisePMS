import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * A module that that contains functionality to perform various SELECT queries, executeUpdate queries, and other queries for isolating
 * an entity in a table and displaying it to the console.
 * @author Henri Branken
 *
 */
public class SQLFuncs {
	
	static final String PAUSE_MSG = "\nPlease press ENTER to continue.\n";
	static final String ISOLATE_ERR = "A problem occurred while trying to isolate a row from a table.\n";
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * A method that implements the `.executeUpdate()` method to bring alterations to a Table.
	 * Via this method, we can perform the following SQL functionality: (1) INSERT INTO TABLE_NAME . . ., (2) UPDATE TABLE_NAME . . ., and
	 * (3) DELETE FROM TABLE_NAME . . .
	 * @param query The SQL query to be executed.
	 * @param statement A Direct Line to the database for running our queries.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static void executeUpdate(Statement statement, String query) throws SQLException {
		try {
			// Try executing the SQL `query`.
			int rowsAffected = statement.executeUpdate(query);
			
			// Print out the number of rows, if any, affected by the SQL query execution.
			System.out.println("Query Complete, " + rowsAffected + " rows affected.\n");
		}
		
		catch (SQLException e) {
			System.out.println("An error occurred while trying to `executeUpdate` the following SQL Query:\n" + 
						       query + ".\n" + 
							   "See the stack trace below:\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * A function that displays all the Project Numbers and Project Names from the PROJECTS table in the format of
	 * prj_no -> prj_name.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SELECT query on the PROJECTS table.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
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
	
	/**
	 * A function that displays all the architect names beneath each other.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SELECT query on the ARCHITECTS table.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static void performSelectArchtName(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				text = resultSet.getString("name");
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
	
	/**
	 * A function that displays all the Customer Names beneath each other.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SELECT query on the CUSTOMERS table.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static void performSelectCustName(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				text = resultSet.getString("fname") + " " + resultSet.getString("lname");
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
	
	/**
	 * A function that displays all the contractor names beneath each other.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SELECT query on the CONTRACTORS table.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static void performSelectContrName(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				text = resultSet.getString("name");
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
	
	/**
	 * A function that displays all remaining projects that still needs to be finalised.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SELECT query on the PROJECTS table.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static void performSelectPrjToBeFinalised(Statement statement, String query) throws SQLException {
		try {
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String text;
				text = resultSet.getInt("prj_no") + " -> " + resultSet.getString("prj_name") + ", " + resultSet.getString("status") + ".";
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
	
	/**
	 * A function that displays all the details of projects living in the PROJECTS table.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SELECT query on the PROJECTS table.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
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
	
	/**
	 * A function that displays all the details of certain rows in the ARCHITECTS table.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SELECT query on the ARCHITECTS table.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
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
	
	/**
	 * A function that displays all the details of certain Customers living in the CUSTOMERS table.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SELECT query on the CUSTOMERS table.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
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
	
	/**
	 * A function that displays all the details of certain Contractors living in the CONTRACTORS table.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SELECT query on the CONTRACTORS table.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
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
	
	/**
	 * A function that prints all the details of one specific project, indicated by identifier, to the console.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param identifier A String variable which is either the Project Number or the Project Name used in the SQL filtering.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static void isolateAndPrintPrjRow(Statement statement, String identifier) throws SQLException {
		String query;
		
		int theInt;
		
		try {
			theInt = Integer.parseInt(identifier);
			// If the parsing is successful, then `identifier` has to be an Integer, in this case the Project Id.
			query = "SELECT * FROM PROJECTS WHERE prj_no = " + theInt;
		}
		catch (NumberFormatException e) {
			// `identifier` has to be a String.  In this case, the Project Name.
			query = "SELECT * FROM PROJECTS WHERE prj_name = '" + identifier + "';";
		}
		
		try {
			// Isolate the project entry of interest, and display it to the user on the console.			
			System.out.println("\nThe Project entry of interest is as follows:\n");
			
			performSelectProjects(statement, query);				
		}
		catch (SQLException e) {
			System.out.println(ISOLATE_ERR);
			e.printStackTrace();
		}
	}
	
	/**
	 * A function that displays all the details of one specific Architect as indicated by the archtName variable.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param archtName The Name of the Architect.  This is used in the SQL filtering to isolate one row.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static void isolateAndPrintArchtRow(Statement statement, String archtName) throws SQLException {
		String query;

		query = "SELECT * FROM ARCHITECTS WHERE name = '" + archtName + "';";
		
		try {
			// Isolate the architect entry of interest, and display it to the user on the console.
			System.out.println("\nThe Architect entry of interest is as follows:\n");
			performSelectArchitects(statement, query);
		}
		catch (SQLException e) {
			System.out.println(ISOLATE_ERR);
			e.printStackTrace();
		}
	}
	
	/**
	 * A function that displays all the details of one specific customer, as indicated by the `fname` and `lname` parameters.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param fName The first name of the customer.  This is used in the SQL filtering WHERE statement.
	 * @param lName The Last Name of the customer.  This is used in the SQL filtering WHERE statement.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static void isolateAndPrintCustRow(Statement statement, String fName, String lName) throws SQLException {
		String query;

		query = "SELECT * FROM CUSTOMERS WHERE fname = '" + fName + "'" + " AND lname = '" + lName + "';";
		
		try {
			// Isolate the architect entry of interest, and display it to the user on the console.			
			System.out.println("\nThe Customer Entry of interest is as follows:\n");
			
			performSelectCustomers(statement, query);
		}
		catch (SQLException e) {
			System.out.println(ISOLATE_ERR);
			e.printStackTrace();
		}
	}
	
	/**
	 * A function that displays all the details of one specific Contractor, as indicated by the `contrName` parameter.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param contrName The name of the contractor used in the SQL filtering WHERE clause.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static void isolateAndPrintContrRow(Statement statement, String contrName) throws SQLException {
		String query;

		query = "SELECT * FROM CONTRACTORS WHERE name = '" + contrName + "';";
		
		try {
			// Isolate the architect entry of interest, and display it to the user on the console.			
			System.out.println("\nThe Contractor Entry of Interest is as follows:\n");
			
			performSelectContractors(statement, query);
		}
		catch (SQLException e) {
			System.out.println(ISOLATE_ERR);
			e.printStackTrace();
		}
	}
}
