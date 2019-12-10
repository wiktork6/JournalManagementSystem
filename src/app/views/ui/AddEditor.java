package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.User;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEditor {

	public JFrame frame;
	private JTextField repeatPasswordField;
	private JTextField passwordField;
	private JTextField emailField;
	private JTextField universityField;
	private JTextField surnameField;
	private JTextField forenameField;
	private JTextField txtExistingEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEditor window = new AddEditor();
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
	public AddEditor() {
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
		label.setBounds(256, 11, 61, 16);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel(Controllers.JOURNAL.getChosenJournal().getName());
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(191, 38, 191, 16);
		frame.getContentPane().add(label_1);

		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				Controllers.JOURNAL.removeChosenJournal();
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);


			}
		});
		button.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(button);

		JLabel lblUpdateTitle = new JLabel("Title");
		lblUpdateTitle.setBounds(10, 99, 66, 18);
		frame.getContentPane().add(lblUpdateTitle);

		JLabel lblForename = new JLabel("Forename");
		lblForename.setBounds(10, 128, 66, 16);
		frame.getContentPane().add(lblForename);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 155, 66, 16);
		frame.getContentPane().add(lblSurname);

		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setBounds(10, 182, 66, 16);
		frame.getContentPane().add(lblUniversity);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 209, 66, 16);
		frame.getContentPane().add(lblEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 237, 66, 16);
		frame.getContentPane().add(lblPassword);

		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setBounds(10, 264, 112, 16);
		frame.getContentPane().add(lblRepeatPassword);

		repeatPasswordField = new JPasswordField();
		repeatPasswordField.setColumns(10);
		repeatPasswordField.setBounds(159, 261, 126, 23);
		frame.getContentPane().add(repeatPasswordField);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(159, 235, 126, 23);
		frame.getContentPane().add(passwordField);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(159, 208, 126, 23);
		frame.getContentPane().add(emailField);

		universityField = new JTextField();
		universityField.setColumns(10);
		universityField.setBounds(159, 180, 126, 23);
		frame.getContentPane().add(universityField);

		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(159, 153, 126, 23);
		frame.getContentPane().add(surnameField);

		forenameField = new JTextField();
		forenameField.setColumns(10);
		forenameField.setBounds(159, 126, 126, 23);
		frame.getContentPane().add(forenameField);


		//Default List Model for titles
		JList<String> titlesList = new JList<>();
		DefaultListModel titlesListModel = new DefaultListModel();
		titlesListModel.add(0, "Mr");
		titlesListModel.add(1, "Mrs");
		titlesListModel.add(2, "Miss");
		titlesListModel.add(3, "Ms");
		titlesListModel.add(4, "Dr");
		titlesListModel.add(5, "Prof");

		titlesList.setModel(titlesListModel);

		//Titles Scroll Pane
		JScrollPane titlesScrollPane = new JScrollPane();
		titlesScrollPane.setViewportView(titlesList);
		titlesList.setLayoutOrientation(JList.VERTICAL);
		titlesScrollPane.setBounds(159, 70, 130, 50);
		frame.getContentPane().add(titlesScrollPane);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(100, 320, 250, 30);
		frame.getContentPane().add(error);

		JButton btnAddNewEditor = new JButton("Add New Editor");
		btnAddNewEditor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (titlesList.getSelectedValue() != null && !forenameField.getText().equals("") && !surnameField.getText().equals("") && !universityField.getText().equals("") &&
						!emailField.getText().equals("") && !passwordField.getText().equals("") && !repeatPasswordField.getText().equals("")) {
					if(Controllers.USER.isValid(emailField.getText())){
						if (Controllers.USER.isEmailTaken(emailField.getText())) {
							if (passwordField.getText().equals(repeatPasswordField.getText())) {
								ActionResult<User> userActionResult = Controllers.USER.register(titlesList.getSelectedValue(), forenameField.getText(), surnameField.getText(), universityField.getText(), emailField.getText(), passwordField.getText(), repeatPasswordField.getText());
								Editor editor = Controllers.EDITOR.register(userActionResult.getResult());
								Journal journal = Controllers.JOURNAL.getChosenJournal();
								Controllers.JOURNAL.addNewEditorToJournal(journal.getId(), editor.getId());
								frame.dispose();
								JournalOf journalOf = new JournalOf();
								journalOf.frame.setVisible(true);
							} else {
								error.setText(Messages.Error.PASSWORD_NOT_MATCH);
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
		btnAddNewEditor.setBounds(145, 290, 150, 30);
		frame.getContentPane().add(btnAddNewEditor);

		JButton button_1 = new JButton("Go Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JournalOf jo = new JournalOf();
				jo.frame.setVisible(true);
			}
		});
		button_1.setBounds(10, 348, 89, 23);
		frame.getContentPane().add(button_1);


		JButton btnAddExisting = new JButton("Add existing user");
		btnAddExisting.setBounds(340, 202, 200, 29);
		frame.getContentPane().add(btnAddExisting);

		JLabel lblExistingUserEmail = new JLabel("Do you want to add existing user as an editor?");
		lblExistingUserEmail.setBounds(300, 110, 300, 20);
		frame.getContentPane().add(lblExistingUserEmail);
		JLabel lblProvideEmail = new JLabel("Provide his email here:");
		lblProvideEmail.setBounds(340, 130, 150, 20);
		frame.getContentPane().add(lblProvideEmail);

		txtExistingEmail = new JTextField();
		txtExistingEmail.setBounds(380, 164, 125, 26);
		frame.getContentPane().add(txtExistingEmail);
		txtExistingEmail.setColumns(10);

		btnAddExisting.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtExistingEmail.getText().equals("")) {
					String email = txtExistingEmail.getText();
					ActionResult<User> userActionResult = Controllers.USER.getUserByEmail(txtExistingEmail.getText());
					if (userActionResult.getSuccess()) {
						if (!Controllers.USER.getLoggedUser().getEmail().equals(email)) {
							Editor newEditor = null;
							if (!Controllers.USER.isEditor(userActionResult.getResult())) {
								newEditor = Controllers.EDITOR.register(userActionResult.getResult());
							} else {
								newEditor = Controllers.EDITOR.getEditor(userActionResult.getResult());
							}
							Controllers.JOURNAL.addNewEditorToJournal(Controllers.JOURNAL.getChosenJournal().getId(), newEditor.getId());
							frame.dispose();
							JournalOf journalOf = new JournalOf();
							journalOf.frame.setVisible(true);

						} else {
							error.setText(Messages.Error.CANT_ADD_YOURSELF_AS_NEW_EDITOR);
						}
					} else {
						error.setText(Messages.Error.USER_NOT_FOUND);
					}
				} else {
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
	}
}
