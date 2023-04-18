import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A module for displaying data related to unfinished projects and projects that are overdue.
 * @author Henri Branken
 *
 */
public class Display {
	static final String MAIN_TABLE_NAME = "projects";
	static final String SEPARATOR = "+--------------------------------------------------------------+\n";
	
	/**
	 * Output all the projects (and their details) that are not finished.
	 * @param statement A Direct Line to the database for running our queries.
	 * @throws SQLException
	 */
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
	
	/**
	 * Output all the projects that are unfinished AND past their due date.
	 * @param statement A Direct Line to the database for running our queries.
	 * @throws SQLException
	 */
	public static void printPastDueDate(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM " + MAIN_TABLE_NAME + " WHERE prj_due_dte < DATE(NOW()) AND " +
													 "STATUS <> 'finalised' ORDER BY prj_no;");
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
