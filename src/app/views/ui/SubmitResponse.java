package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;
import app.pojo.Question;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubmitResponse {

	public JFrame frame;
	private Integer reviewNumber;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SubmitResponse window = new SubmitResponse();
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
	public SubmitResponse(Integer reviewNumber) {
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
		label.setBounds(267, 11, 74, 14);
		frame.getContentPane().add(label);
		JLabel question = new JLabel(Controllers.QUESTION.getSelectedQuestion().getQuestion());
		question.setBounds(267, 40, 200, 14);
		frame.getContentPane().add(question);
		
		JLabel lblResponse = new JLabel("RESPONSE:");
		lblResponse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResponse.setForeground(new Color(0, 0, 0));
		lblResponse.setBounds(66, 117, 102, 14);
		frame.getContentPane().add(lblResponse);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(200, 360, 250, 30);
		frame.getContentPane().add(error);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(159, 117, 350, 188);
		frame.getContentPane().add(textPane);
		
		JButton btnSubmitResponse = new JButton("SUBMIT RESPONSE");
		btnSubmitResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textPane.getText().equals("")){
					Question answeredQuestion = Controllers.QUESTION.getSelectedQuestion();
					//SET QUESTION IS ANSWERED TO TRUE

					Controllers.QUESTION.answerQuestion(answeredQuestion, textPane.getText());
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
				frame.dispose();
				ResponseConfirmation respc = new ResponseConfirmation();
				respc.frame.setVisible(true);
			}
		});
		btnSubmitResponse.setBounds(384, 316, 150, 23);
		frame.getContentPane().add(btnSubmitResponse);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.QUESTION.setSelectedQuestion(null);
				frame.dispose();
				QuestionPage qp = new QuestionPage(reviewNumber);
				qp.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
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
	}
}
