package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.*;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class NewArticle {

	public JFrame frame;
	private JTextField txtFArticleTitle;
	private JTextField txtFISSN;
	private JTextField txtFTitle;
	private JTextField txtFForename;
	private JTextField txtFSurname;
	private JTextField txtFUni;
	private JTextField txtFEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;
	private JTextField txtFArticleText;
	private JTextField txtFArticleAbstract;
	private ArrayList<Journal> listOfJournals = Controllers.JOURNAL.getAllJournals();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewArticle window = new NewArticle();
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
	public NewArticle() {
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
		
		JLabel lblregister = new JLabel("Register:");
		lblregister.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblregister.setBounds(26, 75, 107, 29);
		frame.getContentPane().add(lblregister);
		
		JLabel lbltitle = new JLabel("Title");
		lbltitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltitle.setBounds(72, 143, 61, 16);
		frame.getContentPane().add(lbltitle);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForename.setBounds(62, 171, 71, 16);
		frame.getContentPane().add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(72, 199, 61, 16);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUniversity.setBounds(62, 227, 71, 16);
		frame.getContentPane().add(lblUniversity);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(72, 255, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(62, 283, 71, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblArticleTitle = new JLabel("Article Title");
		lblArticleTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleTitle.setBounds(429, 159, 130, 16);
		frame.getContentPane().add(lblArticleTitle);
		
		JLabel lblISSN = new JLabel("Journal ISSN number");
		lblISSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblISSN.setBounds(394, 98, 164, 16);
		frame.getContentPane().add(lblISSN);

		JLabel lblAbstractText = new JLabel("Abstract Text");
		lblAbstractText.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAbstractText.setBounds(404, 260, 130, 16);
		frame.getContentPane().add(lblAbstractText);

		txtFArticleAbstract = new JTextField();
		txtFArticleAbstract.setColumns(10);
		txtFArticleAbstract.setBounds(429, 280, 130, 26);
		frame.getContentPane().add(txtFArticleAbstract);
		
		txtFArticleTitle = new JTextField();
		txtFArticleTitle.setColumns(10);
		txtFArticleTitle.setBounds(429, 177, 130, 26);
		frame.getContentPane().add(txtFArticleTitle);

		JList<String> journalList = new JList<>();

		DefaultListModel defaultListModel = new DefaultListModel();
		for(int i = 0; i<listOfJournals.size(); i++){
			defaultListModel.add(0,listOfJournals.get(i).getIssn());
		}
		journalList.setModel(defaultListModel);
		//Journals Scroll Pane
		JScrollPane journalsScrollPane = new JScrollPane();
		journalsScrollPane.setViewportView(journalList);
		journalList.setLayoutOrientation(JList.VERTICAL);
		journalsScrollPane.setBounds(429,116,130,40);
		frame.getContentPane().add(journalsScrollPane);

		//Defoult List Model for titles
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
		titlesScrollPane.setBounds(162, 120, 130, 50);
		frame.getContentPane().add(titlesScrollPane);



		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(150, 325, 200, 30);
		frame.getContentPane().add(error);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (titlesList.getSelectedValue() != null && !txtFForename.getText().equals("") && !txtFSurname.getText().equals("") && !txtFUni.getText().equals("") &&
						!txtFEmail.getText().equals("") && !passwordField.getText().equals("") && !passwordFieldRepeat.getText().equals("") && !txtFArticleAbstract.equals("") &&
						!txtFArticleTitle.getText().equals("") && !txtFArticleText.getText().equals("") && journalList.getSelectedValue() != null) {
					if (Controllers.USER.isEmailTaken(txtFEmail.getText())) {
						ActionResult<User> userActionResult = Controllers.USER.register(titlesList.getSelectedValue(), txtFForename.getText(), txtFSurname.getText(),
								txtFUni.getText(), txtFEmail.getText(), passwordField.getText(), passwordFieldRepeat.getText());


						if (userActionResult.getSuccess()) {
							Author author = Controllers.AUTHOR.register(userActionResult.getResult());
							ActionResult<Submission> submissionActionResult = Controllers.SUBMISSION.addSubmission(txtFArticleAbstract.getText(), txtFArticleTitle.getText(), txtFArticleText.getText(), author.getId(), journalList.getSelectedValue(), "Submitted");
							if (submissionActionResult.getSuccess()) {
								Controllers.SUBMISSION.addCoAuthor(submissionActionResult.getResult().getId(), author.getId());
								ArrayList<User> listOfCoAuthors = new ArrayList<>();
								frame.dispose();
								AddCoAuthors addCo = new AddCoAuthors(listOfCoAuthors, submissionActionResult.getResult(),userActionResult.getResult());
								addCo.frame.setVisible(true);
							} else {
								error.setText(submissionActionResult.getMessage());
							}

						} else {
							error.setText(userActionResult.getMessage());

						}

					} else {
						error.setText(Messages.Error.EMAIL_TAKEN);
					}
				} else {
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnNext.setBackground(new Color(0, 128, 0));
		btnNext.setBounds(427, 344, 130, 67);
		frame.getContentPane().add(btnNext);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepeatPassword.setBounds(16, 309, 117, 16);
		frame.getContentPane().add(lblRepeatPassword);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(26, 21, 117, 29);
		frame.getContentPane().add(btnGoBack);

		
		txtFForename = new JTextField();
		txtFForename.setColumns(10);
		txtFForename.setBounds(162, 171, 130, 26);
		frame.getContentPane().add(txtFForename);
		
		txtFSurname = new JTextField();
		txtFSurname.setColumns(10);
		txtFSurname.setBounds(162, 199, 130, 26);
		frame.getContentPane().add(txtFSurname);
		
		txtFUni = new JTextField();
		txtFUni.setColumns(10);
		txtFUni.setBounds(162, 227, 130, 26);
		frame.getContentPane().add(txtFUni);
		
		txtFEmail = new JTextField();
		txtFEmail.setColumns(10);
		txtFEmail.setBounds(162, 255, 130, 26);
		frame.getContentPane().add(txtFEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 283, 130, 21);
		frame.getContentPane().add(passwordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(162, 311, 130, 21);
		frame.getContentPane().add(passwordFieldRepeat);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(284, 26, 61, 16);
		frame.getContentPane().add(lbl42);
		
		JLabel lblArticleText = new JLabel("Article Text");
		lblArticleText.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleText.setBounds(429, 213, 130, 16);
		frame.getContentPane().add(lblArticleText);
		
		txtFArticleText = new JTextField();
		txtFArticleText.setColumns(10);
		txtFArticleText.setBounds(429, 229, 130, 26);
		frame.getContentPane().add(txtFArticleText);
	}
}
