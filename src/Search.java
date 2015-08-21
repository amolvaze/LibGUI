/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Search extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Connection conn;
	private Statement st;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Search() {
		super("SEARCH HERE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton checkout = new JButton("CHECKOUT");
		checkout.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkout.setBackground(new Color(230, 230, 250));
		checkout.setForeground(new Color(0, 0, 205));
		checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				 
				
			
			}
		});
		
		// Code for Creating Database Connection
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mylibrary","root","");
			     st=conn.createStatement();
			  // Set the current database, if not already set in the getConnection
					// Execute a SQL statement
					st.execute("use mylibrary;");
		  }
			  catch(Exception ex){
				  
				  System.out.println("Error: " +ex);
				  
			  }
		checkout.setForeground(Color.BLUE);
		checkout.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkout.setBackground(new Color(230, 230, 250));
		checkout.setForeground(new Color(0, 0, 205));
		contentPane.add(checkout, BorderLayout.SOUTH);
		loadTable(); }
          // Code for creating rows & columns for JTable
	
	public void loadTable() {
		
	    String[] columnNames = {"Book_ID",
	            "Book_Title",
	            "Author_Name"};
    Object[][] data = {
	            {"","","",""}, {"","","",""}, {"","","",""}, {"","","",""}, {"","","",""}, {"","","",""}, {"","","",""}};
	    
	   DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		/*
		 * creates a new JTable
		 */
		table = new JTable();
		
		/*
		 * Applies the model
		 */
		table.setModel(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		// Code for adding table under ScrollPane
				JScrollPane scrollPane = new JScrollPane(table);
				contentPane.add(scrollPane);
				scrollPane.setVisible(true);
				scrollPane.setBounds(296, 102, 360, 100);
				scrollPane.setViewportView(table);

	    }

}

