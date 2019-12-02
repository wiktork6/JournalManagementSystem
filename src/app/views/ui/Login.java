package app.views.ui;

import app.controllers.Controllers;
import app.pojo.Author;
import app.pojo.User;


import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login {

	public JFrame frame;
	private JTextField txtFEmail;
	private JTextField txtFPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {

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
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WelcomePage wlcmpge = new WelcomePage();
				wlcmpge.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(23, 26, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		txtFEmail = new JTextField();
		txtFEmail.setBounds(267, 147, 130, 29);
		frame.getContentPane().add(txtFEmail);
		txtFEmail.setColumns(10);

		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(174, 153, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(172, 194, 63, 16);
		frame.getContentPane().add(lblPassword);
		
		txtFPassword = new JPasswordField();
		txtFPassword.setColumns(10);
		txtFPassword.setBounds(267, 188, 130, 29);
		frame.getContentPane().add(txtFPassword);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(267, 250, 150, 30);
		frame.getContentPane().add(error);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = Controllers.USER.login(txtFEmail.getText(),txtFPassword.getText());
				if(user!=null && txtFEmail.getText().equals(null) && txtFPassword.getText().equals(null)){
					frame.dispose();
					UserWelcomePage usrwlcm = new UserWelcomePage();
					usrwlcm.frame.setVisible(true);
				}else{
					error.setText("Invalid username or password");

				}
			}
		});
		btnLogin.setBounds(280, 219, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblLogin.setBounds(172, 98, 83, 23);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblRegister = new JLabel("Don't have an account? Register:");
		lblRegister.setBounds(23, 260, 309, 29);
		frame.getContentPane().add(lblRegister);
		
		JButton btnNewArticle = new JButton("Register to submit article");
		btnNewArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				NewArticle na = new NewArticle();
				na.frame.setVisible(true);
			}
		});
		btnNewArticle.setBounds(75, 300, 213, 29);
		frame.getContentPane().add(btnNewArticle);
		
		JButton btnNewJournal = new JButton("Register to create new journal");
		btnNewJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				NewJournal nj = new NewJournal();
				nj.frame.setVisible(true);
			}
		});
		btnNewJournal.setBounds(321, 300, 222, 29);
		frame.getContentPane().add(btnNewJournal);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(267, 19, 61, 16);
		frame.getContentPane().add(lbl42);
	}
}
