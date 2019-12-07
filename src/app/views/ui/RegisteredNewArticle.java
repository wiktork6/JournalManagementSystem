package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class RegisteredNewArticle {

	public JFrame frame;
	private JTextField txtFTitle;
	private JTextField txtFISSN;
	private JTextField txtFArticle;
	private JTextField txtFArticleAbstract;
	private ArrayList<Journal> listOfJournals = Controllers.JOURNAL.getAllJournals();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteredNewArticle window = new RegisteredNewArticle();
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
	public RegisteredNewArticle() {
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
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(244, 113, 130, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblISSN = new JLabel("Journal ISSN number");
		lblISSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblISSN.setBounds(209, 50, 164, 16);
		frame.getContentPane().add(lblISSN);

		JLabel lblAbstractText = new JLabel("Abstract Text");
		lblAbstractText.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAbstractText.setBounds(219, 165, 130, 16);
		frame.getContentPane().add(lblAbstractText);
		
		txtFTitle = new JTextField();
		txtFTitle.setColumns(10);
		txtFTitle.setBounds(244, 135, 130, 26);
		frame.getContentPane().add(txtFTitle);
		


		txtFArticleAbstract = new JTextField();
		txtFArticleAbstract.setColumns(10);
		txtFArticleAbstract.setBounds(244, 185, 130, 26);
		frame.getContentPane().add(txtFArticleAbstract);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(150, 325, 200, 30);
		frame.getContentPane().add(error);

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
		journalsScrollPane.setBounds(244, 70, 130, 40);
		frame.getContentPane().add(journalsScrollPane);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtFArticleAbstract.equals("") && !txtFTitle.getText().equals("") && !txtFArticle.getText().equals("") && journalList.getSelectedValue() != null) {
					User loggedUser = Controllers.USER.getLoggedUser();
					Author author = null;
					if (!Controllers.USER.isAuthor(loggedUser)) {
						author = Controllers.AUTHOR.register(loggedUser);
					} else {
						author = Controllers.AUTHOR.getAuthor(loggedUser);
					}
					ActionResult<Submission> submissionActionResult = Controllers.SUBMISSION.addSubmission(txtFArticleAbstract.getText(), txtFTitle.getText(), null, author.getId(), journalList.getSelectedValue(), "Submitted");
					if (submissionActionResult.getSuccess()) {
						Controllers.SUBMISSION.addCoAuthor(submissionActionResult.getResult().getId(), author.getId());
						ArrayList<User> listOfCoAuthors = new ArrayList<>();

						frame.dispose();
						AddCoAuthors addCo = new AddCoAuthors(listOfCoAuthors, submissionActionResult.getResult(), loggedUser);
						addCo.frame.setVisible(true);
					} else {
						error.setText(submissionActionResult.getMessage());
					}
				} else {
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnNext.setBackground(new Color(0, 128, 0));
		btnNext.setBounds(242, 300, 130, 67);
		frame.getContentPane().add(btnNext);
		
		JLabel lblArticle = new JLabel("Article Text");
		lblArticle.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticle.setBounds(244, 220, 130, 16);
		frame.getContentPane().add(lblArticle);
		
		txtFArticle = new JTextField();
		txtFArticle.setColumns(10);
		txtFArticle.setBounds(244, 240, 130, 26);
		frame.getContentPane().add(txtFArticle);
	}
}
