package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Journal;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class AvailableJournals {

	private ArrayList<Journal> listOfJournal;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvailableJournals window = new AvailableJournals();
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
	public AvailableJournals() {
		this.listOfJournal = Controllers.JOURNAL.getEditorsJournals(Controllers.EDITOR.getEditor(Controllers.USER.getLoggedUser())).getResult();
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
		lbl42.setBounds(285, 25, 61, 16);
		frame.getContentPane().add(lbl42);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				frame.dispose();
				Login lgn=new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnLogout);


		
		JList listAvailableJournals = new JList();
		listAvailableJournals.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAvailableJournals.setBounds(75, 72, 465, 220);
		frame.getContentPane().add(listAvailableJournals);



		DefaultListModel journalsListModel = new DefaultListModel();
		for(int i = 0; i<listOfJournal.size(); i++){
			journalsListModel.add(i,listOfJournal.get(i).toString());
		}

		listAvailableJournals.setModel(journalsListModel);

		//Titles Scroll Pane
		JScrollPane journalsScrollPane = new JScrollPane();
		journalsScrollPane.setViewportView(listAvailableJournals);
		listAvailableJournals.setLayoutOrientation(JList.VERTICAL);
		journalsScrollPane.setBounds(100, 100, 380, 200);
		frame.getContentPane().add(journalsScrollPane);















		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserWelcomePage usrwcl=new UserWelcomePage();
				usrwcl.frame.setVisible(true);
			}
		});

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(100, 300, 250, 30);
		frame.getContentPane().add(error);


		btnGoBack.setBounds(111, 346, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listAvailableJournals.getSelectedValue()!=null){
					String issn = listAvailableJournals.getSelectedValue().toString().substring(0,8);
					ActionResult<Journal> journal = Controllers.JOURNAL.getJournalByISSN(issn);
					if(journal.getSuccess()){
						Controllers.JOURNAL.setChosenJournal(journal.getResult());
						frame.dispose();
						JournalOf jo=new JournalOf();
						jo.frame.setVisible(true);
					}else{
						error.setText(journal.getMessage());
					}

				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnSelect.setBounds(451, 346, 89, 23);
		frame.getContentPane().add(btnSelect);
	}
}
