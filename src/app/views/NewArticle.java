package app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewArticle {

	public JFrame frame;
	private JTextField txtFArticleTitle;
	private JTextField txtFISSN;
	private JTextField txtFTitle;
	private JTextField txtFForename;
	private JTextField txtFSurname;
	private JTextField txtFUni;
	private JTextField txtFEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;
	private JTextField txtFArticleText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewArticle window = new NewArticle();
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
	public NewArticle() {
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
		
		JLabel lblregister = new JLabel("Register:");
		lblregister.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblregister.setBounds(26, 75, 107, 29);
		frame.getContentPane().add(lblregister);
		
		JLabel lbltitle = new JLabel("Title");
		lbltitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltitle.setBounds(72, 143, 61, 16);
		frame.getContentPane().add(lbltitle);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForename.setBounds(62, 171, 71, 16);
		frame.getContentPane().add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(72, 199, 61, 16);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUniversity.setBounds(62, 227, 71, 16);
		frame.getContentPane().add(lblUniversity);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(72, 255, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(62, 283, 71, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblArticleTitle = new JLabel("Title");
		lblArticleTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleTitle.setBounds(429, 209, 130, 16);
		frame.getContentPane().add(lblArticleTitle);
		
		JLabel lblISSN = new JLabel("Journal ISSN number");
		lblISSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblISSN.setBounds(394, 148, 164, 16);
		frame.getContentPane().add(lblISSN);
		
		txtFArticleTitle = new JTextField();
		txtFArticleTitle.setColumns(10);
		txtFArticleTitle.setBounds(429, 227, 130, 26);
		frame.getContentPane().add(txtFArticleTitle);
		
		txtFISSN = new JTextField();
		txtFISSN.setColumns(10);
		txtFISSN.setBounds(429, 166, 130, 26);
		frame.getContentPane().add(txtFISSN);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddCoAuthors addCo = new AddCoAuthors();
				addCo.frame.setVisible(true);
			}
		});
		btnNext.setBackground(new Color(0, 128, 0));
		btnNext.setBounds(427, 344, 130, 67);
		frame.getContentPane().add(btnNext);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepeatPassword.setBounds(16, 309, 117, 16);
		frame.getContentPane().add(lblRepeatPassword);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(26, 21, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		txtFTitle = new JTextField();
		txtFTitle.setColumns(10);
		txtFTitle.setBounds(162, 143, 130, 26);
		frame.getContentPane().add(txtFTitle);
		
		txtFForename = new JTextField();
		txtFForename.setColumns(10);
		txtFForename.setBounds(162, 171, 130, 26);
		frame.getContentPane().add(txtFForename);
		
		txtFSurname = new JTextField();
		txtFSurname.setColumns(10);
		txtFSurname.setBounds(162, 199, 130, 26);
		frame.getContentPane().add(txtFSurname);
		
		txtFUni = new JTextField();
		txtFUni.setColumns(10);
		txtFUni.setBounds(162, 227, 130, 26);
		frame.getContentPane().add(txtFUni);
		
		txtFEmail = new JTextField();
		txtFEmail.setColumns(10);
		txtFEmail.setBounds(162, 255, 130, 26);
		frame.getContentPane().add(txtFEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 283, 130, 21);
		frame.getContentPane().add(passwordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(162, 311, 130, 21);
		frame.getContentPane().add(passwordFieldRepeat);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(284, 26, 61, 16);
		frame.getContentPane().add(lbl42);
		
		JLabel lblArticleText = new JLabel("Article Text");
		lblArticleText.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleText.setBounds(429, 283, 130, 16);
		frame.getContentPane().add(lblArticleText);
		
		txtFArticleText = new JTextField();
		txtFArticleText.setColumns(10);
		txtFArticleText.setBounds(429, 299, 130, 26);
		frame.getContentPane().add(txtFArticleText);
	}
}
