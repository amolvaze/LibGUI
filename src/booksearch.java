/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/

import java.sql.*;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class booksearch {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private static JTextField bookId;
	private static JTextField booktitle;
	private static JTextField bookauthor;
	
	     public booksearch(){
	    	  
	    	 try{
	    			Class.forName("com.mysql.jdbc.Driver").newInstance();
	    			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mylibrary","root","");
	    			     st=conn.createStatement();
	    			  // Set the current database, if not already set in the getConnection
	    					// Execute a SQL statement
	    					st.execute("use mylibrary;");
	    				
	    			      
	    			    /*conn.close();
	    				System.out.println("Success!!"); */
	    			 
	    			  }
	    			  catch(Exception ex){
	    				  
	    				  System.out.println("Error: " +ex);
	    				  
	    			  }
     }
	     
	     // Code for searching book
	     
	     public TableModel searchBook(String Book_Id, String author_name, String book_title) {
	         //public static void main(String[] args) throws SQLException {   
	         
	         DefaultTableModel table = new DefaultTableModel(){

	             /**
	              * 
	              */
	             private static final long serialVersionUID = -3140186159369930753L;

	             public boolean isCellEditable(int rowIndex, int colIndex) {
	                 return false; // Disallow the editing of any cell
	             }
	         };
	         try {
	            
	             String Author;
	             int Branch_Id;
	             int No_of_Copies;
	             int Books_available;
	             int linect = 0;
	             String[] columnData={"Title1","Title2","Title3","Title4","Title5","Title6"};
	             String[] tableRow;
	             
	             table.addColumn("Book Id");
	             table.addColumn("Book_Title");
	             table.addColumn("Author_Name");
	             table.addColumn("Branch Id");
	             table.addColumn("Number of Copies");
	             table.addColumn("Available Books"); 
	             /*
	             if (Book_Id.equalsIgnoreCase("")) {
	                 Book_Id = "%";
	             }
	             if (Book_Title.equalsIgnoreCase("")) {
	                 Book_Title = "%";
	             }
	             if (Author_Name.equalsIgnoreCase("")) {
	                 Author_Name = "%";
	             }*/
	             /*if (fname.equalsIgnoreCase("")) {
	                 fname = "%";
	             }
	             if (minit.equalsIgnoreCase("")) {
	                 minit = "%";
	             }
	             if (lname.equalsIgnoreCase("")) {
	                 lname = "%";
	             }*/
	             //System.out.println(Book_Id+" "+author_name+" "+" "+book_title);
	             
	             String sql="Select bc.book_id, b.title,GROUP_CONCAT(distinct ba.author_name) authors, bc.branch_id, bc.no_of_copies,bc.no_of_copies-(select count(*) from book_loans bl where b.book_id=bl.book_id AND bl.branch_id=bc.branch_id AND isnull(bl.date_in)) as available from book b Natural Join book_copies bc natural join book_authors ba where b.book_id LIKE '%"+Book_Id+"%' AND b.title LIKE '%"+book_title+"%' AND ba.author_name LIKE '%"+author_name+"%'  group by b.book_id, bc.branch_id;";

	             
	             
	             ResultSet rs = st.executeQuery(sql);
	             while (rs.next()) {
	                 
	                 linect++;
	                 // Populate variables in program

	                 Book_Id = rs.getString("Book_Id");
	                 //System.out.println(Book_Id);
	                 author_name = rs.getString("Title");
	                 book_title = rs.getString("Authors");
	                 Branch_Id = rs.getInt("Branch_Id");
	                 No_of_Copies = rs.getInt("No_of_Copies");
	                 Books_available = rs.getInt("Available");
	                 
	                 tableRow = new String[6];
	                  
	                 tableRow[0] = Book_Id;
	                 tableRow[1] = author_name;
	                 tableRow[2]=  book_title;
	                 tableRow[3] = String.valueOf(Branch_Id);
	                 tableRow[4] = String.valueOf(No_of_Copies);
	                 tableRow[5] = String.valueOf(Books_available);
	                                  
	                 table.addRow(tableRow);
                 
	            
	             } // End while(rs.next())

	             // Always close the record-set and connection.
	             rs.close();
	             
	         } catch (SQLException se) {
	             //Handle errors for JDBC
	             se.printStackTrace();
	         } catch (Exception e) {
	             //Handle errors for Class.forName
	             e.printStackTrace();
	         } finally {
	             //finally block used to close resources
	             try {
	                 if (st != null) {
	                     conn.close();
	                 }
	             } catch (SQLException se) {
	             }// do nothing
	             try {
	                 if (conn != null) {
	                     conn.close();
	                 }
	             } catch (SQLException se) {
	                 se.printStackTrace();
	             }
	         }
	         return table;
	     }

	 }
