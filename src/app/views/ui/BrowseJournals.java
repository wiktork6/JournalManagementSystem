package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.pojo.Journal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;
import java.security.cert.CertificateRevokedException;
import java.util.ArrayList;

public class BrowseJournals {

	public JFrame frame;
	private ArrayList<Journal> listOfAllJournals = Controllers.JOURNAL.getAllJournals();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowseJournals window = new BrowseJournals();
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
	public BrowseJournals() {
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
		
		JList journalsList = new JList();



		//Default List Model for titles
		DefaultListModel journalsListModel = new DefaultListModel();
		for(int i = 0; i<listOfAllJournals.size();i++){
			journalsListModel.add(i,listOfAllJournals.get(i).getIssn() + " " + listOfAllJournals.get(i).getName());
		}
		journalsList.setModel(journalsListModel);


		JScrollPane spEditor = new JScrollPane(journalsList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    spEditor.setBounds(46, 126, 511, 204);
		frame.getContentPane().add(spEditor);




		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WelcomePage wlcm = new WelcomePage();
				wlcm.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(journalsList.getSelectedIndex()!=-1){
					Journal selectedJournal = listOfAllJournals.get(journalsList.getSelectedIndex());
					Controllers.JOURNAL.setChosenJournal(selectedJournal);
					frame.dispose();
					BrowseVolumes brws = new BrowseVolumes();
					brws.frame.setVisible(true);
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnSelect.setBounds(440, 360, 117, 29);
		frame.getContentPane().add(btnSelect);
		
		JLabel lblJournals = new JLabel("Journals");
		lblJournals.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblJournals.setHorizontalAlignment(SwingConstants.CENTER);
		lblJournals.setBounds(217, 85, 162, 29);
		frame.getContentPane().add(lblJournals);
	}
}
