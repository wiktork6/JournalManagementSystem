package app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountCreated {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountCreated window = new AccountCreated();
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
	public AccountCreated() {
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
		label.setBounds(273, 25, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel lblconfirmation = new JLabel("Acount created!");
		lblconfirmation.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblconfirmation.setBounds(179, 108, 291, 80);
		frame.getContentPane().add(lblconfirmation);
		
		JLabel lblconfirmation2 = new JLabel("You can now log in!");
		lblconfirmation2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblconfirmation2.setVerticalAlignment(SwingConstants.TOP);
		lblconfirmation2.setBounds(179, 172, 291, 70);
		frame.getContentPane().add(lblconfirmation2);
		
		JButton btnLogin = new JButton("Login Page");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogin.setBounds(394, 315, 182, 60);
		frame.getContentPane().add(btnLogin);
	}

}
