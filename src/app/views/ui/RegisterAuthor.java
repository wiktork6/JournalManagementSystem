package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.ActionSuccess;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Author;
import app.pojo.Submission;
import app.pojo.User;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RegisterAuthor {

	public JFrame frame;
	private JTextField txtFTitle;
	private JTextField txtFForename;
	private JTextField txtFSurname;
	private JTextField txtFUniversity;
	private JTextField txtFEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldRepeat;
	private ArrayList<User> listOfCoAuthors;
	private Submission submission;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterAuthor window = new RegisterAuthor();
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
	public RegisterAuthor(ArrayList<User> listOfCoAuthors, Submission submission) {
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
		
		JLabel lblRegisteNewAuthor = new JLabel("Register new author");
		lblRegisteNewAuthor.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblRegisteNewAuthor.setBounds(16, 80, 243, 29);
		frame.getContentPane().add(lblRegisteNewAuthor);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setBounds(62, 148, 61, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblForename = new JLabel("Forename");
		lblForename.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForename.setBounds(52, 176, 71, 16);
		frame.getContentPane().add(lblForename);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSurname.setBounds(62, 204, 61, 16);
		frame.getContentPane().add(lblSurname);
		
		JLabel lblUniversity = new JLabel("University");
		lblUniversity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUniversity.setBounds(52, 232, 71, 16);
		frame.getContentPane().add(lblUniversity);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(62, 260, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(52, 288, 71, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepeatPassword.setBounds(6, 316, 117, 16);
		frame.getContentPane().add(lblRepeatPassword);

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
		titlesScrollPane.setBounds(145, 120, 130, 50);
		frame.getContentPane().add(titlesScrollPane);
		
		txtFForename = new JTextField();
		txtFForename.setColumns(10);
		txtFForename.setBounds(145, 171, 130, 26);
		frame.getContentPane().add(txtFForename);
		
		txtFSurname = new JTextField();
		txtFSurname.setColumns(10);
		txtFSurname.setBounds(145, 199, 130, 26);
		frame.getContentPane().add(txtFSurname);
		
		txtFUniversity = new JTextField();
		txtFUniversity.setColumns(10);
		txtFUniversity.setBounds(145, 227, 130, 26);
		frame.getContentPane().add(txtFUniversity);
		
		txtFEmail = new JTextField();
		txtFEmail.setColumns(10);
		txtFEmail.setBounds(145, 255, 130, 26);
		frame.getContentPane().add(txtFEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 283, 130, 21);
		frame.getContentPane().add(passwordField);
		
		passwordFieldRepeat = new JPasswordField();
		passwordFieldRepeat.setBounds(145, 311, 130, 21);
		frame.getContentPane().add(passwordFieldRepeat);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(100, 350, 200, 30);
		frame.getContentPane().add(error);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddCoAuthors addCo = new AddCoAuthors(listOfCoAuthors, submission);
			    addCo.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(16, 22, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnAddAuthor = new JButton("Add author");
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (titlesList.getSelectedValue()!=null && !txtFForename.getText().equals("") && !txtFSurname.getText().equals("") && !txtFUniversity.getText().equals("") &&
						!txtFEmail.getText().equals("") && !passwordField.getText().equals("") && !passwordFieldRepeat.getText().equals("")) {
					if(Controllers.USER.isEmailTaken(txtFEmail.getText())){
						if (passwordField.getText().equals(passwordFieldRepeat.getText())) {
							ActionResult<User> userActionResult = Controllers.USER.register(titlesList.getSelectedValue(),txtFForename.getText(),txtFSurname.getText(),txtFUniversity.getText(),txtFEmail.getText(),passwordField.getText(),passwordFieldRepeat.getText());
							listOfCoAuthors.add(userActionResult.getResult());
							frame.dispose();
							AddCoAuthors addCo = new AddCoAuthors(listOfCoAuthors, submission);
							addCo.frame.setVisible(true);
						} else {
							error.setText(Messages.Error.PASSWORD_NOT_MATCH);
						}
					}else{
						error.setText(Messages.Error.EMAIL_TAKEN);
					}
				} else {
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnAddAuthor.setBounds(416, 334, 154, 64);
		frame.getContentPane().add(btnAddAuthor);
	}

}
