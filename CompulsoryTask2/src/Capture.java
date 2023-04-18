import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * A module that includes all the functionality to capture input from the user typing on the keyboard.
 * These various input values are then returned to the calling functions in `Implementations.java`.
 * @author Henri Branken
 *
 */
public class Capture {
	
	static final String NEW_PRJ_NAME = "What is the Project Name (prj_name)?\n";
	static final String NEW_PRJ_DUE_DTE = "What is the Project Due Date in the format of 'YYYY-MM-DD'? (prj_due_dte)\n";
	static final String NEW_PM_NAME = "What is the Project Manager's name (pm_name)?\n";
	static final String NEW_ARCHT_NAME = "What is the Architect's name (archt_name)?\n";
	static final String NEW_CONTR_NAME = "What is the Contractor's name (contr_name)?\n";
	static final String NEW_CUST_FNAME = "What is the Customer's First Name (cust_fname)?\n";
	static final String NEW_CUST_LNAME = "What is the Customer's Last Name (cust_lname)?\n";
	static final String NEW_STRUCT_ENG_NAME = "What is the name of the Structural Engineer (struct_eng_name)?\n";
	static final String NEW_BLDG_TYPE = "What type of building is it (bldg_type)?\n";
	static final String NEW_PHYS_ADDR = "What is the Physical Address (phys_addr)?\n";
	static final String NEW_ERF_NO = "What is the ERF number? (erf_no)\n";
	static final String NEW_TOTAL_FEE = "What is the Total Fee in ZAR (total_fee)?\n";
	static final String NEW_TOTAL_PTD = "What is the Total Amount Paid to Date in ZAR (total_ptd)?\n";
	static final String NEW_STATUS = "What is the new Status of the Project (status)?\n";
	static final String NEW_COMPLT_DTE = "What is the new Completion Date in the format of YYYY-MM-DD? (complt_dte)?\n";
	static final String NEW_ARCHT_TEL_NO = "What is the telephone number of the architect? (archt_tel_no)?\n";
	static final String NEW_ARCHT_EMAIL = "What is the email address of the architect? (archt_email)\n";
	static final String NEW_ARCHT_PHYS_ADDR = "What is the physical address of the architect? (archt_phys_addr)\n";
	static final String NEW_CUST_TEL_NO = "What is the telephone number of the customer? (cust_tel_no)?\n";
	static final String NEW_CUST_EMAIL = "What is the email address of the customer? (archt_email)\n";
	static final String NEW_CUST_PHYS_ADDR = "What is the physical address of the customer? (cust_phys_addr)\n";
	static final String NEW_CONTR_TEL_NO = "What is the telephone number of the contractor? (contr_tel_no)?\n";
	static final String NEW_CONTR_EMAIL = "What is the email address of the contractor? (archt_email)\n";
	static final String NEW_CONTR_PHYS_ADDR = "What is the physical address of the contractor? (contr_phys_addr)\n";
	
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Extract the architect name, contractor name, and customer name that are related to a specific project.
	 * @param statement A Direct Line to the database for running our queries.
	 * @param query A SQL query that filters one specific row in the PROJECTS table, and shows it to us.
	 * @return Return a String Array that contains the architect name, contractor name, customer first name, and customer last name.
	 * @throws SQLException Could not execute the SQL query and generate results due to some sort of error.
	 */
	public static String[] extractPeopleInfo(Statement statement, String query) throws SQLException {
		String archt_name = "";
		String contr_name = "";
		String cust_fname = "";
		String cust_lname = "";
		
		String[] nameArr = new String[4];
		try {
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			
			archt_name = resultSet.getString("archt_name");
			contr_name = resultSet.getString("contr_name");
			cust_fname = resultSet.getString("cust_fname");
			cust_lname = resultSet.getString("cust_lname");
			
			nameArr[0] = archt_name;
			nameArr[1] = contr_name;
			nameArr[2] = cust_fname;
			nameArr[3] = cust_lname;

			return nameArr;
		}
		catch (SQLException e) {
			System.out.println("An error occurred while trying to `executeQuery` the following SQL Query:\n" + 
				       			query + "\n" + 
					   			"See the stack trace below:\n");
			e.printStackTrace();
			return nameArr;
		}
	}
	
	/**
	 * Prompt the user to input a new Project Name.
	 * @return The project entered by the user gets returned to the calling function.
	 */
	public static String capturePrjName() {
		// Initialise an empty `id` string.
		String prjName = "";
		
		System.out.println("Do you want to use the DEFAULT value for Project Name? [y/n]");
		String choice = sc.nextLine();
		
		if (choice.equalsIgnoreCase("y")) {
			return prjName;
		}
		else {
			String correct = "n";
			while (correct.equalsIgnoreCase("n")) {
				System.out.println(NEW_PRJ_NAME);
				prjName = sc.nextLine();
				System.out.println("Are you happy with \"prj_name = " + prjName + "\"? [y/n]");
				correct = sc.nextLine();
			}
			return prjName;
		}
	}
	
