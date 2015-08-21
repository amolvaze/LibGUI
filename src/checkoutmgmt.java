/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;




public class checkoutmgmt {
	private static Connection conn;
	private static Statement st;
	public static int rs;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;

	// Constructor for making database connection
	public checkoutmgmt() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mylibrary", "root", "");
			st = conn.createStatement();
			// Set the current database, if not already set in the getConnection
			// Execute a SQL statement
			st.execute("use mylibrary;");
			// conn.close();
			// System.out.println("Success!!");

		} catch (Exception ex) {

			System.out.println("Error: " + ex);

		}
	}

	// Code for checkOut Operation

	public void checkout(int bookid, String branchid, String cardno) {
		int bk = bookid;
		String br = branchid;
		String cd = cardno;
		String s = sysdate();
		String sd = ADDDATE(sysdate(), 14);
		String NULL = null;
		// IsResultOk(bk,br,cd);
		String query = "insert into book_loans values(DEFAULT, " + bk + ",'"
				+ br + "','" + cd + "'," + s + ",'" + sd + "', NULL)";
		try {
			rs = st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Check Out Successful:");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String ADDDATE(String sysdate, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unused")
	private String CURDATE() {
		// TODO Auto-generated method stub
		return null;
	}

	public String sysdate() {
		// TODO Auto-generated method stub
		return null;
	}

	// Code for checking all the necessary conditions
	@SuppressWarnings({ "null", "unused" })
	public void IsResultOk(int book_id, String branch_id, String card_no)
			throws SQLException {
		int bkid = book_id;
		String brid = branch_id;
		String crdno = card_no;
		int num1 = 0;
		int num2 = 0;

		String query1 = "select cardno from book_loans where cardno LIKE "
				+ "'" + crdno + "';";
		String query2 = "Select count(no_of_copies) from book_copies where book_id LIKE "
				+ "'" + bkid + "'AND branch_id LIKE " + "'" + brid + "';";
		String query3 = "Select count(*) from book_loans where book_id LIKE "
				+ "'" + bkid + "'AND branch_id LIKE " + "'" + brid + "';";

		rs2 = st.executeQuery(query2);

		while (rs2.next()) {

			num1 = Integer.parseInt(rs2.getString(1));

		}
		rs3 = st.executeQuery(query3);
		while (rs3.next()) {

			num2 = Integer.parseInt(rs3.getString(1));
			System.out.println(num2);
		}
		int avlb_copies = (num2) - (num1);

		try {

			int num = 0;
			rs1 = st.executeQuery(query1);
			while (rs1.next()) {
				num = Integer.parseInt(rs1.getString(1));

			}
			if (num < 3) {
				if (avlb_copies > 0) {
					JOptionPane.showMessageDialog(null, "You cannot check out anymore!");
				} else {
					checkout(bkid, brid, crdno);
				}
			} else {

				JOptionPane.showMessageDialog(null, "You cannot check out anymore!");
			}

		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
