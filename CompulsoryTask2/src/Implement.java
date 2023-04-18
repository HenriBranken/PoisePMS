import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.Statement;

public class Implement {
	
	static Scanner sc = new Scanner(System.in);
	
	static final String PRESS_ENTER = "Please press ENTER to Continue. . .\n";
	static final String WHAT_TYPE_PERSON = "Which type of person would you like to update?\n" + 
									       "(1) Architect\n" + 
									       "(2) Customer\n" + 
									       "(3) Contractor\n";
	static final String WHAT_OF_PRJ =  "Which field of the selected project would you like to update (Please only choose one option)?\n" + 
								       "(1)  Project Name (prj_name)\n" + 
								       "(2)  Project Due Date (prj_due_dte)\n" + 
								       "(3)  Project Manager Name (pm_name)\n" + 
								       "(4)  Architect Name (archt_name)\n" + 
								       "(5)  Contractor Name (contr_name)\n" + 
								       "(6)  Customer First Name (cust_fname)\n" + 
								       "(7)  Customer Last Name (cust_lname)\n" +
								       "(8)  Structural Engineer Name (struct_eng_name)\n" + 
								       "(9)  Building Type (bldg_type)\n" + 
								       "(10) Physical Address (phys_addr)\n" + 
								       "(11) ERF Number (erf_no)\n" + 
								       "(12) Total Fee (total_fee)\n" + 
								       "(13) Total Paid to Date (total_ptd)\n" +
								       "(14) Status (status)\n" + 
								       "(15) Completion Date (complt_dte)\n";
	static final String FAREWELL = "\nHope to see you soon again. Bye!\n";
	static final String CORRECTION = "\nYou did not enter a valid Menu Item Number. Please try again:\n";
	static final String WRONG_OPT = "You chose an invalid option, please try again. . .\n";
	
	public static void pauseExecution() {
		System.out.println(PRESS_ENTER);
		sc.nextLine();
	}

