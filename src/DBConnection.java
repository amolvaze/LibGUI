/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.sql.*;

//import com.mysql.jdbc.jdbc2.optional.*;
// Code for making JDBC database connection
public class DBConnection {

	private Connection conn;
	private Statement st;
	

	// Code for making database connection
	public DBConnection() {

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

}