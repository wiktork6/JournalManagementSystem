package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Article;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class BrowseArticles {

	public JFrame frame;

	private ActionResult<ArrayList<Article>> listOfArticles = Controllers.ARTICLE.getEditionArticles(Controllers.EDITION.getChosenEdition());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowseArticles window = new BrowseArticles();
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
	public BrowseArticles() {
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

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(200, 360, 250, 30);
		frame.getContentPane().add(error);



		JList articlesList = new JList();
		//Default List Model for titles
		DefaultListModel volumesListModel = new DefaultListModel();
		for(int i = 0; i<listOfArticles.getResult().size();i++){
			volumesListModel.add(i,Controllers.JOURNAL.getChosenJournal().getName() + " vol." + Controllers.VOLUME.getChosenVolume().getVolumeNumber() + ",no." +
					Controllers.EDITION.getChosenEdition().getEdition_number() + listOfArticles.getResult().get(i).getPageNumberRange() + " " + listOfArticles.getResult().get(i).getTitle());
		}
		articlesList.setModel(volumesListModel);


		JScrollPane spEditor = new JScrollPane(articlesList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spEditor.setBounds(46, 126, 511, 204);
		frame.getContentPane().add(spEditor);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.EDITION.setChosenEdition(null);
				frame.dispose();
				BrowseEditions brws = new BrowseEditions();
				brws.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(articlesList.getSelectedIndex()!=-1){
					Article chosenArticle = listOfArticles.getResult().get(articlesList.getSelectedIndex());
					Controllers.ARTICLE.setChosenArticle(chosenArticle);

					frame.dispose();
					ReadArticle read = new ReadArticle();
					read.frame.setVisible(true);
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}

			}
		});
		btnSelect.setBounds(440, 360, 117, 29);
		frame.getContentPane().add(btnSelect);

		if(!listOfArticles.getSuccess()){
			error.setText(listOfArticles.getMessage());
			btnSelect.setVisible(false);
		}
		
		JLabel lblArticles = new JLabel("Articles");
		lblArticles.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblArticles.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticles.setBounds(217, 85, 162, 29);
		frame.getContentPane().add(lblArticles);
	}

}
