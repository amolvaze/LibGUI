/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

public class Borrower_Mgmt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JButton button = new JButton("New button");
	private JTextField f_name;
	private JTextField l_name;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrower_Mgmt frame = new Borrower_Mgmt();
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
	public Borrower_Mgmt() {
		super("Borrower Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(new Color(220, 220, 220));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(button);

		JButton addborrower = new JButton("ADD BORROWER");
		addborrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserMgmt u = new UserMgmt();
				String fname = f_name.getText();
				String lname = l_name.getText();
				String addr = address.getText();
				String ph = phone.getText();
				u.add(fname, lname, addr, ph);
			}
		});
		addborrower.setFont(new Font("Tahoma", Font.BOLD, 11));
		addborrower.setForeground(Color.BLUE);
		addborrower.setBounds(138, 227, 128, 23);
		contentPane.add(addborrower);

		f_name = new JTextField();
		f_name.setBounds(138, 33, 183, 20);
		contentPane.add(f_name);
		f_name.setColumns(10);

		l_name = new JTextField();
		l_name.setBounds(138, 82, 183, 20);
		contentPane.add(l_name);
		l_name.setColumns(10);

		address = new JTextField();
		address.setBounds(138, 137, 183, 20);
		contentPane.add(address);
		address.setColumns(10);

		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setForeground(Color.BLUE);
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstname.setBounds(20, 36, 81, 14);
		contentPane.add(lblFirstname);

		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setForeground(Color.BLUE);
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastname.setBounds(20, 85, 81, 14);
		contentPane.add(lblLastname);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.BLUE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(20, 140, 70, 14);
		contentPane.add(lblAddress);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhone.setForeground(Color.BLUE);
		lblPhone.setBounds(20, 186, 70, 14);
		contentPane.add(lblPhone);

		phone = new JTextField();
		phone.setBounds(138, 183, 183, 20);
		contentPane.add(phone);
		phone.setColumns(10);
	}
}
