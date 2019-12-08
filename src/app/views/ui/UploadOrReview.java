package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UploadOrReview {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadOrReview window = new UploadOrReview();
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
	public UploadOrReview() {
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
		
		JLabel lblTeam = new JLabel("TEAM 42");
		lblTeam.setBounds(254, 11, 57, 14);
		frame.getContentPane().add(lblTeam);
		
		JLabel submissionTitle = new JLabel(Controllers.SUBMISSION.getSelectedSubmission().getTitle());
		submissionTitle.setBounds(222, 36, 128, 14);
		frame.getContentPane().add(submissionTitle);

		JLabel submissionStatus = new JLabel("Status: " + Controllers.SUBMISSION.getSelectedSubmission().getStatus());
		submissionStatus.setBounds(400, 36, 128, 14);
		frame.getContentPane().add(submissionStatus);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ExistingSubmissions es = new ExistingSubmissions();
				es.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnGoBack);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(200, 360, 350, 30);
		frame.getContentPane().add(error);


		JButton btnUploadEditedArticle = new JButton("UPLOAD EDITED ARTICLE");
		btnUploadEditedArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Controllers.SUBMISSION.getSelectedSubmission().getStatus().equals("Reviews received")) {
					frame.dispose();
					UploadArticlePage upa = new UploadArticlePage();
					upa.frame.setVisible(true);
				} else {
					error.setText(Messages.Error.CANT_UPLOAD);
				}
			}
		});
		btnUploadEditedArticle.setBounds(73, 205, 200, 23);
		frame.getContentPane().add(btnUploadEditedArticle);


		JButton btnSeeReviews = new JButton("SEE REVIEWS");
		btnSeeReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ViewReviews vrev = new ViewReviews();
				vrev.frame.setVisible(true);
			}
		});
		btnSeeReviews.setBounds(312, 205, 157, 23);
		frame.getContentPane().add(btnSeeReviews);
		
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
