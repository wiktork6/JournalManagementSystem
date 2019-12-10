package app.views.ui;

import app.controllers.Controllers;
import app.pojo.Author;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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
		textPAbstract.setBounds(79, 102, 427, 60);
		frame.getContentPane().add(textPAbstract);
		
		JLabel lblArticleName = new JLabel(Controllers.ARTICLE.getChosenArticle().getTitle());
		lblArticleName.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleName.setBounds(211, 62, 169, 28);
		frame.getContentPane().add(lblArticleName);
		
		JTextPane txtPArticleInfo = new JTextPane();
		txtPArticleInfo.setEditable(false);
		txtPArticleInfo.setText(Controllers.JOURNAL.getChosenJournal().getName() + " vol." + Controllers.VOLUME.getChosenVolume().getVolumeNumber() + ",no." +
				Controllers.EDITION.getChosenEdition().getEdition_number() + " " + Controllers.ARTICLE.getChosenArticle().getPageNumberRange());
		txtPArticleInfo.setBounds(79, 180, 427, 30);
		frame.getContentPane().add(txtPArticleInfo);

		ArrayList<Author> listOfAuthors = Controllers.ARTICLE.getCoAuthors(Controllers.ARTICLE.getChosenArticle());
		String authorsString = "";
		for(int i=0; i<listOfAuthors.size(); i++){
			authorsString+=listOfAuthors.get(i).getUser().getTitle() + " " + listOfAuthors.get(i).getUser().getForname() + " " + listOfAuthors.get(i).getUser().getSurname() + " " + listOfAuthors.get(i).getUser().getEmail() + "; ";
		}

		JTextPane articleAuthors = new JTextPane();
		articleAuthors.setEditable(false);
		articleAuthors.setText(authorsString);
		articleAuthors.setBounds(79, 220, 427, 50);
		frame.getContentPane().add(articleAuthors);


		
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
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(Controllers.ARTICLE.getChosenArticle().getFullArticle());
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnDownload.setBounds(440, 360, 117, 29);
		frame.getContentPane().add(btnDownload);
	}
}
