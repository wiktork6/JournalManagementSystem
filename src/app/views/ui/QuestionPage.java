package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Question;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class QuestionPage {

	public JFrame frame;
	private Integer reviewNumber;
	private ActionResult<ArrayList<Question>> questionActionResult = Controllers.QUESTION.getQuestionsToAnswer(Controllers.REVIEW.getSelectedReview());

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuestionPage window = new QuestionPage();
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
	public QuestionPage(Integer reviewNumber) {
		this.reviewNumber = reviewNumber;
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
		label.setBounds(261, 22, 80, 14);
		frame.getContentPane().add(label);
		
		JLabel lblListOfQuestions = new JLabel("List of questions");
		lblListOfQuestions.setBounds(73, 99, 120, 14);
		frame.getContentPane().add(lblListOfQuestions);





		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(200, 360, 300, 30);
		frame.getContentPane().add(error);



		JList questionList = new JList();
		//Default List Model for titles
		DefaultListModel questionListModel = new DefaultListModel();
		for(int i = 0; i<questionActionResult.getResult().size();i++){
			questionListModel.add(i,questionActionResult.getResult().get(i).getQuestion());
		}
		questionList.setModel(questionListModel);


		JScrollPane spEditor = new JScrollPane(questionList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spEditor.setBounds(46, 126, 511, 204);
		frame.getContentPane().add(spEditor);



		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ReviewPage revp = new ReviewPage(reviewNumber);
				revp.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(questionList.getSelectedIndex()!=-1){
					Integer index = questionList.getSelectedIndex();
					Controllers.QUESTION.setSelectedQuestion(questionActionResult.getResult().get(index));
					frame.dispose();
					SubmitResponse sresp = new SubmitResponse(reviewNumber);
					sresp.frame.setVisible(true);;
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnSelect.setBounds(450, 377, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		JButton btnLogin = new JButton("LOGOUT");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				Controllers.REVIEW.setSelectedReview(null);
				Controllers.SUBMISSION.setSelectedSubmission(null);
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogin.setBounds(10, 7, 89, 23);
		frame.getContentPane().add(btnLogin);

		if(!questionActionResult.getSuccess()){
			error.setText(questionActionResult.getMessage());
			btnSelect.setVisible(false);
		}
	}


}
