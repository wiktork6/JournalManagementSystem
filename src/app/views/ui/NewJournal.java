package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.User;


import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewJournal {

	public JFrame frame;
	private JTextField txtFForename;
	private JTextField txtFSurname;
	private JTextField txtFEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;
	private JTextField txtFJournalName;
	private JTextField txtFISSN;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewJournal window = new NewJournal();
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
	public NewJournal() {
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
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
					
			}
		});
		btnGoBack.setBounds(0, 19, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JLabel lblRegister = new JLabel("Register:");
		lblRegister.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRegister.setBounds(20, 60, 107, 29);
		frame.getContentPane().add(lblRegister);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(66, 128, 61, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForename.setBounds(56, 156, 71, 16);
		frame.getContentPane().add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(66, 184, 61, 16);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUniversity.setBounds(56, 212, 71, 16);
		frame.getContentPane().add(lblUniversity);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(66, 240, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(56, 268, 71, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepeatPassword.setBounds(10, 296, 117, 16);
		frame.getContentPane().add(lblRepeatPassword);

		JList<String> titlesList = new JList<>();
		DefaultListModel titlesListModel = new DefaultListModel();
		titlesListModel.add(0,"Mr");
		titlesListModel.add(1, "Mrs");
		titlesListModel.add(2,"Miss");
		titlesListModel.add(3,"Ms");
		titlesListModel.add(4,"Dr");
		titlesListModel.add(5,"Prof");

		titlesList.setModel(titlesListModel);

		//Titles Scroll Pane
		JScrollPane titlesScrollPane = new JScrollPane();
		titlesScrollPane.setViewportView(titlesList);
		titlesList.setLayoutOrientation(JList.VERTICAL);
		titlesScrollPane.setBounds(149, 100, 130, 50);
		frame.getContentPane().add(titlesScrollPane);

		
		txtFForename = new JTextField();
		txtFForename.setColumns(10);
		txtFForename.setBounds(149, 151, 130, 26);
		frame.getContentPane().add(txtFForename);
		
		txtFSurname = new JTextField();
		txtFSurname.setColumns(10);
		txtFSurname.setBounds(149, 179, 130, 26);
		frame.getContentPane().add(txtFSurname);
		
		JTextField txtFUni = new JTextField();
		txtFUni.setColumns(10);
		txtFUni.setBounds(149, 207, 130, 26);
		frame.getContentPane().add(txtFUni);
		
		txtFEmail = new JTextField();
		txtFEmail.setColumns(10);
		txtFEmail.setBounds(149, 235, 130, 26);
		frame.getContentPane().add(txtFEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 263, 130, 21);
		frame.getContentPane().add(passwordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(149, 291, 130, 21);
		frame.getContentPane().add(passwordFieldRepeat);
		
		JLabel lblNewJournalName = new JLabel("Journal ISSN number");
		lblNewJournalName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJournalName.setBounds(409, 240, 130, 16);
		frame.getContentPane().add(lblNewJournalName);
		
		txtFJournalName = new JTextField();
		txtFJournalName.setColumns(10);
		txtFJournalName.setBounds(409, 190, 130, 26);
		frame.getContentPane().add(txtFJournalName);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(150, 300, 250, 30);
		frame.getContentPane().add(error);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (titlesList.getSelectedValue() != null && !txtFForename.getText().equals("") && !txtFSurname.getText().equals("") &&
						!txtFUni.getText().equals("") && !txtFEmail.getText().equals("") && !passwordField.getText().equals("") &&
						!passwordFieldRepeat.getText().equals("") && !txtFISSN.getText().equals("") && !txtFJournalName.getText().equals("")) {
					if(Controllers.USER.isValid(txtFEmail.getText())){
						if (Controllers.USER.isEmailTaken(txtFEmail.getText())) {
							if (Controllers.JOURNAL.isExist(txtFISSN.getText(), txtFJournalName.getText())) {
								if (txtFISSN.getText().length() == 8) {

									ActionResult<User> user = Controllers.USER.register(titlesList.getSelectedValue(), txtFForename.getText(), txtFSurname.getText(),
											txtFUni.getText(), txtFEmail.getText(), passwordField.getText(), passwordFieldRepeat.getText());
									if (user.getSuccess()) {
										Editor editor = Controllers.EDITOR.register(user.getResult());
										ActionResult<Journal> journalActionResult = Controllers.JOURNAL.register(new Journal(txtFISSN.getText(), txtFJournalName.getText(), editor.getId()));
										if (journalActionResult.getSuccess()) {
											Controllers.JOURNAL.addNewEditorToJournal(journalActionResult.getResult().getId(), editor.getId());
											frame.dispose();
											JournalCreated journalCreated = new JournalCreated();
											journalCreated.frame.setVisible(true);
										} else {
											error.setText(journalActionResult.getMessage());
										}
									} else {
										error.setText(user.getMessage());
									}
								} else {
									error.setText(Messages.Error.ISSN_LENGTH);
								}
							} else {
								error.setText(Messages.Error.JOURNAL_ALREADY_EXISTS);
							}
						} else {
							error.setText(Messages.Error.EMAIL_TAKEN);
						}
						}else{
							error.setText(Messages.Error.INVALID_EMAIL_ADRESS);
						}

				} else {
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnSubmit.setBackground(new Color(0, 128, 0));
		btnSubmit.setBounds(409, 333, 130, 67);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblJournalName = new JLabel("New journal name");
		lblJournalName.setHorizontalAlignment(SwingConstants.CENTER);
		lblJournalName.setBounds(409, 173, 130, 16);
		frame.getContentPane().add(lblJournalName);
		
		txtFISSN = new JTextField();
		txtFISSN.setColumns(10);
		txtFISSN.setBounds(409, 258, 130, 26);
		frame.getContentPane().add(txtFISSN);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(284, 24, 61, 16);
		frame.getContentPane().add(lbl42);
	}
}
