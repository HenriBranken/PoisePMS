import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Henri Branken
 *
 */
public class Display {
	static final String MAIN_TABLE_NAME = "projects";
	static final String ARCHTS_NAME = "architects";
	static final String CUSTS_NAME = "customers";
	static final String CONTRS_NAME = "contractors";
	static final String SEPARATOR = "+--------------------------------------------------------------+\n";
	
	

	public static void printUnfinishedProjects(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM " + MAIN_TABLE_NAME + " WHERE status = 'ongoing' ORDER BY prj_no;");
		while (resultSet.next()) {
			String text;
			text  = "Project Number:  " + resultSet.getInt("prj_no") + "\n";
			text += "Project Name:  " + resultSet.getString("prj_name") + "\n";
			text += "Project Due Date:  " + resultSet.getDate("prj_due_dte") + "\n";
			text += "Project Manager:  " + resultSet.getString("pm_name") + "\n";
			text += "Architect:  " + resultSet.getString("archt_name") + "\n";
			text += "Contractor:  " + resultSet.getString("contr_name") + "\n";
			text += "Customer:  " + resultSet.getString("cust_fname") + " " + resultSet.getString("cust_lname") + "\n";
			text += "Structural Engineer:  " + resultSet.getString("struct_eng_name") + "\n";
			text += "Building Type:  " + resultSet.getString("bldg_type") + "\n";
			text += "Physical Address:  " + resultSet.getString("phys_addr") + "\n";
			text += "ERF Number:  " + resultSet.getInt("erf_no")  + "\n";
			text += "Total Fee:  " + resultSet.getBigDecimal("total_fee") + "\n";
			text += "Total Paid to Date:  " + resultSet.getBigDecimal("total_ptd") + "\n";
			text += "Project Status:  " + resultSet.getString("status") + "\n";
			text += "Completion Date:  " + resultSet.getDate("complt_dte") + "\n";
			text += SEPARATOR;
			
			System.out.println(text);
		}
	}
	
	public static void printPastDueDate(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM " + MAIN_TABLE_NAME + " WHERE prj_due_dte < DATE(NOW()) ORDER BY prj_no;");
		while (resultSet.next()) {
			String text;
			text  = "Project Number:  " + resultSet.getInt("prj_no") + "\n";
			text += "Project Name:  " + resultSet.getString("prj_name") + "\n";
			text += "Project Due Date:  " + resultSet.getDate("prj_due_dte") + "\n";
			text += "Project Manager:  " + resultSet.getString("pm_name") + "\n";
			text += "Architect:  " + resultSet.getString("archt_name") + "\n";
			text += "Contractor:  " + resultSet.getString("contr_name") + "\n";
			text += "Customer:  " + resultSet.getString("cust_fname") + " " + resultSet.getString("cust_lname") + "\n";
			text += "Structural Engineer:  " + resultSet.getString("struct_eng_name") + "\n";
			text += "Building Type:  " + resultSet.getString("bldg_type") + "\n";
			text += "Physical Address:  " + resultSet.getString("phys_addr") + "\n";
			text += "ERF Number:  " + resultSet.getInt("erf_no")  + "\n";
			text += "Total Fee:  " + resultSet.getBigDecimal("total_fee") + "\n";
			text += "Total Paid to Date:  " + resultSet.getBigDecimal("total_ptd") + "\n";
			text += "Project Status:  " + resultSet.getString("status") + "\n";
			text += "Completion Date:  " + resultSet.getDate("complt_dte") + "\n";
			text += SEPARATOR;
			
			System.out.println(text);
		}
	}
}