	/**
	 * Prompt the user to enter a new Project Due Date for a certain project.
	 * @return The due date entered by the user gets returned to the calling function.
	 */
	public static String capturePrjDueDte() {
		// Initialise an empty PrjDueDte:
		String prjDueDte = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_PRJ_DUE_DTE);
			prjDueDte = sc.nextLine();
			System.out.println("Are you happy with \"prj_due_dte = " + prjDueDte + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return prjDueDte;
	}
	
	/**
	 * Prompt the user to enter a new project manager name for a certain project.
	 * @return The project manager name entered by the user gets returned to the calling function.
	 */
	public static String capturePmName() {
		// Initialise an empty pmName:
		String pmName = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_PM_NAME);
			pmName = sc.nextLine();
			System.out.println("Are you happy with \"pm_name = " + pmName + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return pmName;
	}
	
	/**
	 * Prompt the user to enter the Architect Name related to a specific project.
	 * @return The architect name entered by the user gets returned to the calling function.
	 */
	public static String captureArchtName() {
		// Initialise an empty archtName:
		String archtName = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_ARCHT_NAME);
			archtName = sc.nextLine();
			System.out.println("Are you happy with \"archt_name = " + archtName + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return archtName;
	}
	
	/**
	 * Prompt the user to enter the Contractor Name related to a specific project.
	 * @return The contractor name entered by the user gets returned to the calling function.
	 */
	public static String captureContrName() {
		// Initialise an empty contrName:
		String contrName = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_CONTR_NAME);
			contrName = sc.nextLine();
			System.out.println("Are you happy with \"contr_name = " + contrName + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return contrName;
	}
	
	/**
	 * Prompt the user to enter the first name of a customer related to a specific project.
	 * @return The first name entered by the user gets returned back to the calling function.
	 */
	public static String captureCustFname() {
		// Initialise an empty custFname:
		String custFname = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_CUST_FNAME);
			custFname = sc.nextLine();
			System.out.println("Are you happy with \"cust_fname = " + custFname + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return custFname;
	}
	
	/**
	 * Prompt the user to enter the last name of a customer related to a specific project.
	 * @return The last name entered by the user gets returned back to the calling function.
	 */
	public static String captureCustLname() {
		// Initialise an empty custLname:
		String custLname = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_CUST_LNAME);
			custLname = sc.nextLine();
			System.out.println("Are you happy with \"cust_lname = " + custLname + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return custLname;
	}
	
	/**
	 * Prompt the user to enter the name of the Structural Engineer related to a new project.
	 * @return The name of the structural engineer gets returned back to the calling function.
	 */
	public static String captureStructEngName() {
		// Initialise an empty StructEngName:
		String structEngName = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_STRUCT_ENG_NAME);
			structEngName = sc.nextLine();
			System.out.println("Are you happy with \"struct_eng_name = " + structEngName + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return structEngName;
	}
	
	/**
	 * Prompt the user to enter the building type related to a new project.
	 * @return The building type entered by the user gets returned back to the calling function.
	 */
	public static String captureBldgType() {
		// Initialise an empty bldgType:
		String bldgType = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_BLDG_TYPE);
			bldgType = sc.nextLine();
			System.out.println("Are you happy with \"bldg_type = " + bldgType + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return bldgType;
	}
	
	/**
	 * Prompt the user to enter the physical address of a building related to a new project.
	 * @return The building type entered by the user gets returned back to the calling function.
	 */
	public static String capturePhysAddr() {
		// Initialise an empty physAddr:
		String physAddr = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_PHYS_ADDR);
			physAddr = sc.nextLine();
			System.out.println("Are you happy with \"phys_addr = " + physAddr + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return physAddr;
	}
	
	/**
	 * Prompt the user to enter the ERF number of a building related to a new project.
	 * @return The ERF number entered by the user getws returned back to the calling function.
	 */
	public static String captureErfNo() {
		// Initialise an empty erfNo:
		String erfNo = "-1";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_ERF_NO);
			erfNo = sc.nextLine();
			System.out.println("Are you happy with \"erf_no = " + erfNo + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return erfNo;
	}
	
	/**
	 * Prompt the user to enter in the total cost related to a new project.
	 * @return The total cost enetered by the user gets returned back to the calling function.
	 */
	public static String captureTotalFee() {
		// Initialise an empty Total Fee:
		String totalFee = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_TOTAL_FEE);
			totalFee = sc.nextLine();
			System.out.println("Are you happy with \"total_fee = " + totalFee + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return totalFee;
	}
	
