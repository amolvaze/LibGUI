/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class CheckIn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fn;
	private JTextField ln;
	private JTextField bookid;
	private JTextField cardno;
	public final JTable table = new JTable();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckIn frame = new CheckIn();
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
	public CheckIn() {
		super("CheckIn Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 472);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(new Color(220, 220, 220));
		((JComponent) contentPane)
				.setBorder(new LineBorder(Color.BLUE, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel returnbook = new JLabel("RETURN YOUR BOOK");
		returnbook.setForeground(Color.BLUE);
		returnbook.setFont(new Font("Tahoma", Font.BOLD, 14));
		returnbook.setBounds(265, 11, 170, 14);
		contentPane.add(returnbook);

		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setForeground(Color.BLUE);
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstname.setBounds(22, 56, 75, 14);
		contentPane.add(lblFirstname);

		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setForeground(Color.BLUE);
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastname.setBounds(369, 56, 75, 14);
		contentPane.add(lblLastname);

		JLabel lblBookid = new JLabel("BookId");
		lblBookid.setForeground(Color.BLUE);
		lblBookid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBookid.setBounds(22, 109, 46, 14);
		contentPane.add(lblBookid);

		JLabel lblCardno = new JLabel("CardNo");
		lblCardno.setForeground(Color.BLUE);
		lblCardno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCardno.setBounds(369, 109, 46, 14);
		contentPane.add(lblCardno);

		fn = new JTextField();
		fn.setBounds(118, 53, 170, 20);
		contentPane.add(fn);
		fn.setColumns(10);

		ln = new JTextField();
		ln.setBounds(464, 53, 170, 20);
		contentPane.add(ln);
		ln.setColumns(10);

		bookid = new JTextField();
		bookid.setBounds(118, 106, 170, 20);
		contentPane.add(bookid);
		bookid.setColumns(10);

		cardno = new JTextField();
		cardno.setBounds(464, 106, 170, 20);
		contentPane.add(cardno);
		cardno.setColumns(10);

		JButton btncheckIn = new JButton("CHECK-IN BOOK");
		btncheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkinmgmt ck = new checkinmgmt();
				ck.checkIN(table.getSelectedRow(), table.getModel());
				table.setVisible(true);
				table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			}
		});
		btncheckIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btncheckIn.setForeground(Color.BLUE);
		btncheckIn.setBounds(328, 153, 138, 35);
		contentPane.add(btncheckIn);

		JButton searchbutton = new JButton("SEARCH");
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				checkinmgmt ck = new checkinmgmt();
				try {
					table.setModel(ck.Search_ChkIn(fn.getText(), ln.getText(),Integer.parseInt(bookid.getText()),cardno.getText()));
				} catch (NumberFormatException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		searchbutton.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchbutton.setForeground(Color.BLUE);
		searchbutton.setBounds(490, 153, 144, 35);
		contentPane.add(searchbutton);

		loadTable();
	}

	public void loadTable() {

		String[] columnNames = { "Loan Id", "Book ID", "Branch id", "Card No",
				"Due Date" };
		Object[][] data = { { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" } };

	  DefaultTableModel model = new DefaultTableModel(data, columnNames);
		/*
		 * creates a new JTable
		 */
		// Code for adding table under ScrollPane
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		scrollPane.setVisible(true);
		scrollPane.setBounds(10, 208, 646, 218);

		scrollPane.setViewportView(table);
		table.setModel(model);
	    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

	}
}
