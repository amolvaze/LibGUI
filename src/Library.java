/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

//import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
//import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;*/

public class Library extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean isBookIdValid;
	private static JLabel bookIdval;
	//private JTextField branchId;

	/*
	 * private JTextField ncpies; private ButtonGroup group;
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library frame = new Library(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor For Library Class
	public Library(Container contentPane) {
		super("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 476);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(new Color(220, 220, 220));
		((JComponent) contentPane)
				.setBorder(new LineBorder(Color.BLUE, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton searchbtn = new JButton(" BOOK_SEARCH");
		searchbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchbtn.setBackground(new Color(230, 230, 250));
		searchbtn.setForeground(new Color(0, 0, 205));
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbook s = new searchbook();
				s.setVisible(true);
				

			}
		});
		searchbtn.setBounds(386, 316, 210, 36);
		contentPane.add(searchbtn);

		bookIdval = new JLabel("");
		bookIdval.setFont(new Font("Tahoma", Font.BOLD, 11));
		bookIdval.setForeground(Color.RED);
		bookIdval.setBounds(352, 268, 180, 36);
		contentPane.add(bookIdval);

		
		JButton addbtn = new JButton("ADD MEMBER");
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrower_Mgmt b = new Borrower_Mgmt();
				b.setVisible(true);

			}
		});
		addbtn.setBounds(70, 316, 227, 36);
		addbtn.setBackground(new Color(230, 230, 250));
		addbtn.setForeground(new Color(0, 0, 205));
		contentPane.add(addbtn);

		JLabel welcumtxt = new JLabel("WELCOME TO COLLEGE LIBRARY");
		welcumtxt.setForeground(new Color(0, 0, 205));
		welcumtxt.setFont(new Font("Tahoma", Font.BOLD, 26));
		welcumtxt.setBounds(130, 74, 441, 108);
		contentPane.add(welcumtxt);
	}
}