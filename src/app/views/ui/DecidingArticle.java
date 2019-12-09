package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Submission;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DecidingArticle {

	public JFrame frame;
	private ActionResult<ArrayList<Submission>> submissionActionResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecidingArticle window = new DecidingArticle();
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
	public DecidingArticle() {
		this.submissionActionResult = Controllers.SUBMISSION.getSubmissionsWithStatus(Controllers.JOURNAL.getChosenJournal(),"Final Verdict");
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
		
		JLabel label = new JLabel(Controllers.JOURNAL.getChosenJournal().getName());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(195, 42, 191, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("TEAM 42");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(263, 15, 61, 16);
		frame.getContentPane().add(label_1);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(200, 360, 250, 30);
		frame.getContentPane().add(error);



		JList submissionsList = new JList();
		//Default List Model for titles
		DefaultListModel submissionListModel = new DefaultListModel();
		for(int i = 0; i<submissionActionResult.getResult().size();i++){
			submissionListModel.add(i,submissionActionResult.getResult().get(i).getTitle());
		}
		submissionsList.setModel(submissionListModel);


		JScrollPane spEditor = new JScrollPane(submissionsList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spEditor.setBounds(46, 100, 511, 204);
		frame.getContentPane().add(spEditor);


		JButton btnAccept = new JButton("ACCEPT");
		btnAccept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(submissionsList.getSelectedIndex()!=-1){
					if(Controllers.SUBMISSION.getSubmissionsWithStatus(Controllers.JOURNAL.getChosenJournal(),"Accepted").getResult().size()<8){
						Integer index = submissionsList.getSelectedIndex();
						Submission submission = submissionActionResult.getResult().get(index);

						Controllers.SUBMISSION.setStatus(submission, "Accepted");

						frame.dispose();
						JournalOf jo=new JournalOf();
						jo.frame.setVisible(true);

					}else{
						error.setText(Messages.Error.MAXIMUM_NUMBER_OF_ARTICLES_ACHIEVED);
					}
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}

			}
		});
		btnAccept.setBackground(Color.GREEN);
		btnAccept.setForeground(Color.BLACK);
		btnAccept.setBounds(442, 319, 89, 23);
		frame.getContentPane().add(btnAccept);
		
		JButton btnReject = new JButton("REJECT");
		btnReject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(submissionsList.getSelectedIndex()!=-1){
					Integer index = submissionsList.getSelectedIndex();
					Submission submission = submissionActionResult.getResult().get(index);

					Controllers.SUBMISSION.setStatus(submission, "Rejected");

					frame.dispose();
					JournalOf jo=new JournalOf();
					jo.frame.setVisible(true);
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}

			}
		});
		btnReject.setForeground(Color.BLACK);
		btnReject.setBackground(Color.RED);
		btnReject.setBounds(316, 319, 89, 23);
		frame.getContentPane().add(btnReject);
		
		JButton button_1 = new JButton("Go Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JournalOf jo=new JournalOf();
				jo.frame.setVisible(true);
			}
		});
		button_1.setBounds(10, 362, 153, 38);
		frame.getContentPane().add(button_1);


		if(!submissionActionResult.getSuccess()){
			error.setText(submissionActionResult.getMessage());
			btnAccept.setVisible(false);
			btnReject.setVisible(false);
		}
	}


}
