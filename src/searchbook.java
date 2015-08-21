/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchbook extends JFrame {

	private JPanel contentPane;
	private JTextField bkid;
	private JTextField bktitle;
	private JTextField author;
	private JTextField fn1;
	private JTextField mn1;
	private JTextField ln1;
	private ButtonGroup group;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchbook frame = new searchbook();
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
	public searchbook() {

		super("Searchbook Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 476);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(new Color(220, 220, 220));
		((JComponent) contentPane)
				.setBorder(new LineBorder(Color.BLUE, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel bookid = new JLabel("BookId");
		bookid.setForeground(Color.BLUE);
		bookid.setFont(new Font("Tahoma", Font.BOLD, 11));
		bookid.setBounds(10, 22, 46, 14);
		contentPane.add(bookid);

		JLabel booktitle = new JLabel("BookTitle");
		booktitle.setForeground(Color.BLUE);
		booktitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		booktitle.setBounds(325, 22, 79, 14);
		contentPane.add(booktitle);

		final JLabel authname = new JLabel("AuthorName");
		authname.setFont(new Font("Tahoma", Font.BOLD, 11));
		authname.setForeground(Color.BLUE);
		authname.setBounds(10, 125, 71, 14);
		contentPane.add(authname);

		/*
		 * final JLabel fname = new JLabel("Firstname"); fname.setFont(new
		 * Font("Tahoma", Font.BOLD, 11)); fname.setForeground(Color.BLUE);
		 * fname.setBounds(10, 105, 71, 14); contentPane.add(fname);
		 * 
		 * final JLabel mname = new JLabel("MInit");
		 * mname.setForeground(Color.BLUE); mname.setFont(new Font("Tahoma",
		 * Font.BOLD, 11)); mname.setBounds(10, 145, 46, 14);
		 * contentPane.add(mname);
		 * 
		 * final JLabel lastname = new JLabel("Lastname");
		 * lastname.setForeground(Color.BLUE); lastname.setFont(new
		 * Font("Tahoma", Font.BOLD, 11)); lastname.setBounds(10, 183, 71, 14);
		 * contentPane.add(lastname);
		 */
		bkid = new JTextField();
		bkid.setBounds(91, 19, 159, 20);
		contentPane.add(bkid);
		bkid.setColumns(10);

		bktitle = new JTextField();
		bktitle.setBounds(414, 19, 179, 20);
		contentPane.add(bktitle);
		bktitle.setColumns(10);

		author = new JTextField();
		author.setBounds(108, 122, 159, 20);
		contentPane.add(author);
		author.setColumns(10);

		/*
		 * fn1 = new JTextField(); fn1.setBounds(91, 102, 159, 20);
		 * contentPane.add(fn1); fn1.setColumns(10);
		 * 
		 * mn1 = new JTextField(); mn1.setBounds(91, 142, 159, 20);
		 * contentPane.add(mn1); mn1.setColumns(10);
		 * 
		 * ln1 = new JTextField(); ln1.setBounds(91, 180, 159, 20);
		 * contentPane.add(ln1); ln1.setColumns(10);
		 */

		/*
		 * JRadioButton rbt1 = new JRadioButton("Search By Author Name",true);
		 * rbt1.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent ev) {
		 * authname.setEnabled(true); fname.setEnabled(false);
		 * mname.setEnabled(false); lastname.setEnabled(false);
		 * author.setEnabled(true); fn1.setEnabled(false);
		 * mn1.setEnabled(false); ln1.setEnabled(false);
		 * 
		 * } }); rbt1.setFont(new Font("Tahoma", Font.BOLD, 11));
		 * rbt1.setBackground(Color.LIGHT_GRAY); rbt1.setForeground(Color.BLUE);
		 * rbt1.setBounds(358, 64, 179, 23); contentPane.add(rbt1);
		 * 
		 * JRadioButton rbtn2 = new
		 * JRadioButton("Search By Partial Names",false);
		 * rbtn2.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * authname.setEnabled(false); fname.setEnabled(true);
		 * mname.setEnabled(true); lastname.setEnabled(true);
		 * author.setEnabled(false); fn1.setEnabled(true); mn1.setEnabled(true);
		 * ln1.setEnabled(true); } }); rbtn2.setForeground(Color.BLUE);
		 * rbtn2.setFont(new Font("Tahoma", Font.BOLD, 11));
		 * rbtn2.setBackground(Color.LIGHT_GRAY); rbtn2.setBounds(358, 119, 179,
		 * 23); contentPane.add(rbtn2);
		 * 
		 * //Creating groups for radio buttons
		 * 
		 * group=new ButtonGroup(); group.add(rbt1); group.add(rbtn2);
		 */loadTable();
	}

	public void loadTable() {

		String[] columnNames = { "Book_ID", "Book_Title", "Author_Name",
				"BranchID", "No Of Copies", "Available Copies" };
		Object[][] data = { { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" },
				{ "", "", "", "" }, { "", "", "", "" } };

		// table = new JTable(data, columnNames);

		// contentPane.add(table);

		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		/*
		 * creates a new JTable
		 */

		/*
		 * rowid=table.getselectedrow() Applies the model
		 * table.getmodel().getvalueat(rowid, 0)
		 */

		// Code for adding table under ScrollPane
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		scrollPane.setVisible(true);
		scrollPane.setBounds(10, 208, 646, 218);
		final JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		/*
		 * table.isCellEditable(data, columnNames);
		 * 
		 * public boolean isCellEditable(int rowIndex, int colIndex) { return
		 * false; // Disallow the editing of any cell }
		 */

		// sets the scrollable size of the table
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));

		JButton searchbtn = new JButton("SEARCH");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				booksearch b = new booksearch();
				table.setModel(b.searchBook(bkid.getText(), author.getText(),
						bktitle.getText()));
				table.setVisible(true);
				table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			}
		});
		searchbtn.setForeground(Color.BLUE);
		searchbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchbtn.setBounds(325, 87, 140, 32);
		contentPane.add(searchbtn);

		JButton checkout = new JButton("CHECK OUT");
		checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOut c = new CheckOut();
				c.setVisible(true);
			}
		});
		checkout.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkout.setForeground(Color.BLUE);
		checkout.setBounds(514, 87, 128, 32);
		contentPane.add(checkout);

		JButton chkinbtn = new JButton("CHECK IN");
		chkinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckIn c1 = new CheckIn();
				c1.setVisible(true);
			}
		});
		chkinbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkinbtn.setForeground(Color.BLUE);
		chkinbtn.setBounds(439, 153, 128, 32);
		contentPane.add(chkinbtn);

	}
}
