package app.views;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
		
		JLabel label_1 = new JLabel("Title");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(62, 148, 61, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Forename");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(52, 176, 71, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Surname");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(62, 204, 61, 16);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("University");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(52, 232, 71, 16);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(62, 260, 61, 16);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(52, 288, 71, 16);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Repeat Password");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(6, 316, 117, 16);
		frame.getContentPane().add(label_7);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(145, 143, 130, 26);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(145, 171, 130, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(145, 199, 130, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 227, 130, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(145, 255, 130, 26);
		frame.getContentPane().add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 283, 130, 21);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(145, 311, 130, 21);
		frame.getContentPane().add(passwordField_1);
		
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
