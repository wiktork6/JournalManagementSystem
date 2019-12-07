package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Article;
import app.pojo.Submission;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ExistingSubmissions {

	public JFrame frame;
	private ActionResult<ArrayList<Submission>> listOfSubmissions = Controllers.SUBMISSION.getSubmissions(Controllers.AUTHOR.getAuthor(Controllers.USER.getLoggedUser()));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExistingSubmissions window = new ExistingSubmissions();
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
	public ExistingSubmissions() {
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

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(200, 360, 250, 30);
		frame.getContentPane().add(error);



		JList submissionList = new JList();
		//Default List Model for titles
		DefaultListModel volumesListModel = new DefaultListModel();
		for(int i = 0; i<listOfSubmissions.getResult().size();i++){
			volumesListModel.add(i,listOfSubmissions.getResult().get(i).getTitle());
		}
		submissionList.setModel(volumesListModel);


		JScrollPane spEditor = new JScrollPane(submissionList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spEditor.setBounds(46, 126, 511, 204);
		frame.getContentPane().add(spEditor);
		
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
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(submissionList.getSelectedIndex()!=-1){
					Submission chosenSubmission = listOfSubmissions.getResult().get(submissionList.getSelectedIndex());
					Controllers.SUBMISSION.setSelectedSubmission(chosenSubmission);

					frame.dispose();
					UploadOrReview uploadOrReview = new UploadOrReview();

					uploadOrReview.frame.setVisible(true);
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnSelect.setBounds(440, 360, 117, 29);
		frame.getContentPane().add(btnSelect);
		
		JLabel lblExistingSubmissions = new JLabel("Existing Submissions:");
		lblExistingSubmissions.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblExistingSubmissions.setHorizontalAlignment(SwingConstants.LEFT);
		lblExistingSubmissions.setBounds(46, 83, 218, 31);
		frame.getContentPane().add(lblExistingSubmissions);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(287, 36, 61, 16);
		frame.getContentPane().add(lbl42);
		
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

		if(!listOfSubmissions.getSuccess()){
			error.setText(listOfSubmissions.getMessage());
			btnSelect.setVisible(false);
		}
		
	}
}
