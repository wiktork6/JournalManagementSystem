package app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyAccount {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JLabel lblOldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAccount window = new MyAccount();
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
	public MyAccount() {
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
		
		JLabel lblUpdateTitle = new JLabel("Update Title");
		lblUpdateTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdateTitle.setBounds(94, 117, 102, 16);
		frame.getContentPane().add(lblUpdateTitle);
		
		JLabel lblUpdateForename = new JLabel("Update Forename");
		lblUpdateForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdateForename.setBounds(79, 145, 117, 16);
		frame.getContentPane().add(lblUpdateForename);
		
		JLabel lblUpdateSurname = new JLabel("Update Surname");
		lblUpdateSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdateSurname.setBounds(89, 173, 107, 16);
		frame.getContentPane().add(lblUpdateSurname);
		
		JLabel lblUpdateUniversity = new JLabel("Update University");
		lblUpdateUniversity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdateUniversity.setBounds(57, 201, 139, 16);
		frame.getContentPane().add(lblUpdateUniversity);
		
		JLabel lblUpdateEmail = new JLabel("Update Email");
		lblUpdateEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdateEmail.setBounds(67, 229, 129, 16);
		frame.getContentPane().add(lblUpdateEmail);
		
		JLabel lblUpdatePassword = new JLabel("New Password");
		lblUpdatePassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdatePassword.setBounds(57, 285, 139, 16);
		frame.getContentPane().add(lblUpdatePassword);
		
		JLabel lblRepeatNewPassword = new JLabel("Repeat New Password");
		lblRepeatNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepeatNewPassword.setBounds(39, 313, 157, 16);
		frame.getContentPane().add(lblRepeatNewPassword);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(225, 112, 130, 26);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(225, 140, 130, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(225, 168, 130, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(225, 196, 130, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(225, 224, 130, 26);
		frame.getContentPane().add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(225, 252, 130, 21);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(225, 280, 130, 21);
		frame.getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(225, 310, 130, 21);
		frame.getContentPane().add(passwordField_2);
		
		lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOldPassword.setBounds(57, 257, 139, 16);
		frame.getContentPane().add(lblOldPassword);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(407, 347, 149, 52);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblRegister = new JLabel("My account");
		lblRegister.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRegister.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegister.setBounds(57, 61, 139, 26);
		frame.getContentPane().add(lblRegister);
		
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
	}
}
