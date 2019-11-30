package app.views;

import app.controllers.ArticleController;
import app.controllers.Controllers;
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
				BrowseArticles brws = new BrowseArticles();
				brws.frame.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnBrowseArticles);
		
		JLabel lblTeam = new JLabel("TEAM 42");
		lblTeam.setBounds(263, 28, 61, 16);
		lblTeam.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTeam);
		
		JButton btnLoginRegister = new JButton("Login/Register");
		btnLoginRegister.setBounds(362, 110, 146, 29);
		btnLoginRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnLoginRegister);

		Article latestArticle = Controllers.ARTICLE.getLatest();
		if (latestArticle != null) {
			JLabel lblLatestArtice = new JLabel("Latest Article:");
			lblLatestArtice.setBounds(94, 169, 107, 16);
			frame.getContentPane().add(lblLatestArtice);


			JTextArea txtArticle = new JTextArea();
			txtArticle.setText(latestArticle.getTitle());
			txtArticle.setBounds(94, 246, 409, 104);
			frame.getContentPane().add(txtArticle);

			JTextArea txtrArticleInfoHere = new JTextArea();
			txtrArticleInfoHere.setText(latestArticle.getAbstractText());
			txtrArticleInfoHere.setBounds(94, 197, 409, 29);
			frame.getContentPane().add(txtrArticleInfoHere);
		}
	}
}
