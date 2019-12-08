package app.views.ui;

import app.controllers.Controllers;
import app.pojo.Question;
import app.pojo.Submission;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class InitialReview {

	private Submission submission;
	public JFrame frame;
	private JTextField textFReview;
	private JTextField textFQ1;
	private JTextField txtFQ2;
	private JTextField txtFQ3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialReview window = new InitialReview(null);
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
	public InitialReview(Submission submission) {
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
		lbl42.setBounds(258, 34, 60, 16);
		frame.getContentPane().add(lbl42);
		
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
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblArticleName = new JLabel(submission.getTitle());
		lblArticleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblArticleName.setBounds(28, 69, 135, 26);
		frame.getContentPane().add(lblArticleName);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuestion.setBounds(127, 154, 135, 26);
		frame.getContentPane().add(lblQuestion);

		textFQ1 = new JTextField();
		textFQ1.setColumns(10);
		textFQ1.setBounds(254, 154, 189, 26);
		frame.getContentPane().add(textFQ1);

		JTextArea txtQuestions = new JTextArea();
		txtQuestions.setEditable(false);
		JScrollPane spEditor = new JScrollPane(txtQuestions,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spEditor.setBounds(254, 185, 189, 110);
		txtQuestions.setColumns(4);
		frame.getContentPane().add(spEditor);

		ArrayList<Question> questions = new ArrayList<>();
		JButton btnAddQuestion = new JButton("Add Question");
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFQ1.getText().length() > 0) {
					Question question = new Question(-1, questions.size() + 1, textFQ1.getText(), "", false, -1);
					questions.add(question);
					txtQuestions.append(question.getQuestion_number() + ". " + question.getQuestion() + " \n");
					textFQ1.setText("");
				}
			}
		});
		btnAddQuestion.setBounds(450, 154, 120, 26);
		frame.getContentPane().add(btnAddQuestion);

		JLabel lblReview = new JLabel("Review Summary");
		lblReview.setHorizontalAlignment(SwingConstants.LEFT);
		lblReview.setBounds(127, 70, 135, 26);
		frame.getContentPane().add(lblReview);
		
		textFReview = new JTextField();
		textFReview.setBounds(254, 70, 189, 26);
		frame.getContentPane().add(textFReview);
		textFReview.setColumns(10);

		JLabel lblTypoErrors = new JLabel("Typographical Errors");
		lblTypoErrors.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypoErrors.setBounds(127, 100, 135, 26);
		frame.getContentPane().add(lblTypoErrors);

		JTextField textFTypos = new JTextField();
		textFTypos.setBounds(254, 100, 189, 26);
		frame.getContentPane().add(textFTypos);
		textFTypos.setColumns(10);
		
		JLabel lblVerdict = new JLabel("Verdict");
		lblVerdict.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerdict.setBounds(127, 305, 135, 26);
		frame.getContentPane().add(lblVerdict);
		
		JComboBox<String> comboBoxVerdicts = new JComboBox<>();
		comboBoxVerdicts.setBounds(258, 306, 148, 27);
		frame.getContentPane().add(comboBoxVerdicts);
		comboBoxVerdicts.addItem("Strong Accept");
		comboBoxVerdicts.addItem("Weak Accept");
		comboBoxVerdicts.addItem("Weak Reject");
		comboBoxVerdicts.addItem("Strong Reject");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.REVIEW.submitInitialReview(submission, Controllers.USER.getLoggedUser(),
						textFReview.getText(),textFTypos.getText(), (String)comboBoxVerdicts.getSelectedItem(), questions);
				frame.dispose();
				ReviewHub rvwhb = new ReviewHub(submission);
				rvwhb.frame.setVisible(true);
			}
		});
		btnSubmit.setBounds(412, 348, 159, 53);
		frame.getContentPane().add(btnSubmit);
		
		
	}
}
