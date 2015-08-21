/* Program for Library Database by asv130130 (Name:- AMOL VAZE )*/
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class CheckOut extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bkId;
	private JTextField brnchId;
	private JTextField crdnum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
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
	public CheckOut() {
		super("CheckOut Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(new Color(220, 220, 220));
		((JComponent) contentPane).setBorder(new LineBorder(Color.BLUE, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel checkoutbook = new JLabel("CHECKOUT YOUR BOOK");
		checkoutbook.setForeground(Color.BLUE);
		checkoutbook.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkoutbook.setBounds(90, 11, 175, 14);
		contentPane.add(checkoutbook);

		JLabel bookid = new JLabel("BookId");
		bookid.setForeground(Color.BLUE);
		bookid.setFont(new Font("Tahoma", Font.BOLD, 11));
		bookid.setBounds(30, 59, 46, 14);
		contentPane.add(bookid);

		JLabel branchid = new JLabel("BranchId");
		branchid.setForeground(Color.BLUE);
		branchid.setFont(new Font("Tahoma", Font.BOLD, 11));
		branchid.setBounds(30, 116, 68, 14);
		contentPane.add(branchid);

		JLabel cardno = new JLabel("CardNo");
		cardno.setForeground(Color.BLUE);
		cardno.setFont(new Font("Tahoma", Font.BOLD, 11));
		cardno.setBounds(30, 174, 46, 14);
		contentPane.add(cardno);

		bkId = new JTextField();
		bkId.setBounds(120, 56, 145, 20);
		contentPane.add(bkId);
		bkId.setColumns(10);

		brnchId = new JTextField();
		brnchId.setBounds(120, 113, 145, 20);
		contentPane.add(brnchId);
		brnchId.setColumns(10);

		crdnum = new JTextField();
		crdnum.setBounds(120, 171, 145, 20);
		contentPane.add(crdnum);
		crdnum.setColumns(10);

		JButton checkoutbtn = new JButton("CHECK_OUT BOOK");
		checkoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				checkoutmgmt c = new checkoutmgmt();

				try {
					c.IsResultOk(Integer.parseInt(bkId.getText()),brnchId.getText(), crdnum.getText());
					
				    } 
				catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		checkoutbtn.setForeground(Color.BLUE);
		checkoutbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkoutbtn.setBounds(120, 216, 132, 34);
		contentPane.add(checkoutbtn);
	}

}
