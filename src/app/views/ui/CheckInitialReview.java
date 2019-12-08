package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckInitialReview {

	public JFrame frame;
	private Integer reviewNumber;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CheckInitialReview window = new CheckInitialReview();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public CheckInitialReview(Integer reviewNumber) {
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
		label.setBounds(265, 11, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblVerdict = new JLabel("VERDICT");
		lblVerdict.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVerdict.setForeground(new Color(0, 0, 0));
		lblVerdict.setBounds(70, 126, 58, 14);
		frame.getContentPane().add(lblVerdict);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText(Controllers.REVIEW.getSelectedReview().getInitialVerdict());
		textPane.setBounds(138, 103, 258, 58);
		frame.getContentPane().add(textPane);
		
		JLabel lblReview = new JLabel("REVIEW");
		lblReview.setForeground(Color.BLACK);
		lblReview.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReview.setBounds(70, 247, 58, 14);
		frame.getContentPane().add(lblReview);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText(Controllers.REVIEW.getSelectedReview().getReviewSummary());
		textPane_1.setEditable(false);
		textPane_1.setBounds(138, 229, 258, 58);
		frame.getContentPane().add(textPane_1);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ReviewPage revp = new ReviewPage(reviewNumber);
				revp.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		JLabel lblInitialReview = new JLabel("INITIAL REVIEW");
		lblInitialReview.setBounds(248, 36, 100	, 14);
		frame.getContentPane().add(lblInitialReview);
		
		JButton btnLogin = new JButton("LOGOUT");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				Controllers.REVIEW.setSelectedReview(null);
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
