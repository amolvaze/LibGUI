/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class checkinmgmt {

	private static Connection conn;
	private static Statement st;
	DefaultTableModel model = new DefaultTableModel();

	// Constructor for making database connection
	public checkinmgmt() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mylibrary", "root", "");
			st = conn.createStatement();
			// Set the current database, if not already set in the getConnection
			// Execute a SQL statement
			st.execute("use mylibrary;");
	
		} catch (Exception ex) {

			System.out.println("Error: " + ex);

		}
	}

	// Method for checkin books
	public void checkIN(int rowindex, TableModel lmodel) {
		try {
			ResultSet rs1;
			ResultSet rs2;
			int loan_id = Integer.parseInt((String) lmodel.getValueAt(rowindex,
					0));
			String query1 = "select curdate()";

			rs2 = st.executeQuery(query1);
			rs2.next();
			String date = rs2.getString(1);
			String query2 = "Update book_loans set date_in= '" + date
					+ "' where loan_id=" + loan_id + ";";
			int rowcount = st.executeUpdate(query2);

			rs2.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
   // Method for loading data for checkin search function

	public TableModel Search_ChkIn(String fname, String lname, int book_id,
			String card_no) throws SQLException {

		String fn = fname;
		String ln = lname;
		int bk = book_id;
		String cd = card_no;

		String query = "Select bl.loan_id, bl.book_id, bl.branch_id, b.cardno, bl.due_date from book_loans bl NATURAL JOIN borrowers b where b.fname LIKE '%"
				+ fn
				+ "%' AND b.lname LIKE '%"
				+ ln
				+ "%' AND b.cardno LIKE '%"
				+ cd
				+ "%'  AND bl.book_id LIKE '%"
				+ bk + "%' AND isnull(date_in);";

		ResultSet rs = st.executeQuery(query);
		model.addColumn("Loan id");
		model.addColumn("Book id");
		model.addColumn("Branch_id");
		model.addColumn("Card_No");
		model.addColumn("Due Date");

		while (rs.next()) {

			// Populate variables in program

			book_id = rs.getInt("book_Id");
			int loan_id = rs.getInt("loan_id");
			int branch_id = rs.getInt("branch_id");
			card_no = rs.getString("cardno");
			String due_date = rs.getString("due_date");

			// Code for loading data to table
			String[] tableRow = new String[5];

			tableRow[0] = String.valueOf(loan_id);
			tableRow[1] = String.valueOf(book_id);
			tableRow[2] = String.valueOf(branch_id);
			tableRow[3] = card_no;
			tableRow[4] = due_date;

			model.addRow(tableRow);

		}
		return model;

	}
}
