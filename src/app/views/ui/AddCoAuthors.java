package app.views.ui;

import app.controllers.Controllers;
import app.controllers.UserController;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Author;
import app.pojo.Submission;
import app.pojo.User;
import app.services.UserService;
import app.views.ui.ArticleSubmitted;
import app.views.ui.NewArticle;
import app.views.ui.RegisterAuthor;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class AddCoAuthors {

	public JFrame frame;
	private JTextField txtFEmail;
	private ArrayList<User> listOfCoAuthors;
	private Submission submission;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddCoAuthors window = new AddCoAuthors();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */

	public AddCoAuthors(ArrayList<User> listOfCoAuthors, Submission submission) {
		this.listOfCoAuthors = listOfCoAuthors;
		this.submission = submission;
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

		JLabel lblAddCo = new JLabel("Add co-authors");
		lblAddCo.setBounds(39, 68, 149, 16);
		frame.getContentPane().add(lblAddCo);

		JLabel lblListOfCoauthors = new JLabel("List of co-authors:");
		lblListOfCoauthors.setBounds(342, 92, 125, 16);
		frame.getContentPane().add(lblListOfCoauthors);

		JTextArea txtCoAuthors = new JTextArea();
		txtCoAuthors.setEditable(false);
		JScrollPane spEditor = new JScrollPane(txtCoAuthors,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spEditor.setBounds(287, 140, 300, 192);
		txtCoAuthors.setColumns(4);
		frame.getContentPane().add(spEditor);

		String authors = "";
		for (int i = 0; i < listOfCoAuthors.size(); i++) {
			authors += listOfCoAuthors.get(i).getTitle() + " " + listOfCoAuthors.get(i).getForname() + " " + listOfCoAuthors.get(i).getSurname() + " " + listOfCoAuthors.get(i).getUniversity() + "\n";
			txtCoAuthors.setText(authors);
		}

			JButton btnNewAuthor = new JButton("Create New Author");
			btnNewAuthor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					RegisterAuthor rgstr = new RegisterAuthor(listOfCoAuthors, submission);
					rgstr.frame.setVisible(true);
				}
			});
			btnNewAuthor.setBounds(39, 361, 150, 49);
			frame.getContentPane().add(btnNewAuthor);

			JButton btnSubmit = new JButton("Submit");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//if not registered then
					for (int i = 0; i < listOfCoAuthors.size(); i++) {
						Author author = null;
						if(!Controllers.USER.isAuthor(listOfCoAuthors.get(i))){
							author = Controllers.AUTHOR.register(listOfCoAuthors.get(i));
						}else{
							author = Controllers.AUTHOR.getAuthor(listOfCoAuthors.get(i));
						}
						Controllers.SUBMISSION.addCoAuthor(submission.getId(), author.getId());
					}
					frame.dispose();
					ArticleSubmitted newArticle = new ArticleSubmitted();
					newArticle.frame.setVisible(true);
					/** if already registered
					 frame.dispose();
					 RegisteredArticleSubmitted newArticle = new RegisteredArticleSubmitted();
					 newArticle.frame.setVisible(true);*/
				}
			});
			btnSubmit.setBounds(401, 361, 150, 49);
			frame.getContentPane().add(btnSubmit);



			JLabel lblCoauthorEmail = new JLabel("Co-author email:");
			lblCoauthorEmail.setBounds(39, 142, 125, 16);
			frame.getContentPane().add(lblCoauthorEmail);

			txtFEmail = new JTextField();
			txtFEmail.setBounds(39, 164, 125, 26);
			frame.getContentPane().add(txtFEmail);
			txtFEmail.setColumns(10);

			JLabel error = new JLabel();
			error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			error.setBounds(100, 250, 200, 30);
			frame.getContentPane().add(error);

			JButton btnAdd = new JButton("Add");
			btnAdd.setBounds(39, 202, 117, 29);
			frame.getContentPane().add(btnAdd);

			btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!txtFEmail.getText().equals("")) {
						String email = txtFEmail.getText(); // cant add yourself
						ActionResult<User> userActionResult = Controllers.USER.getUserByEmail(txtFEmail.getText());

						if (userActionResult.getSuccess())
							if (!listOfCoAuthors.contains(userActionResult.getResult())) {
								listOfCoAuthors.add(userActionResult.getResult());
								String authors = "";
								for (int i = 0; i < listOfCoAuthors.size(); i++) {
									authors += listOfCoAuthors.get(i).getTitle() + " " + listOfCoAuthors.get(i).getForname() + " " + listOfCoAuthors.get(i).getSurname() + " " + listOfCoAuthors.get(i).getUniversity() + "\n";
									txtCoAuthors.setText(authors);
								}
							} else {
								error.setText(Messages.Error.ALREADY_ADDED);
							}

						else {
							error.setText(userActionResult.getMessage());
						}
					} else {
						error.setText(Messages.Error.FIELD_IS_EMPTY);
					}
				}
			});

			JLabel lblYourCoauthorDoesnt = new JLabel("Your co-author doesn't have an account?");
			lblYourCoauthorDoesnt.setBounds(39, 310, 264, 16);
			frame.getContentPane().add(lblYourCoauthorDoesnt);

			JLabel lblRegisterHimHere = new JLabel("Register him here:");
			lblRegisterHimHere.setBounds(39, 332, 264, 16);
			frame.getContentPane().add(lblRegisterHimHere);
		}
}

