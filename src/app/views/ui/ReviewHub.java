package app.views.ui;

import app.controllers.Controllers;
import app.pojo.Submission;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ReviewHub {

	public JFrame frame;
	Submission submission;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewHub window = new ReviewHub(null);
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
	public ReviewHub(Submission submission) {
		this.submission = submission;
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
		lbl42.setBounds(258, 34, 60, 16);
		frame.getContentPane().add(lbl42);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.SUBMISSION.setSelectedSubmission(null);
				frame.dispose();
				UserWelcomePage usrwlcm = new UserWelcomePage();
				usrwlcm.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				Controllers.SUBMISSION.setSelectedSubmission(null);
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		
		
		btnLogout.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		
		//ADDFUNC - replace <status> with the status
		JLabel lblStatus = new JLabel("Status: " + submission.getStatus());
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setBounds(439, 11, 135, 26);
		frame.getContentPane().add(lblStatus);
		
		JButton btnReadSubmission = new JButton("Read Submission");
		btnReadSubmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ReadSubmission rdsub = new ReadSubmission(submission);
				rdsub.frame.setVisible(true);
			}
		});
		btnReadSubmission.setBounds(62, 114, 158, 54);
		frame.getContentPane().add(btnReadSubmission);

		if(Controllers.REVIEW.canSubmitInitialReview(submission, Controllers.USER.getLoggedUser())) {
			JButton btnInitialReview = new JButton("Initial Review");
			btnInitialReview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					InitialReview intlrvw = new InitialReview(submission);
					intlrvw.frame.setVisible(true);
				}
			});
			btnInitialReview.setBounds(382, 114, 158, 54);
			frame.getContentPane().add(btnInitialReview);
		}

		if(Controllers.REVIEW.canSubmitFinalReview(submission, Controllers.USER.getLoggedUser())) {
			JButton btnFinalReview = new JButton("Final Review");
			btnFinalReview.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					FinalReview fnlrvw = new FinalReview(submission);
					fnlrvw.frame.setVisible(true);
				}
			});
			btnFinalReview.setBounds(382, 249, 158, 54);
			frame.getContentPane().add(btnFinalReview);
		}
		
		JButton btnNextArticle = new JButton("Next article");
		btnNextArticle.setBounds(433, 360, 117, 29);
		frame.getContentPane().add(btnNextArticle);
	}

}