	/*
	+---------------------------------------------------------+
	|----------[1] Add a new Project to the Database----------|
	+---------------------------------------------------------+
	*/
	/**
	 * A function that adds a new project to the PROJECTS table in the database.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementAddNewPrj(Statement statement) {
		String[] prjData = Capture.captureProject();
		
		String prjName = prjData[0];
		String prjDueDte = prjData[1];
		String pmName = prjData[2];
		String archtName = prjData[3];
		String contrName = prjData[4];
		String custFname = prjData[5];
		String custLname = prjData[6];
		String structEngName = prjData[7];
		String bldgType = prjData[8];
		String physAddr = prjData[9];
		String erfNo = prjData[10];
		String totalFee = prjData[11];
		String totalPtd = prjData[12];
		
		String query;
		
		if (prjName.equalsIgnoreCase("")) {
			query = "INSERT INTO PROJECTS (prj_due_dte, pm_name, archt_name, contr_name, cust_fname, cust_lname, " +
		                          "struct_eng_name, bldg_type, phys_addr, erf_no, total_fee, total_ptd" + ") VALUES " +
					              "('" + prjDueDte + "', '" + pmName + "', '" + archtName + "', '" + contrName + "', '" + 
		                          custFname + "', '" + custLname + "', '" + structEngName + "', '" + bldgType + "', '" + 
					              physAddr + "', " + erfNo +  ", " + totalFee + ", " + totalPtd + ");";
		}
		else {
			query = "INSERT INTO PROJECTS (prj_name, prj_due_dte, pm_name, archt_name, contr_name, cust_fname, cust_lname, " +
                    "struct_eng_name, bldg_type, phys_addr, erf_no, total_fee, total_ptd" + ") VALUES " +
                    "('" + prjName + "', '" + prjDueDte + "', '" + pmName + "', '" + archtName + "', '" + contrName + "', '" + 
                    custFname + "', '" + custLname + "', '" + structEngName + "', '" + bldgType + "', '" + 
                    physAddr + "', " + erfNo +  ", " + totalFee + ", " + totalPtd + ");";
		}
		try {
			SQLFuncs.executeUpdate(statement, query);
			
			System.out.println("You have successfully added a new project to the database.\n");
			pauseExecution();
		}
		catch (SQLException e) {
			System.out.println("Could not add a new project to the database.\nSee the stacktrace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
	}
	
	/*
	+--------------------------------------------------------+
	|----------[2] Add a new Person to the Database----------|
	+--------------------------------------------------------+
	*/
	/**
	 * Add a new person to the database.  The person gets added either to the CUSTOMERS, ARCHITECTS, or CONTRACTORS tables.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementAddNewPerson(Statement statement) {
		String text;
		text  = "What type of person do you want to add?  Please only choose one. (1/2/3)\n";
		text += "(1) Architect\n";
		text += "(2) Customer\n";
		text += "(3) Contractor";
		
		System.out.println(text);
		
		int option = Integer.parseInt(sc.nextLine());
		
		String query;
		if (option == 1) { // 1 -> Architect
			String[] archtData = Capture.captureArchitect(); 
			
			String archtName = archtData[0];
			String archtTelNo = archtData[1];
			String archtEmail = archtData[2];
			String archtPhysAddr = archtData[3];
			
			query = "INSERT INTO ARCHITECTS VALUES " + 
			        "('" + archtName + "', '" + archtTelNo + "', '" + archtEmail + "', '" + archtPhysAddr + "');";
		}
		else if (option == 2) { // 2 -> Customer
			String[] custData = Capture.captureCustomer();
			
			String custFname = custData[0];
			String custLname = custData[1];
			String custTelNo = custData[2];
			String custEmail = custData[3];
			String custPhysAddr = custData[4];
			
			query = "INSERT INTO CUSTOMERS VALUES " + 
					"('" + custFname + "', '" + custLname + "', '" + custTelNo + "', '" + custEmail + "', '" + 
					custPhysAddr + "');";
		}
		else { // 3 -> Contractor
			String[] contrData = Capture.captureContractor(); 
			
			String contrName = contrData[0];
			String contrTelNo = contrData[1];
			String contrEmail = contrData[2];
			String contrPhysAddr = contrData[3];
			
			query = "INSERT INTO CONTRACTORS VALUES " + 
			        "('" + contrName + "', '" + contrTelNo + "', '" + contrEmail + "', '" + contrPhysAddr + "');";	
		}
		try {
			SQLFuncs.executeUpdate(statement, query);
			
			System.out.println("You have successfully added a new person to the database.\n");
			pauseExecution();
		}
		catch (SQLException e) {
			System.out.println("Could not add a new project to the database.  See the stacktrace below:\n");
			e.printStackTrace();
			pauseExecution();
		}					
	}
	
	/*
	+------------------------------------------------------------------+
	|----------[3] Update information about existing projects----------|
	+------------------------------------------------------------------+
	*/
	/**
	 * View the data relating to a specific project, after which the user specifies which field value he would like to change along
	 * with the new value itself.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementUpdateInfo(Statement statement) {
		// Show all the `prj_no` & `prj_name`
		System.out.println("Here are all the `Project Numbers` along with the associated `Project Names` in the Database:\n");
		String query = "SELECT prj_no, prj_name FROM PROJECTS ORDER BY prj_no;";
		
		try {
			SQLFuncs.performSelectPrjNoPrjName(statement, query);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("Could not execute `SQLFuncs.performSelectPrjNoPrjName(statement, query)`\nSee the stack trace below.\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		// Ask the user to specify a project number
		System.out.println("Please enter the Project Number of the project you would like to update:\n");
		String prjNo = sc.nextLine();
		
		// Show all the details for the selected item
		System.out.println("Here is all the detail associated with Project Number = " + prjNo + ".");
		try {
			SQLFuncs.isolateAndPrintPrjRow(statement, prjNo);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("Could not execute `SQLFuncs.isolateAndPrintPrjRow(statement, prjNo);`\nSee the stack trace below.\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		// Ask the user what they want to update
		System.out.println(WHAT_OF_PRJ);
		int theFieldNo = Integer.parseInt(sc.nextLine());
		
		// Initialise three variables that will be populated in the Switch statement below:
		String theFieldName = "";
		String newValue = "";
		boolean boolSingleQuotes = false;
		
		switch (theFieldNo) {
		case 1: // 1 -> Project Name.
			theFieldName = "prj_name";
			newValue = Capture.capturePrjName();
			boolSingleQuotes = true;
			break;
		case 2: // 2 -> Project Due Date.
			theFieldName = "prj_due_dte";
			newValue = Capture.capturePrjDueDte();
			boolSingleQuotes = true;
			break;
		case 3: // 3 -> Project Manager Name
			theFieldName = "pm_name";
			newValue = Capture.capturePmName();
			boolSingleQuotes = true;
			break;
		case 4: // 4 -> Architect Name
			theFieldName = "archt_name";
			newValue = Capture.captureArchtName();
			boolSingleQuotes = true;
			break;
		case 5: // 5 -> Contractor Name.
			theFieldName = "contr_name";
			newValue = Capture.captureContrName();
			boolSingleQuotes = true;
			break;
		case 6: // 6 -> Customer First Name
			theFieldName = "cust_fname";
			newValue = Capture.captureCustFname();
			boolSingleQuotes = true;
			break;
		case 7: // 7 -> Customer Last Name
			theFieldName = "cust_lname";
			newValue = Capture.captureCustLname();
			boolSingleQuotes = true;
			break;
		case 8: // 8 -> Structural Engineer Name
			theFieldName = "struct_eng_name";
			newValue = Capture.captureStructEngName();
			boolSingleQuotes = true;
			break;
		case 9: // 9 -> Building Type
			theFieldName = "bldg_type";
			newValue = Capture.captureBldgType();
			boolSingleQuotes = true;
			break;
		case 10: // 10 -> Physical Address
			theFieldName = "phys_addr";
			newValue = Capture.capturePhysAddr();
			boolSingleQuotes = true;
			break;
		case 11: // 11 -> ERF Number
			theFieldName = "erf_no";
			newValue = Capture.captureErfNo();
			boolSingleQuotes = false;
			break;
		case 12: // 12 -> Total Fee.
			theFieldName = "total_fee";
			newValue = Capture.captureTotalFee();
			boolSingleQuotes = false;
			break;
		case 13: // 13 -> Total Paid To Date.
			theFieldName = "total_ptd";
			newValue = Capture.captureTotalPtd();
			boolSingleQuotes = false;
			break;
		case 14: // 14 -> Status
			theFieldName = "status";
			newValue = Capture.captureStatus();
			boolSingleQuotes = true;
			break;
		case 15: // 15 -> Completion Date.
			theFieldName = "complt_dte";
			newValue = Capture.captureCompltDte();
			boolSingleQuotes = true;
			break;
		}					
		
		// Create a SQL query: UPDATE TABLE_NAME . . . with the help of `theFieldName`, `newValue`, and `prjNo`.
		String query2;
		if (boolSingleQuotes) {
			query2 = "UPDATE PROJECTS SET " + theFieldName + " = '" + newValue + "' WHERE prj_no = " + prjNo + ";";
		}
		else {
			query2 = "UPDATE PROJECTS SET " + theFieldName + " = " + newValue + " WHERE prj_no = " + prjNo + ";";
		}
		
		// Execute the SQL query
		try {
			SQLFuncs.executeUpdate(statement, query2);
			System.out.println("You've successfully made an update to the table.");
			pauseExecution();
		}
		catch (Exception e) {
			System.out.println("The update to the table was NOT carried out due to some error that occurred.");
			e.printStackTrace();
			pauseExecution();
		}
	}
	
	/*
	+------------------------------------------------------------------+
	|-----------[4] Update information about existing people-----------|
	+------------------------------------------------------------------+
	*/
	/**
	 * This function operates on either the CUSTOMERS, ARCHITECTS, or CONTRACTORS tables in the database.
	 * First view all the data pertaining to a specific person, after which the user specifies which field needs to change, along
	 * with the new value itself.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementUpdatePerson(Statement statement) {
		System.out.println(WHAT_TYPE_PERSON);
		int choiceNo = Integer.parseInt(sc.nextLine());
		
		String identifier = "";
		String fname = "";
		String lname = "";
		String fieldName = "";
		String newVal = "";
		String query = "";
		
		switch (choiceNo) {
		case 1: // 1 -> Architect
			try {
				System.out.println("Here is a list of all the `Architect Names`:\n");
				query = "SELECT name FROM ARCHITECTS ORDER BY name;";
				SQLFuncs.performSelectArchtName(statement, query);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.performSelectArchtName(statement, query)`.\nSee the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			System.out.println("Please specify the `name` of the architect you would like to change:\n");
			identifier = sc.nextLine();
			
			System.out.println("Here's all the detail associated with the Architect " + identifier + ":\n");
			try {
				SQLFuncs.isolateAndPrintArchtRow(statement, identifier);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.isolateAndPrintArchtRow(statement, identifier)`." + 
			                       "\nSee the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			
			System.out.println("Please specify which attribute (field name) of the Architect you would like to update:\n"
					           + "name, tel_no, email, phys_addr?\n");
			fieldName = sc.nextLine();
			
			System.out.println("Please specify what the new value of " + fieldName + " should be:\n");
			newVal = sc.nextLine();
			
			query = "UPDATE ARCHITECTS SET " + fieldName + " = '" + newVal + "' WHERE name = '" + identifier + "';";
			
			try {
				SQLFuncs.executeUpdate(statement, query);
				System.out.println("You successfully made an update to the table.\n");
				pauseExecution();				
			}
			catch (Exception e) {
				System.out.println("The update to the table was NOT carried out due to some error that occurred.\n");
				e.printStackTrace();
				pauseExecution();
			}
			
			break;
		case 2: // 2 -> Customer
			try {
				System.out.println("Here is a list of all the `Customer First Names` and associated `Customer Last Names`:\n");
				query = "SELECT fname, lname FROM CUSTOMERS ORDER BY fname, lname;";
				SQLFuncs.performSelectCustName(statement, query);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.performSelectCustName(statement, query);`.\nSee the stack trace below:\n");
				e.printStackTrace();
			}
			System.out.println("Please specify the First Name, `fname`, of the customer you would like to change:\n");
			fname = sc.nextLine();
			
			System.out.println("Please specify the Last Name, `lname`, of the customer you would like to change:\n");
			lname = sc.nextLine();
			
			System.out.println("Here's all the detail associated with the Customer: " + fname + " " + lname + ":\n");
			try {
				SQLFuncs.isolateAndPrintCustRow(statement, fname, lname);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.isolateAndPrintCustRow(statement, fname, lname)`." + 
								   "\nSee the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			
			System.out.println("Please specify which attribute (field name) of the customer you would like to update:\n"
					           + "fname, lname, tel_no, email, phys_addr?\n");
			fieldName = sc.nextLine();
			
			System.out.println("Please specify what the new value should be:\n");
			newVal = sc.nextLine();
			
			query = "UPDATE CUSTOMERS SET " + fieldName + " = '" + newVal + "' WHERE fname = '" + fname +
					"' AND lname = '" + lname + "';";
			
			try {
				SQLFuncs.executeUpdate(statement, query);
				System.out.println("You successfully made an update to the table.\n");
				pauseExecution();				
			}
			catch (Exception e) {
				System.out.println("The update to the table was NOT carried out due to some error that occurred.\n");
				e.printStackTrace();
				pauseExecution();
			}
			break;
		case 3: // 3 -> Contractor
			try {
				System.out.println("Here is a list of all the `Contractors`:\n");
				query = "SELECT name FROM CONTRACTORS ORDER BY name;";
				SQLFuncs.performSelectContrName(statement, query);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.performSelectContrName(statement, query)`.\nSee the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			System.out.println("Please specify the `name` of the contractor you would like to change:\n");
			identifier = sc.nextLine();
			
			System.out.println("Here's all the detail associated with the contractor: " + identifier + ":\n");
			try {
				SQLFuncs.isolateAndPrintContrRow(statement, identifier);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.isolateAndPrintContrRow(statement, identifier)`."  +
								   "\nSee the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			
			System.out.println("Please specify which attribute (field name) of the contractor you would like to update:\n"
					           + "name, tel_no, email, phys_addr?\n");
			fieldName = sc.nextLine();
			
			System.out.println("Please specify what the new value should be:\n");
			newVal = sc.nextLine();
			
			query = "UPDATE CONTRACTORS SET " + fieldName + " = '" + newVal + "' WHERE name = '" + identifier + "';";
			
			try {
				SQLFuncs.executeUpdate(statement, query);
				System.out.println("You successfully made an update to the table.\n");
				pauseExecution();
			}
			catch (Exception e) {
				System.out.println("The update to the table was NOT carried out due to some error that occurred.\n");
				e.printStackTrace();
				pauseExecution();
			}
			break;
		}
	}
	
	/*
	+------------------------------------------+
	|-----------[5] Delete a project-----------|
	+------------------------------------------+
	*/
	/**
	 * Based on the selected project number, delete the associated project from the PROJECTS table.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementDeleteProject(Statement statement) {
		// Show the project numbers & project names to the user.
		// Show all the `prj_no` & `prj_name`
		System.out.println("Here are all the Project Numbers along with all the Project Names in the Database:\n");
		String query = "SELECT prj_no, prj_name FROM PROJECTS ORDER BY prj_no;";
		
		try {
			SQLFuncs.performSelectPrjNoPrjName(statement, query);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.performSelectPrjNoPrjName(statement, query)`."  +
					           "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		// Ask the user to specify a project number
		System.out.println("Enter the project number of the project you would like to delete:\n");
		String prjNo = sc.nextLine();
		
		// Show all the details for the selected item
		System.out.println("Here are all the details associated with \"prj_no = " + prjNo + "\":\n");
		try {
			SQLFuncs.isolateAndPrintPrjRow(statement, prjNo);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.isolateAndPrintPrjRow(statement, prjNo)`."  +
			           		   "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		// Confirm if they want to delete the specified project  >  choice [y/n]
		System.out.println("Are you sure you want to delete the project?  [y/n]:\n");
		String delChoice = sc.nextLine();
		
		String query2 = "";
		if (delChoice.equalsIgnoreCase("y")) {
			query2 = "DELETE FROM PROJECTS WHERE prj_no = " + prjNo + ";";
			try {
				SQLFuncs.executeUpdate(statement, query2);
				System.out.println("You've successfully deleted the specified project from the PROJECTS table.\n");
				pauseExecution();
			}
			catch (Exception e) {
				System.out.println("The specified project could not be deleted due to some error.\n");
				pauseExecution();
			}
		}
		else { // the `delChoice` is "n". 
			System.out.println("The specified project could not be deleted due to some error.\n");
			pauseExecution();
		}
	}
	
	/*
	+--------------------------------------------------------------------------------+
	|-----------[6] Delete a project and all the people associated with it-----------|
	+--------------------------------------------------------------------------------+
	*/
	/**
	 * Based on a selected project number, delete the associated project from the PROJECTS table.  The corresponding architect name,
	 * contractor name, and customer name also gets deleted from the ARCHITECTS, CONTRACTORS, and CUSTOMERS tables.  Therefore no trace
	 * of the project is left behind.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementDeleteProjectAndPeople(Statement statement) {
		// Show the project numbers & project names to the user.
		// Show all the `prj_no` & `prj_name`
		System.out.println("Here are all the Project Numbers along with all the Project Names in the Database:\n");
		String query = "SELECT prj_no, prj_name FROM PROJECTS ORDER BY prj_no;";
		
		try {
			SQLFuncs.performSelectPrjNoPrjName(statement, query);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.performSelectPrjNoPrjName(statement, query)`."  +
	           		   		   "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		// Ask the user to specify a project number
		System.out.println("Enter the project number of the project you would like to delete:\n");
		String prjNo = sc.nextLine();
		
		// Show all the details for the selected project number:
		System.out.println("Here are all the details associated with \"prj_no = " + prjNo + "\":\n");
		try {
			SQLFuncs.isolateAndPrintPrjRow(statement, prjNo);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.isolateAndPrintPrjRow(statement, prjNo)`."  +
    		   		           "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		String[] nameArr = new String[4];
		String archtName = "";
		String contrName = "";
		String custFname = "";
		String custLname = "";
		
		String query2 = "SELECT * FROM PROJECTS WHERE prj_no = " + prjNo + ";";
		try {
			nameArr = Capture.extractPeopleInfo(statement, query2);
		} catch (SQLException e) {
			System.out.println("An error occurred with `Capture.extractPeopleInfo(statement," + 
							  " \"SELECT * FROM PROJECTS WHERE prj_no = \" + prjNo + \";\")`."  +
	   		           		  "\nSee the stack trace below:\n");
			e.printStackTrace();
		}
		archtName = nameArr[0];
		contrName = nameArr[1];
		custFname = nameArr[2];
		custLname = nameArr[3];
		
		System.out.println(Arrays.toString(nameArr));
		
		// Confirm if they want to delete the specified project  >  choice [y/n]
		System.out.println("Are you sure you want to continue with the deletion?  [y/n]:\n");
		String delChoice = sc.nextLine();
		
		String queryPrj = "";
		String queryArcht = "";
		String queryContr = "";
		String queryCust = "";
		if (delChoice.equalsIgnoreCase("y")) {
			queryPrj = "DELETE FROM PROJECTS WHERE prj_no = " + prjNo + ";";
			queryArcht = "DELETE FROM ARCHITECTS WHERE name = '" + archtName + "'";
			queryContr = "DELETE FROM CONTRACTORS WHERE name = '" + contrName + "'";
			queryCust = "DELETE FROM CUSTOMERS WHERE fname = '" + custFname + "' AND lname = '" + custLname + "'";
			try {
				SQLFuncs.executeUpdate(statement, queryPrj);
				SQLFuncs.executeUpdate(statement, queryArcht);
				SQLFuncs.executeUpdate(statement, queryContr);
				SQLFuncs.executeUpdate(statement, queryCust);
				System.out.println("You've successfully deleted the specified project along with all the people associated with it.\n");
				pauseExecution();
			}
			catch (Exception e) {
				System.out.println("The project and associated people could not be deleted from the database due to some error.\n");
				pauseExecution();
			}
		}
		else { // the `delChoice` is "n". 
			System.out.println("The project and associated people could not be deleted from the database due to some error.\n");
			pauseExecution();
		}
	}
	
	/*
	+-----------------------------------------+
	|-----------[7] Delete a person-----------|
	+-----------------------------------------+
	*/
	/**
	 * This method operates on either the ARCHITECTS, CONTRACTORS, or CUSTOMERS table.  Based on the selected person, the associated
	 * row of data gets removed from the table.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementDeletePerson(Statement statement) {
		// What person would they like to delete?  > typeOfPerson
		System.out.println(WHAT_TYPE_PERSON);
		int choiceNo = Integer.parseInt(sc.nextLine());
		
		String identifier = "";
		String fname = "";
		String lname = "";
		String query = "";
		String delChoice = "";
		
		switch (choiceNo) {
		case 1: // 1 -> Architect
			System.out.println("Here is a list of all the `Architect Names`:\n");
			query = "SELECT name FROM ARCHITECTS ORDER BY name;";
			try {
				SQLFuncs.performSelectArchtName(statement, query);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.performSelectArchtName(statement, query)`."  +
		   		                   "\nSee the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			System.out.println("Please specify the `name` of the architect you would like to change:\n");
			identifier = sc.nextLine();
			
			System.out.println("Here's all the detail associated with " + identifier + ":\n");
			try {
				SQLFuncs.isolateAndPrintArchtRow(statement, identifier);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.isolateAndPrintArchtRow(statement, identifier)`."  +
		                           "\nSee the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			
			query = "DELETE FROM ARCHITECTS WHERE name = '" + identifier + "';";
			
			System.out.println("Are you sure you want to delete this person? [y/n]\n");
			delChoice = sc.nextLine();
			
			if (delChoice.equalsIgnoreCase("y")) {
				try {
					SQLFuncs.executeUpdate(statement, query);
					System.out.println("You've successfully deleted the specified person from the associated table.");
					pauseExecution();
				}
				catch (Exception e) {
					System.out.println("The person could not be deleted due to some error.");
					pauseExecution();
				}
			}
			else {
				System.out.println("The person could not be deleted due to some error.");
				pauseExecution();
			}
			break;
		case 2: // 2 -> Customer
			System.out.println("Here is a list of all the `Customer Names`:\n");
			query = "SELECT fname, lname FROM CUSTOMERS ORDER BY fname, lname;";
			try {
				SQLFuncs.performSelectCustName(statement, query);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `Display.printAllFromContractorsTable(statement)`."  +
                                   "  See the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			System.out.println("Please specify the First Name of the customer you would like to delete:\n");
			fname = sc.nextLine();
			System.out.println("Please specify the Last Name of the customer you would like to delete:\n");
			lname = sc.nextLine();
			
			System.out.println("Here's all the detail associated with " + fname + " " + lname + ":\n");
			try {
				SQLFuncs.isolateAndPrintCustRow(statement, fname, lname);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.isolateAndPrintCustRow(statement, fname, lname)`."  +
                                   "See the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			
			query = "DELETE FROM CUSTOMERS WHERE fname = '" + fname + "' AND lname = '" + lname + "';";
			
			System.out.println("Are you sure you want to delete this person? [y/n]\n");
			delChoice = sc.nextLine();
			
			if (delChoice.equalsIgnoreCase("y")) {
				try {
					SQLFuncs.executeUpdate(statement, query);
					System.out.println("You've successfully deleted the specified person from the associated table.");
					pauseExecution();
				}
				catch (Exception e) {
					System.out.println("The person could not be deleted due to some error.");
					pauseExecution();
				}
			}
			else {
				System.out.println("The person could not be deleted due to some error.");
				pauseExecution();
			}
			break;
		case 3: // 3 -> Contractor
			System.out.println("Here is a list of all the `Contractor Names`:\n");
			query = "SELECT name FROM CONTRACTORS ORDER BY name;";
			try {
				SQLFuncs.performSelectContrName(statement, query);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `Display.printAllFromContractorsTable(statement)`."  +
                                   "  See the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			System.out.println("Please specify the `name` of the contractor you would like to delete:\n");
			identifier = sc.nextLine();
			
			System.out.println("Here's all the detail associated with " + identifier + ":\n");
			try {
				SQLFuncs.isolateAndPrintContrRow(statement, identifier);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.isolateAndPrintArchtRow(statement, identifier)`."  +
                                   "See the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
			
			query = "DELETE FROM CONTRACTORS WHERE name = '" + identifier + "';";
			
			System.out.println("Are you sure you want to delete this person? [y/n]");
			delChoice = sc.nextLine();
			
			if (delChoice.equalsIgnoreCase("y")) {
				try {
					SQLFuncs.executeUpdate(statement, query);
					System.out.println("You've successfully deleted the specified person from the associated table.");
					pauseExecution();
				}
				catch (Exception e) {
					System.out.println("The person could not be deleted due to some error.");
					pauseExecution();
				}
			}
			else {  // They do not want to proceed with the deletion.  delChoice is "n".
				System.out.println("The person could not be deleted due to some error.");
				pauseExecution();
			}
			break;
		}
	}
	
	/*
	+------------------------------------------------------+
	|-----------[8] Finalise an existing project-----------|
	+------------------------------------------------------+
	*/
	/**
	 * Finalise a project that has an "ongoing" status.  The status gets changed to "finalised", and a completion date gets added to the project
	 * in the PROJECTS table.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementFinaliseProject(Statement statement) {
		// Show all the ongoing projects:  the prj_no, prj_name, status, complt_date.  WHERE status = 'ongoing'.
		System.out.println("Here is a list of all the \"ongoing\" projects in the database:");
		String query1 = "SELECT prj_no, prj_name, status FROM PROJECTS WHERE status = 'ongoing'";
		try {
			SQLFuncs.performSelectPrjToBeFinalised(statement, query1);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.performSelectPrjToBeFinalised(statement, query1)`."  +
                    		   "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		
		// Specify the project number that needs to be finalised
		System.out.println("Please specify the Project Number of the Project that needs to be finalised:\n");
		String prjNo = sc.nextLine();
		String query2 = "UPDATE PROJECTS SET status = 'finalised' WHERE prj_no = " + prjNo;
		
		// Change the status to 'finalised'
		try {
			SQLFuncs.executeUpdate(statement, query2);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.executeUpdate(statement, query2)`."  +
         		   	   		   "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		// Ask user if they want to use today's date as the completion date?
		System.out.println("Would you like to use today's date as the Completion Date for the selected Project? [y/n]");
		String answer = sc.nextLine();
		
		String query3 = "";
		String query4 = "";
		if (answer.equalsIgnoreCase("y")) {
			try {
				query3 = "UPDATE PROJECTS SET complt_dte = DATE(NOW()) WHERE prj_no = " + prjNo + ";";
				SQLFuncs.executeUpdate(statement, query3);
				pauseExecution();
			}
			catch (Exception e) {
				System.out.println("Could not execute SQLFuncs.executeUpdate(statement, query3)\nSee the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
		}
		else { // User must manually specify the Completion Date in the format of 'YYYY-MM-DD'.
			System.out.println("In the format of 'YYYY-MM-DD', what should the Completion Date be?");
			String compltDte = sc.nextLine();
			query4 = "UPDATE PROJECTS SET complt_dte = '" + compltDte + "' WHERE prj_no = " + prjNo + ";";
			try {
				SQLFuncs.executeUpdate(statement, query4);
				pauseExecution();
			} catch (SQLException e) {
				System.out.println("An error occurred with `SQLFuncs.executeUpdate(statement, query4)`."  +
  		   	   		   			   "\nSee the stack trace below:\n");
				e.printStackTrace();
				pauseExecution();
			}
		}
	}
	
	/*
	+----------------------------------------------------------------------+
	|-----------[11] Select and show a project by project number-----------|
	+----------------------------------------------------------------------+
	*/
	/**
	 * Select a certain project number, and then from that number display all the other information related to the specific project.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementShowByPrjNo(Statement statement) {
		// Show all the `prj_no` & `prj_name`
		System.out.println("Here are all the Project Numbers along with all the Project Names in the Database:\n");
		String query = "SELECT prj_no, prj_name FROM PROJECTS ORDER BY prj_no;";
		
		try {
			SQLFuncs.performSelectPrjNoPrjName(statement, query);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.performSelectPrjNoPrjName(statement, query)`."  +
	   		   			       "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		// Ask the user to specify a project number
		System.out.println("Enter the project number of the project you would like to see:\n");
		String prjNo = sc.nextLine();
		
		try {
			SQLFuncs.isolateAndPrintPrjRow(statement, prjNo);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.isolateAndPrintPrjRow(statement, prjNo)`."  +
	   			               "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
	}
	
	/*
	+--------------------------------------------------------------------+
	|-----------[12] Select and show a project by project name-----------|
	+--------------------------------------------------------------------+
	*/
	/**
	 * Select a certain project name, and then from that name display all the other information related to the specific project.
	 * @param statement A Direct Line to the database for running our queries.
	 */
	public static void implementShowByPrjName(Statement statement) {
		// Show all the `prj_no` & `prj_name`
		System.out.println("Here are all the Project Numbers along with all the Project Names in the Database:\n");
		String query = "SELECT prj_no, prj_name FROM PROJECTS ORDER BY prj_no;";
		
		try {
			SQLFuncs.performSelectPrjNoPrjName(statement, query);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.performSelectPrjNoPrjName(statement, query)`."  +
		               		   "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
		
		// Ask the user to specify a project number
		System.out.println("Enter the Project Name of the project you would like to see:\n");
		String prjName = sc.nextLine();
		
		try {
			SQLFuncs.isolateAndPrintPrjRow(statement, prjName);
			pauseExecution();
		} catch (SQLException e) {
			System.out.println("An error occurred with `SQLFuncs.isolateAndPrintPrjRow(statement, prjName)`."  +
            		   		   "\nSee the stack trace below:\n");
			e.printStackTrace();
			pauseExecution();
		}
	}
	
	/*
	+--------------------------------------------+
	|-----------[0] Exit the main menu-----------|
	+--------------------------------------------+
	*/
	/**
	 * Exit the main menu and terminate the program.
	 * To go back to the main menu, the user would need to run the project again.
	 */
	public static void implementExitProgram() {
		System.out.println(FAREWELL);
	}
	
	/*
	+----------------------------------------+
	|-----------Invalid User Input-----------|
	+----------------------------------------+
	*/
	/**
	 * The user entered something other than a number in the range of [0; 12].
	 * The user gets taken back to the main menu.
	 */
	public static void implementInvalidInput() {
		System.out.println(CORRECTION);
		pauseExecution();
	}
}
