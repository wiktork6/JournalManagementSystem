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
	private JTextField txtFJournalName;
	private JTextField txtFISSN;

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
		
		JLabel lblRegister = new JLabel("Register:");
		lblRegister.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRegister.setBounds(20, 60, 107, 29);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(66, 128, 61, 16);
		frame.getContentPane().add(lblTitle);
		
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
		
		JLabel lblNewJournalName = new JLabel("Journal ISSN number");
		lblNewJournalName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJournalName.setBounds(409, 240, 130, 16);
		frame.getContentPane().add(lblNewJournalName);
		
		txtFJournalName = new JTextField();
		txtFJournalName.setColumns(10);
		txtFJournalName.setBounds(409, 190, 130, 26);
		frame.getContentPane().add(txtFJournalName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AccountCreated acct = new AccountCreated();
				acct.frame.setVisible(true);
			}
		});
		btnSubmit.setBackground(new Color(0, 128, 0));
		btnSubmit.setBounds(409, 333, 130, 67);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblJournalName = new JLabel("New journal name");
		lblJournalName.setHorizontalAlignment(SwingConstants.CENTER);
		lblJournalName.setBounds(409, 173, 130, 16);
		frame.getContentPane().add(lblJournalName);
		
		txtFISSN = new JTextField();
		txtFISSN.setColumns(10);
		txtFISSN.setBounds(409, 258, 130, 26);
		frame.getContentPane().add(txtFISSN);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(284, 24, 61, 16);
		frame.getContentPane().add(lbl42);
	}
}
