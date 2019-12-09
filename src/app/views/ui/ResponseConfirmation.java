package app.views.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResponseConfirmation {

	public JFrame frame;
	private Integer reviewNumber;



	/**
	 * Create the application.
	 */
	public ResponseConfirmation(Integer reviewNumber) {
		this.reviewNumber = reviewNumber;
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
		label.setBounds(258, 11, 60, 14);
		frame.getContentPane().add(label);
		
		JLabel lblResponseSubmitted = new JLabel("RESPONSE SUBMITTED");
		lblResponseSubmitted.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblResponseSubmitted.setForeground(new Color(0, 255, 0));
		lblResponseSubmitted.setBounds(168, 185, 269, 14);
		frame.getContentPane().add(lblResponseSubmitted);
		
		JButton btnLogin = new JButton("LOGOUT");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogin.setBounds(10, 7, 89, 23);
		frame.getContentPane().add(btnLogin);
		JButton btnGoBack = new JButton("Go Back to Questions List");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				QuestionPage questionPage = new QuestionPage(reviewNumber);
				questionPage.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);

	}
}
