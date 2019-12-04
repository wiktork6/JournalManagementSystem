package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisteredNewJournal {

	public JFrame frame;
	private JTextField txtFJornalName;
	private JTextField txtFISSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteredNewJournal window = new RegisteredNewJournal();
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
	public RegisteredNewJournal() {
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
		error.setBounds(235, 260, 250, 30);
		frame.getContentPane().add(error);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserWelcomePage usrwlcmpg = new UserWelcomePage();
				usrwlcmpg.frame.setVisible(true);

			}
		});
		btnGoBack.setBounds(0, 19, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(281, 33, 61, 16);
		frame.getContentPane().add(lbl42);
		
		JLabel lblISSN = new JLabel("Journal ISSN number");
		lblISSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblISSN.setBounds(235, 218, 130, 16);
		frame.getContentPane().add(lblISSN);
		
		txtFJornalName = new JTextField();
		txtFJornalName.setColumns(10);
		txtFJornalName.setBounds(235, 168, 130, 26);
		frame.getContentPane().add(txtFJornalName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User loggedUser = Controllers.USER.getLoggedUser();
				Editor editor = null;
				if(!Controllers.USER.isEditor(loggedUser)){
					editor = Controllers.EDITOR.register(loggedUser);
				}else{
					editor = Controllers.EDITOR.getEditor(loggedUser);
				}
				if(!txtFISSN.getText().equals("") && !txtFJornalName.equals("")){
					ActionResult<Journal> journalActionResult = Controllers.JOURNAL.register(new Journal(txtFISSN.getText(), txtFJornalName.getText(), editor.getId()));
					if(journalActionResult.getSuccess()){
						Controllers.JOURNAL.addNewEditorToJournal(journalActionResult.getResult().getId(), editor.getId());
						frame.dispose();
						JournalCreated jrnlcrtd = new JournalCreated();
						jrnlcrtd.frame.setVisible(true);

					}else{
						error.setText(Messages.Error.JOURNAL_ALREADY_EXISTS);
					}
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnSubmit.setBackground(new Color(0, 128, 0));
		btnSubmit.setBounds(235, 311, 130, 67);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblJournalName = new JLabel("New journal name");
		lblJournalName.setHorizontalAlignment(SwingConstants.CENTER);
		lblJournalName.setBounds(235, 151, 130, 16);
		frame.getContentPane().add(lblJournalName);
		
		txtFISSN = new JTextField();
		txtFISSN.setColumns(10);
		txtFISSN.setBounds(235, 236, 130, 26);
		frame.getContentPane().add(txtFISSN);
	}
}
