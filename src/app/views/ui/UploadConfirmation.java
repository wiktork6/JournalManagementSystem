package app.views.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UploadConfirmation {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadConfirmation window = new UploadConfirmation();
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
	public UploadConfirmation() {
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
		label.setBounds(259, 11, 75, 14);
		frame.getContentPane().add(label);
		
		JLabel lblUploaded = new JLabel("UPLOADED");
		lblUploaded.setForeground(new Color(0, 255, 0));
		lblUploaded.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUploaded.setBounds(230, 195, 163, 14);
		frame.getContentPane().add(lblUploaded);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UploadOrReview uor = new UploadOrReview();
				uor.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
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
	}
}
