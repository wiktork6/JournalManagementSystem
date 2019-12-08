package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewPage {

	public JFrame frame;
	private Integer reviewNumber;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReviewPage window = new ReviewPage();
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
	public ReviewPage(Integer reviewNumber) {
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
		label.setBounds(258, 11, 75, 14);
		frame.getContentPane().add(label);
		
		JLabel lblReview = new JLabel("REVIEW " + reviewNumber);
		lblReview.setBounds(239, 36, 75, 14);
		frame.getContentPane().add(lblReview);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Controllers.REVIEW.setSelectedReview(null);
				frame.dispose();
				ViewReviews viewReviews = new ViewReviews();
				viewReviews.frame.setVisible(true);

			}
		});
		btnGoBack.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnSeeInitialReview = new JButton("SEE INITIAL REVIEW");
		btnSeeInitialReview.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnSeeInitialReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CheckInitialReview ir = new CheckInitialReview(reviewNumber);
				ir.frame.setVisible(true);
			}
		});
		btnSeeInitialReview.setBounds(74, 105, 133, 50);
		frame.getContentPane().add(btnSeeInitialReview);

		JButton btnSeeFinalReview = new JButton("SEE FINAL REVIEW");
		btnSeeFinalReview.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnSeeFinalReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CheckFinalReview fr = new CheckFinalReview(reviewNumber);
				fr.frame.setVisible(true);
			}
		});
		btnSeeFinalReview.setBounds(378, 105, 133, 50);
		frame.getContentPane().add(btnSeeFinalReview);

		if(Controllers.SUBMISSION.getSelectedSubmission().getStatus().equals("Initial Verdict")){
			JButton btnRespond = new JButton("RESPOND");
			btnRespond.setFont(new Font("Tahoma", Font.BOLD, 8));
			btnRespond.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					QuestionPage qp = new QuestionPage(reviewNumber);
					qp.frame.setVisible(true);
				}
			});
			btnRespond.setBounds(378, 254, 133, 50);
			frame.getContentPane().add(btnRespond);

		}

		JButton btnTypographicall = new JButton("TYPO ERRORS");
		btnTypographicall.setFont(new Font("Tahoma", Font.BOLD, 8));

		btnTypographicall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TypographicalErrors typographicalErrors = new TypographicalErrors(reviewNumber);
				typographicalErrors.frame.setVisible(true);
			}
		});
		btnTypographicall.setBounds(74, 254, 133, 50);
		frame.getContentPane().add(btnTypographicall);
		
		JButton btnLogin = new JButton("LOGOUT");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				Controllers.SUBMISSION.setSelectedSubmission(null);
				Controllers.REVIEW.setSelectedReview(null);
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogin.setBounds(10, 7, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
