package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Article;
import app.pojo.Author;
import app.pojo.Submission;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class SubmissionList {

	public JFrame frame;
	private ArrayList<Submission> submissions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubmissionList window = new SubmissionList();
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
	public SubmissionList() {
		this.submissions = Controllers.SUBMISSION.getJournalsSubmissions(Controllers.JOURNAL.getChosenJournal()).getResult();
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
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(267, 11, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(Controllers.JOURNAL.getChosenJournal().getName());
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(202, 38, 191, 16);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				Controllers.JOURNAL.removeChosenJournal();
				frame.dispose();
				Login lgn=new Login();
				lgn.frame.setVisible(true);
			}
		});
		button.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Go Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JournalOf jo=new JournalOf();
				jo.frame.setVisible(true);
			}
		});
		button_1.setBounds(10, 368, 116, 32);
		frame.getContentPane().add(button_1);


		JList listAvailableSubmissions = new JList();
		listAvailableSubmissions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAvailableSubmissions.setBounds(75, 72, 465, 220);
		frame.getContentPane().add(listAvailableSubmissions);



		DefaultListModel submissionsListModel = new DefaultListModel();
		for(int i = 0; i<submissions.size(); i++){
			ActionResult<ArrayList<Author>> authorsActionResult = Controllers.SUBMISSION.getCoAuthors(submissions.get(i).getId());
			ArrayList<Author> authorsList = authorsActionResult.getResult();
			for(Author author:authorsList){
				if(Controllers.USER.getLoggedUser().getUniversity().equals(author.getUser().getUniversity())){
					break;
				}else{
					submissionsListModel.add(i,submissions.get(i).toString());
				}
			}
		}

		listAvailableSubmissions.setModel(submissionsListModel);


		//Titles Scroll Pane
		JScrollPane journalsScrollPane = new JScrollPane();
		journalsScrollPane.setViewportView(listAvailableSubmissions);
		listAvailableSubmissions.setLayoutOrientation(JList.VERTICAL);
		journalsScrollPane.setBounds(100, 100, 380, 200);
		frame.getContentPane().add(journalsScrollPane);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(200, 360, 250, 30);
		frame.getContentPane().add(error);
		
		JButton btnRead = new JButton("Open PDF");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listAvailableSubmissions.getSelectedIndex()!=-1){
					Submission chosenSubmission = submissions.get(listAvailableSubmissions.getSelectedIndex());
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.open(chosenSubmission.getDraftArticle());
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnRead.setBounds(416, 314, 101, 32);
		frame.getContentPane().add(btnRead);
	}
}
