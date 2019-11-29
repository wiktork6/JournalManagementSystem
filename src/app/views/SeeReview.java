package app.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class SeeReview {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeReview window = new SeeReview();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SeeReview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("TEAM 42");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(281, 33, 61, 16);
		frame.getContentPane().add(label);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Reviews rev = new Reviews();
				rev.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblVerdict = new JLabel("Verdict");
		lblVerdict.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerdict.setBounds(28, 121, 61, 16);
		frame.getContentPane().add(lblVerdict);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 116, 130, 26);
		frame.getContentPane().add(textField);
		
		JLabel lblReview = new JLabel("Review");
		lblReview.setHorizontalAlignment(SwingConstants.LEFT);
		lblReview.setBounds(28, 154, 61, 16);
		frame.getContentPane().add(lblReview);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 148, 216, 118);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(136, 271, 216, 71);
		frame.getContentPane().add(textField_2);
		
		JLabel lblQuestions = new JLabel("Questions");
		lblQuestions.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuestions.setBounds(28, 271, 84, 16);
		frame.getContentPane().add(lblQuestions);
		
		JLabel label_1 = new JLabel("<Article Name>");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(28, 69, 135, 26);
		frame.getContentPane().add(label_1);
		
		//ADDFUNC - replace <number> with the review number
		JLabel lblReview_1 = new JLabel("Review <Number>");
		lblReview_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReview_1.setBounds(439, 74, 135, 26);
		frame.getContentPane().add(lblReview_1);
		
		//ADDFUNC - replace <status> with the status
		JLabel lblStatus = new JLabel("Status: <Status>");
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setBounds(439, 11, 135, 26);
		frame.getContentPane().add(lblStatus);
		
		JButton btnRespond = new JButton("Respond");
		btnRespond.setBounds(457, 360, 117, 29);
		frame.getContentPane().add(btnRespond);
	}

}
