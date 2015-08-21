/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
//import java.util.ArrayList;

public class UserMgmt {

	private static Connection conn;
	private static Statement st;
	public static ResultSet rs;
	String fname;
	String lname;
	String address;
	String phone;

	// Constructor for making database connection
	public UserMgmt() {
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

	// Code for adding new borrower

	public void add(String fname, String lname, String address, String phone) {

		try {
			String fname1 = fname;
			String lname1 = lname;
			String address1 = address;
			String phone1 = phone;
			if (duplicateCheck(fname1, lname1, address1)) {
				JOptionPane.showMessageDialog(null, "Record Already Exists: ");
			} else {
				int r = 0;
				String query1 = "select max(cardno) from borrowers";
				ResultSet result1 = st.executeQuery(query1);
				while (result1.next()) {
					r = result1.getInt(1);
					r = r + 1;
				}

				String query2 = "Insert into borrowers values(" + r + ",'"
						+ fname1 + "','" + lname1 + "','" + address1 + "','"
						+ phone1 + "')";
				JOptionPane.showMessageDialog(null, "Record Inserted: ");
				int result2 = st.executeUpdate(query2);
			}

		} catch (Exception e) {

			System.out.println(e);

		}
		// TODO Auto-generated method stub
	}

	// TODO Auto-generated method stub
	// Code for duplicates entry check
	private boolean duplicateCheck(String fname, String lname, String address) {

		String fname1 = fname;
		String lname1 = lname;
		String address1 = address;
		ResultSet rs1 = null;
		try {

			String query = "Select cardno from borrowers where fname = '"
					+ fname1 + "' AND lname ='" + lname1 + "' AND address ='"
					+ address1 + "';";
			rs1 = st.executeQuery(query);
			if (rs1 == null) {
				return false;
			} else if (rs1.next()) {
				return true;
			} else {
				return false;
			}

		}

		catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

}