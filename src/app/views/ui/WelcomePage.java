package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Article;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class WelcomePage extends JFrame{

	public JFrame frame;
	private ActionResult<Article> latestArticle = Controllers.ARTICLE.getLatest();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
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
	public WelcomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnBrowseArticles = new JButton("Browse Articles");
		btnBrowseArticles.setBounds(84, 110, 146, 29);
		btnBrowseArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BrowseJournals browseJournals = new BrowseJournals();
				browseJournals.frame.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnBrowseArticles);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setBounds(263, 28, 61, 16);
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl42);
		
		JButton btnLoginregister = new JButton("Login/Register");
		btnLoginregister.setBounds(362, 110, 146, 29);
		btnLoginregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnLoginregister);

		if(this.latestArticle.getResult() != null) {
			JLabel lblLatestArtice = new JLabel("Latest Article:");
			lblLatestArtice.setBounds(94, 169, 107, 16);
			frame.getContentPane().add(lblLatestArtice);

			JTextArea txtFArticle = new JTextArea();
			txtFArticle.setEditable(false);
			txtFArticle.setText(latestArticle.getResult().getAbstractText());
			txtFArticle.setBounds(94, 246, 409, 104);
			frame.getContentPane().add(txtFArticle);

			JTextArea txtFArticleInfoHere = new JTextArea();
			txtFArticleInfoHere.setEditable(false);
			txtFArticleInfoHere.setText(latestArticle.getResult().getTitle());
			txtFArticleInfoHere.setBounds(94, 197, 409, 29);
			frame.getContentPane().add(txtFArticleInfoHere);
		}
	}
}