	/**
	 * Prompt the user to enter in the total amount paid to date for a specific project.
	 * @return The Paid To Date value entered by the user gets returned back to the calling function.
	 */
	public static String captureTotalPtd() {
		// Initialise an empty Total Paid To Date:
		String totalPtd = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_TOTAL_PTD);
			totalPtd = sc.nextLine();
			System.out.println("Are you happy with \"total_ptd = " + totalPtd + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return totalPtd;
	}
	
	/**
	 * Prompt the user to specify the Status of a specific project.  It is typically either "ongoing" or "finalised".
	 * @return The Status entered by the user gets returned back to the calling function.
	 */
	public static String captureStatus() {
		// Initialise an empty Total Paid To Date:
		String status = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_STATUS);
			status = sc.nextLine();
			System.out.println("Are you happy with \"status = " + status + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return status;
	}
	
	/**
	 * Prompt the user to specify the Completion Date of a specific Project.  It is in the format of 'YYYY-MM-DD'.
	 * @return The completion date entered by the user gets returned back to the calling function.
	 */
	public static String captureCompltDte() {
		// Initialise an empty Total Paid To Date:
		String compltDte = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_COMPLT_DTE);
			compltDte = sc.nextLine();
			System.out.println("Are you happy with \"complt_dte = " + compltDte + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return compltDte;
	}
	
	/**
	 * Prompt the user to enter the telephone number of a specific architect in the database.
	 * @return The telephone number entered by the user gets returned back to the calling function.
	 */
	public static String captureArchtTelNo() {
		// Initialise an empty Architect Telephone Number:
		String archtTelNo = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_ARCHT_TEL_NO);
			archtTelNo = sc.nextLine();
			System.out.println("Are you happy with \"archt_tel_no = " + archtTelNo + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return archtTelNo;
	}
	
	/**
	 * Prompt the user to enter the email address of a specific architect in the database.
	 * @return The email address entered by the user gets returned back to the calling function.
	 */
	public static String captureArchtEmail() {
		// Initialise an empty Architect Email Address:
		String archtEmail = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_ARCHT_EMAIL);
			archtEmail = sc.nextLine();
			System.out.println("Are you happy with \"archt_email = " + archtEmail + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return archtEmail;
	}
	
	/**
	 * Prompt the user to enter in the physical address of a specific Architect in the database.
	 * @return The physical address entered by the user gets returned back to the calling function.
	 */
	public static String captureArchtPhysAddr() {
		// Initialise an empty Architect Physical Address:
		String archtPhysAddr = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_ARCHT_PHYS_ADDR);
			archtPhysAddr = sc.nextLine();
			System.out.println("Are you happy with \"archt_phys_addr = " + archtPhysAddr + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return archtPhysAddr;
	}
	
	/**
	 * Prompt the user to enter in the telephone number of a specific Customer in the database.
	 * @return The customer telephone number entered by the user gets returned back to the calling function.
	 */
	public static String captureCustTelNo() {
		// Initialise an empty Customer Telephone Number:
		String custTelNo = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_CUST_TEL_NO);
			custTelNo = sc.nextLine();
			System.out.println("Are you happy with \"cust_tel_no = " + custTelNo + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return custTelNo;
	}
	
	/**
	 * Prompt the user to enter in the email address of a specific customer in the database.
	 * @return The customer email address entered by the user gets returned back to the calling function.
	 */
	public static String captureCustEmail() {
		// Initialise an empty Customer Email:
		String custEmail = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_CUST_EMAIL);
			custEmail = sc.nextLine();
			System.out.println("Are you happy with \"cust_email = " + custEmail + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return custEmail;
	}
	
	/**
	 * Prompt the user to enter in the physical address of a certain customer in the database.
	 * @return The customer physical address entered in by the user gets returned back to the calling function.
	 */
	public static String captureCustPhysAddr() {
		// Initialise an empty Customer Physical Address:
		String custPhysAddr = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_CUST_PHYS_ADDR);
			custPhysAddr = sc.nextLine();
			System.out.println("Are you happy with \"cust_phys_addr = " + custPhysAddr + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return custPhysAddr;
	}
	
	/**
	 * Prompt the user to enter in the telephone number of a certain Contractor in the database.
	 * @return The telephone number entered by the user gets returned back to the calling function.
	 */
	public static String captureContrTelNo() {
		// Initialise an empty Contractor Telephone Number:
		String contrTelNo = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_CONTR_TEL_NO);
			contrTelNo = sc.nextLine();
			System.out.println("Are you happy with \"contr_tel_no = " + contrTelNo + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return contrTelNo;
	}
	
