package app.views.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserWelcomePage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWelcomePage window = new UserWelcomePage();
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
	public UserWelcomePage() {
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
		
		
		//ADD FUNC - Replace <User> with the user logged in
		JLabel lblWelcome = new JLabel("Welcome <User>");
		lblWelcome.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(156, 70, 282, 38);
		frame.getContentPane().add(lblWelcome);
		
		JButton btnMyAccount = new JButton("My Account");
		btnMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MyAccount acct = new MyAccount();
				acct.frame.setVisible(true);
			}
		});
		btnMyAccount.setBounds(477, 6, 117, 29);
		frame.getContentPane().add(btnMyAccount);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblEditor = new JLabel("Editor");
		lblEditor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditor.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblEditor.setBounds(39, 134, 117, 38);
		frame.getContentPane().add(lblEditor);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblAuthor.setBounds(240, 134, 117, 38);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblReviewer = new JLabel("Reviewer");
		lblReviewer.setHorizontalAlignment(SwingConstants.CENTER);
		lblReviewer.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblReviewer.setBounds(445, 134, 117, 38);
		frame.getContentPane().add(lblReviewer);
		
		JButton btnNewJournal = new JButton("New Journal");
		btnNewJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RegisteredNewJournal nj = new RegisteredNewJournal();
				nj.frame.setVisible(true);
			}
		});
		btnNewJournal.setBounds(248, 307, 117, 29);
		frame.getContentPane().add(btnNewJournal);
		
		
		JSeparator seperatorLeft = new JSeparator();
		seperatorLeft.setOrientation(SwingConstants.VERTICAL);
		seperatorLeft.setForeground(new Color(0, 0, 0));
		seperatorLeft.setBackground(new Color(0, 0, 0));
		seperatorLeft.setBounds(200, 147, 12, 251);
		frame.getContentPane().add(seperatorLeft);
		
		JSeparator separatorRight = new JSeparator();
		separatorRight.setOrientation(SwingConstants.VERTICAL);
		separatorRight.setForeground(Color.BLACK);
		separatorRight.setBackground(Color.BLACK);
		separatorRight.setBounds(400, 147, 12, 251);
		frame.getContentPane().add(separatorRight);
		
		JButton btnSubmissions = new JButton("See submissions");
		btnSubmissions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ExistingSubmissions sub = new ExistingSubmissions();
				sub.frame.setVisible(true);
				
			}
		});
		btnSubmissions.setBounds(240, 225, 133, 29);
		frame.getContentPane().add(btnSubmissions);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(258, 34, 60, 16);
		frame.getContentPane().add(lbl42);
		
		JButton btnNewArticle = new JButton("Submit New Article");
		btnNewArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RegisteredNewArticle na = new RegisteredNewArticle();
				na.frame.setVisible(true);
			}
		});
		btnNewArticle.setBounds(224, 184, 164, 29);
		frame.getContentPane().add(btnNewArticle);
		
		JButton btnArticles = new JButton("See my articles");
		btnArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnArticles.setBounds(240, 266, 133, 29);
		frame.getContentPane().add(btnArticles);
		
		JButton btnReview = new JButton("Review Articles");
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ArticleReviewSelection artclrvw = new ArticleReviewSelection();
				artclrvw.frame.setVisible(true);
				
			}
		});
		btnReview.setBounds(429, 184, 133, 29);
		frame.getContentPane().add(btnReview);
		
		JButton btnAvailableJournals = new JButton("Available Journals");
		btnAvailableJournals.setBounds(23, 184, 148, 29);
		frame.getContentPane().add(btnAvailableJournals);
	}
}
