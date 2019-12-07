package app.views.ui;

import app.controllers.Controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class ReadArticle {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadArticle window = new ReadArticle();
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
	public ReadArticle() {
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
		lbl42.setBounds(267, 19, 61, 16);
		frame.getContentPane().add(lbl42);
		
		
		JTextPane textPAbstract = new JTextPane();
		textPAbstract.setEditable(false);
		textPAbstract.setText(Controllers.ARTICLE.getChosenArticle().getAbstractText());
		textPAbstract.setBounds(79, 102, 427, 163);
		frame.getContentPane().add(textPAbstract);
		
		JLabel lblArticleName = new JLabel(Controllers.ARTICLE.getChosenArticle().getTitle());
		lblArticleName.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleName.setBounds(211, 62, 169, 28);
		frame.getContentPane().add(lblArticleName);
		
		JTextPane txtPArticleInfo = new JTextPane();
		txtPArticleInfo.setEditable(false);
		txtPArticleInfo.setText("Page number range: " + Controllers.ARTICLE.getChosenArticle().getPageNumberRange() + "\n"+ "Author: " );
		txtPArticleInfo.setBounds(79, 277, 427, 59);
		frame.getContentPane().add(txtPArticleInfo);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.ARTICLE.setChosenArticle(null);
				frame.dispose();
				BrowseArticles brws = new BrowseArticles();
				brws.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code to download article
			}
		});
		btnDownload.setBounds(440, 360, 117, 29);
		frame.getContentPane().add(btnDownload);
	}
}
