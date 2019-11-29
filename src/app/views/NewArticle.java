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
	private JTextField txtFJournal;
	private JTextField txtFISSN;
	private JTextField txtFTitle;
	private JTextField txtFForename;
	private JTextField txtFSurname;
	private JTextField txtFUni;
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
		
		JLabel label = new JLabel("Register:");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setBounds(26, 75, 107, 29);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Title");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(72, 143, 61, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Forename");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(62, 171, 71, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Surname");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(72, 199, 61, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("University");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(62, 227, 71, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(72, 255, 61, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(62, 283, 71, 16);
		frame.getContentPane().add(label_6);
		
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
		
		JLabel label_9 = new JLabel("Repeat Password");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(16, 309, 117, 16);
		frame.getContentPane().add(label_9);
		
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
		
		JLabel label_10 = new JLabel("TEAM 42");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(284, 26, 61, 16);
		frame.getContentPane().add(label_10);
	}

}
