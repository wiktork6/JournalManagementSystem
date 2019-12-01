package app.views.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterAuthor {

	public JFrame frame;
	private JTextField txtFTitle;
	private JTextField txtFForename;
	private JTextField txtFSurname;
	private JTextField txtFUniversity;
	private JTextField txtFEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterAuthor window = new RegisterAuthor();
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
	public RegisterAuthor() {
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
		
		JLabel lblRegisteNewAuthor = new JLabel("Register new author");
		lblRegisteNewAuthor.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRegisteNewAuthor.setBounds(16, 80, 243, 29);
		frame.getContentPane().add(lblRegisteNewAuthor);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(62, 148, 61, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForename.setBounds(52, 176, 71, 16);
		frame.getContentPane().add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(62, 204, 61, 16);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUniversity.setBounds(52, 232, 71, 16);
		frame.getContentPane().add(lblUniversity);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(62, 260, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(52, 288, 71, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepeatPassword.setBounds(6, 316, 117, 16);
		frame.getContentPane().add(lblRepeatPassword);
		
		txtFTitle = new JTextField();
		txtFTitle.setColumns(10);
		txtFTitle.setBounds(145, 143, 130, 26);
		frame.getContentPane().add(txtFTitle);
		
		txtFForename = new JTextField();
		txtFForename.setColumns(10);
		txtFForename.setBounds(145, 171, 130, 26);
		frame.getContentPane().add(txtFForename);
		
		txtFSurname = new JTextField();
		txtFSurname.setColumns(10);
		txtFSurname.setBounds(145, 199, 130, 26);
		frame.getContentPane().add(txtFSurname);
		
		txtFUniversity = new JTextField();
		txtFUniversity.setColumns(10);
		txtFUniversity.setBounds(145, 227, 130, 26);
		frame.getContentPane().add(txtFUniversity);
		
		txtFEmail = new JTextField();
		txtFEmail.setColumns(10);
		txtFEmail.setBounds(145, 255, 130, 26);
		frame.getContentPane().add(txtFEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 283, 130, 21);
		frame.getContentPane().add(passwordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(145, 311, 130, 21);
		frame.getContentPane().add(passwordFieldRepeat);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddCoAuthors addCo = new AddCoAuthors();
			    addCo.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(16, 22, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnAddAuthor = new JButton("Add author");
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddCoAuthors addCo = new AddCoAuthors();
			    addCo.frame.setVisible(true);
			}
		});
		btnAddAuthor.setBounds(416, 334, 154, 64);
		frame.getContentPane().add(btnAddAuthor);
	}

}
