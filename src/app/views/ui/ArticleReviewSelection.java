package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Article;
import app.pojo.Author;
import app.pojo.Submission;
import app.pojo.User;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ArticleReviewSelection {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleReviewSelection window = new ArticleReviewSelection();
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
	public ArticleReviewSelection() {
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

		User loggedUser = Controllers.USER.getLoggedUser();
		ActionResult<ArrayList<Submission>> arSubmissions = Controllers.SUBMISSION.getReviewerSubmissions(loggedUser);

		JList lstSubmissions = new JList();
		DefaultListModel submissionsListModel = new DefaultListModel();
		for(int i = 0; i < arSubmissions.getResult().size(); i++){
			submissionsListModel.add(i, arSubmissions.getResult().get(i).getTitle());
		}
		lstSubmissions.setModel(submissionsListModel);
		JScrollPane spEditor = new JScrollPane(lstSubmissions,
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    spEditor.setBounds(46, 126, 511, 100);
		frame.getContentPane().add(spEditor);

		ActionResult<ArrayList<Submission>> arSelectedSubmissions = Controllers.SUBMISSION.getReviewerSelectedSubmissions(loggedUser);
		JList lstSelectedSubmission = new JList();
		DefaultListModel selectedSubmissionsListModel = new DefaultListModel();
		for(int i = 0; i < arSelectedSubmissions.getResult().size(); i++){
			selectedSubmissionsListModel.add(i, arSelectedSubmissions.getResult().get(i).getTitle());
		}
		lstSelectedSubmission.setModel(selectedSubmissionsListModel);
		JScrollPane spSelectedEditor = new JScrollPane(lstSelectedSubmission,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spSelectedEditor.setBounds(46, 256, 511, 100);
		frame.getContentPane().add(spSelectedEditor);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Submission selected = arSubmissions.getResult().get(lstSubmissions.getSelectedIndex());
				Controllers.SUBMISSION.selectSubmission(selected, loggedUser);
				frame.dispose();
				ArticleReviewSelection refresh = new ArticleReviewSelection();
				refresh.frame.setVisible(true);
			}
		});
		btnSelect.setBounds(440, 90, 117, 29);
		frame.getContentPane().add(btnSelect);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		
		
		btnLogout.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserWelcomePage usrwlcm = new UserWelcomePage();
				usrwlcm.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnWriteReview = new JButton("Write Review");
		btnWriteReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Submission selected = arSelectedSubmissions.getResult().get(lstSelectedSubmission.getSelectedIndex());
				frame.dispose();
				ReviewHub rvwhb = new ReviewHub(selected);
				rvwhb.frame.setVisible(true);
			}
		});
		btnWriteReview.setBounds(440, 360, 117, 29);
		frame.getContentPane().add(btnWriteReview);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(281, 33, 61, 16);
		frame.getContentPane().add(lbl42);
		
		JLabel lblSelectArticlesTo = new JLabel("Select articles to review");
		lblSelectArticlesTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectArticlesTo.setBounds(47, 94, 201, 29);
		frame.getContentPane().add(lblSelectArticlesTo);
		JLabel lblReviewArticle = new JLabel("Choose article to write a review");
		lblReviewArticle.setHorizontalAlignment(SwingConstants.LEFT);
		lblReviewArticle.setBounds(47, 226, 201, 29);
		frame.getContentPane().add(lblReviewArticle);
	}

}
