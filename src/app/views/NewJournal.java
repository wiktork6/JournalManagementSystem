package app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewJournal {

	public JFrame frame;
	private JTextField txtFTitle;
	private JTextField txtFForename;
	private JTextField txtFSurname;
	private JTextField txtFEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;
	private JTextField txtFISSN;
	private JTextField txtFJournal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewJournal window = new NewJournal();
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
	public NewJournal() {
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
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
					
			}
		});
		btnGoBack.setBounds(0, 19, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("Register:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 60, 107, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(66, 128, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForename.setBounds(56, 156, 71, 16);
		frame.getContentPane().add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(66, 184, 61, 16);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUniversity.setBounds(56, 212, 71, 16);
		frame.getContentPane().add(lblUniversity);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(66, 240, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(56, 268, 71, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepeatPassword.setBounds(10, 296, 117, 16);
		frame.getContentPane().add(lblRepeatPassword);
		
		txtFTitle = new JTextField();
		txtFTitle.setBounds(149, 123, 130, 26);
		frame.getContentPane().add(txtFTitle);
		txtFTitle.setColumns(10);
		
		txtFForename = new JTextField();
		txtFForename.setColumns(10);
		txtFForename.setBounds(149, 151, 130, 26);
		frame.getContentPane().add(txtFForename);
		
		txtFSurname = new JTextField();
		txtFSurname.setColumns(10);
		txtFSurname.setBounds(149, 179, 130, 26);
		frame.getContentPane().add(txtFSurname);
		
		JTextField txtFUni = new JTextField();
		txtFUni.setColumns(10);
		txtFUni.setBounds(149, 207, 130, 26);
		frame.getContentPane().add(txtFUni);
		
		txtFEmail = new JTextField();
		txtFEmail.setColumns(10);
		txtFEmail.setBounds(149, 235, 130, 26);
		frame.getContentPane().add(txtFEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 263, 130, 21);
		frame.getContentPane().add(passwordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(149, 291, 130, 21);
		frame.getContentPane().add(passwordFieldRepeat);

		JLabel label_7 = new JLabel("New journal name");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(415, 171, 130, 16);
		frame.getContentPane().add(label_7);

		JLabel label_8 = new JLabel("Journal ISSN number");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(393, 255, 164, 16);
		frame.getContentPane().add(label_8);

		txtFJournal = new JTextField();
		txtFJournal.setColumns(10);
		txtFJournal.setBounds(427, 194, 130, 26);
		frame.getContentPane().add(txtFJournal);

		txtFISSN = new JTextField();
		txtFISSN.setColumns(10);
		txtFISSN.setBounds(427, 278, 130, 26);
		frame.getContentPane().add(txtFISSN);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AccountCreated acct = new AccountCreated();
				acct.frame.setVisible(true);
			}
		});
		btnSubmit.setBackground(new Color(0, 128, 0));
		btnSubmit.setBounds(375, 333, 130, 67);
		frame.getContentPane().add(btnSubmit);
		
		JLabel label = new JLabel("TEAM 42");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(284, 24, 61, 16);
		frame.getContentPane().add(label);
	}
}