	/**
	 * Prompt the user to enter in the email address of a certain Contractor.
	 * @return The Contractor email address entered by the user gets returned back to the calling function.
	 */
	public static String captureContrEmail() {
		// Initialise an empty Contractor Email:
		String contrEmail = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_CONTR_EMAIL);
			contrEmail = sc.nextLine();
			System.out.println("Are you happy with \"contr_email = " + contrEmail + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return contrEmail;
	}
	
	/**
	 * Prompt the user to enter in the physical address of a certain Contractor in the database.
	 * @return The Contractor physical address entered by the user gets returned back to the calling function.
	 */
	public static String captureContrPhysAddr() {
		// Initialise an empty Contractor Physical Address:
		String contrPhysAddr = "";
		
		String correct = "n";
		while (correct.equalsIgnoreCase("n")) {
			System.out.println(NEW_CONTR_PHYS_ADDR);
			contrPhysAddr = sc.nextLine();
			System.out.println("Are you happy with \"contr_phys_addr = " + contrPhysAddr + "\"? [y/n]");
			correct = sc.nextLine();
		}
		return contrPhysAddr;
	}
	
	/**
	 * A function that encapsulates a total of 13 different unit functions.  The unit functions are as follows:
	 * (1) capturePrjName, (2) capturePrjDueDte, (3) capturePmName, (4) captureArchtName, (5) captureContrName,
	 * (6) captureCustFname, (7) captureCustLname, (8) captureStructEngName, (9) captureBldgType, (10) capturePhysAddr,
	 * (11) CaptureErfNo, (12) captureTotalFee, (13) captureTotalPtd.
	 * @return A string array of 13 values gets returned back to the calling function.  These values are then used to construct a
	 * new project in the PoisePMS Database.
	 */
	public static String[] captureProject() {
		String prjName = capturePrjName();
		String prjDueDte = capturePrjDueDte();
		String pmName = capturePmName();
		String archtName = captureArchtName();
		String contrName = captureContrName();
		String custFname = captureCustFname();
		String custLname = captureCustLname();
		String structEngName = captureStructEngName();
		String bldgType = captureBldgType();
		String physAddr = capturePhysAddr();
		String erfNo = captureErfNo();
		String totalFee = captureTotalFee();
		String totalPtd = captureTotalPtd();
		
		String[] prjData = {prjName, prjDueDte, pmName, archtName, contrName, custFname, 
							custLname, structEngName, bldgType, physAddr, erfNo, totalFee, totalPtd};
		
		return prjData;
	}
	
	/**
	 * A function that encapsulates 4 other unit functions, which are as follows: (1) captureArchtName, (2) captureArchtTelNo,
	 * (3) captureArchtEmail, (4) captureArchtPhysAddr.
	 * @return Return a string array of 4 values back to the calling functions.  These values are then used to construct a new
	 * Architect entity in the ARCHITECTS table. 
	 */
	public static String[] captureArchitect() {
		String archtName = captureArchtName();
		String archtTelNo = captureArchtTelNo();
		String archtEmail = captureArchtEmail();
		String archtPhysAddr = captureArchtPhysAddr();
		
		String[] archtData = {archtName, archtTelNo, archtEmail, archtPhysAddr};
		
		return archtData;
	}
	
	/**
	 * A function that encapsulates 5 other unit functions, which are as follows: (1) captureCustFname, (2) captureCustLname,
	 * (3) captureCustTelno, (4) captureCustEmail, (5) captureCustPhysAddr.
	 * @return Return an array of five String values back to the calling function. These values are then used to construct a new
	 * Customer Entity in the CUSTOMERS table.
	 */
	public static String[] captureCustomer() {
		String custFname = captureCustFname();
		String custLname = captureCustLname();
		String custTelNo = captureCustTelNo();
		String custEmail = captureCustEmail();
		String custPhysAddr = captureCustPhysAddr();
		
		String[] custData = {custFname, custLname, custTelNo, custEmail, custPhysAddr};
		
		return custData;
	}
	
	/**
	 * A function that encapsulates 4 other unit functions, which are as follows: (1) captureContrName, (2) captureContrTelNo, 
	 * (3) captureContrEmail, (4) captureContrPhysAddr.
	 * @return A string array of 4 values gets returned back to the calling function.  These values are then used to construct a new
	 * Contractor entity in the CONTRACTORS table.
	 */
	public static String[] captureContractor() {
		String contrName = captureContrName();
		String contrTelNo = captureContrTelNo();
		String contrEmail = captureContrEmail();
		String contrPhysAddr = captureContrPhysAddr();
		
		String[] contrData = {contrName, contrTelNo, contrEmail, contrPhysAddr};
		
		return contrData;
	}
}
