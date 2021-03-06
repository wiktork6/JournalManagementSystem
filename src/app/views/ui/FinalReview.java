package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.pojo.Question;
import app.pojo.Submission;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class FinalReview {

	private final Submission submission;
	public JFrame frame;
	private ArrayList<Question> listOfQuestions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalReview window = new FinalReview(null);
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
	public FinalReview(Submission submission) {
		this.submission = submission;
		this.listOfQuestions = Controllers.QUESTION.getQuestionsAnswered(Controllers.REVIEW.getReview(submission,Controllers.REVIEWER.getUserReviewer(Controllers.USER.getLoggedUser().getId())));
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
		label.setBounds(258, 34, 60, 16);
		frame.getContentPane().add(label);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ReviewHub rvwhb = new ReviewHub(submission);
				rvwhb.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblArticleName = new JLabel(this.submission.getTitle());
		lblArticleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblArticleName.setBounds(28, 69, 135, 26);
		frame.getContentPane().add(lblArticleName);
		
		JTextPane txtAuthorResponse = new JTextPane();
		txtAuthorResponse.setEditable(false);
		JScrollPane spEditor = new JScrollPane(txtAuthorResponse,
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    spEditor.setBounds(28, 92, 530, 179);
		frame.getContentPane().add(spEditor);
		String questionAndAnswer = "";
		if(listOfQuestions.size()==0){
			txtAuthorResponse.setText("You did not ask any questions");
		}else{
			for(int i =0; i<listOfQuestions.size(); i++){
				questionAndAnswer+=listOfQuestions.get(i).getQuestion() + " Response: " + listOfQuestions.get(i).getResponse() +"\n";
			}
			txtAuthorResponse.setText(questionAndAnswer);
		}

		
		JLabel lblVerdict = new JLabel("Final Verdict");
		lblVerdict.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerdict.setBounds(43, 299, 135, 26);
		frame.getContentPane().add(lblVerdict);
		
		JComboBox<String> comboBoxVerdicts = new JComboBox<>();
		comboBoxVerdicts.setBounds(190, 300, 148, 27);
		frame.getContentPane().add(comboBoxVerdicts);
		comboBoxVerdicts.addItem("Strong Accept");
		comboBoxVerdicts.addItem("Weak Accept");
		comboBoxVerdicts.addItem("Weak Reject");
		comboBoxVerdicts.addItem("Strong Reject");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.REVIEW.submitFinalReview(submission, Controllers.USER.getLoggedUser(), (String)comboBoxVerdicts.getSelectedItem());
				frame.dispose();
				ReviewHub rvwhb = new ReviewHub(submission);
				rvwhb.frame.setVisible(true);
			}
		});
		btnSubmit.setBounds(386, 336, 159, 53);
		frame.getContentPane().add(btnSubmit);
	}
}
