package app.views.ui;

import app.controllers.Controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArticleSubmitted {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleSubmitted window = new ArticleSubmitted();
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
	public ArticleSubmitted() {
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
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(251, 24, 61, 16);
		frame.getContentPane().add(lbl42);
		
		JLabel lblAccountCreated = new JLabel();
		lblAccountCreated.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblAccountCreated.setBounds(157, 107, 291, 80);
		frame.getContentPane().add(lblAccountCreated);
		
		JLabel lblArticlesubmitted = new JLabel();
		lblArticlesubmitted.setVerticalAlignment(SwingConstants.TOP);
		lblArticlesubmitted.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblArticlesubmitted.setBounds(157, 171, 291, 70);
		frame.getContentPane().add(lblArticlesubmitted);
		
		JButton btnLogin = new JButton();
		if(Controllers.USER.getLoggedUser()!=null){
			Controllers.USER.logout();
			btnLogin.setText("Please log in again");
			lblArticlesubmitted.setText("Article submitted!");
		}else{
			lblAccountCreated.setText("Acount created!");
			lblArticlesubmitted.setText("Article submitted!");
			btnLogin.setText("You can now log in");
		}
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogin.setBounds(372, 314, 182, 60);
		frame.getContentPane().add(btnLogin);
	}

}
