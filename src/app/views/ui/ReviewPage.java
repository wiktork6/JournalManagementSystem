package app.views.ui;

import app.controllers.Controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewPage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewPage window = new ReviewPage();
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
	public ReviewPage() {
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
		label.setBounds(258, 11, 75, 14);
		frame.getContentPane().add(label);
		
		JLabel lblReview = new JLabel("REVIEW <No.>");
		lblReview.setBounds(239, 36, 75, 14);
		frame.getContentPane().add(lblReview);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controllers.SUBMISSION.setSelectedSubmission(null);
				frame.dispose();
				ExistingSubmissions existingSubmissions = new ExistingSubmissions();
				existingSubmissions.frame.setVisible(true);

			}
		});
		btnGoBack.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnSeeInitialReview = new JButton("SEE INITIAL REVIEW");
		btnSeeInitialReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CheckInitialReview ir = new CheckInitialReview();
				ir.frame.setVisible(true);
			}
		});
		btnSeeInitialReview.setBounds(74, 105, 133, 50);
		frame.getContentPane().add(btnSeeInitialReview);
		
		JButton btnSeeFinalReview = new JButton("SEE FINAL REVIEW");
		btnSeeFinalReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CheckFinalReview fr = new CheckFinalReview();
				fr.frame.setVisible(true);
			}
		});
		btnSeeFinalReview.setBounds(378, 105, 133, 50);
		frame.getContentPane().add(btnSeeFinalReview);
		
		JButton btnRespond = new JButton("RESPOND");
		btnRespond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				QuestionPage qp = new QuestionPage();
				qp.frame.setVisible(true);
			}
		});
		btnRespond.setBounds(378, 254, 133, 50);
		frame.getContentPane().add(btnRespond);
		
		JButton btnLogin = new JButton("LOGOUT");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				Controllers.SUBMISSION.setSelectedSubmission(null);
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogin.setBounds(10, 7, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
