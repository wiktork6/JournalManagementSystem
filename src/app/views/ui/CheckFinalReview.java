package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckFinalReview {

	public JFrame frame;
	private Integer reviewNumber;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CheckFinalReview window = new CheckFinalReview();
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
	public CheckFinalReview(Integer reviewNumber) {
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
		label.setBounds(260, 11, 89, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("VERDICT");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(65, 127, 58, 14);
		frame.getContentPane().add(label_1);
		
		JTextPane textPane = new JTextPane();
		if(Controllers.REVIEW.getSelectedReview().getFinalVerdict()==null){
			textPane.setText(Messages.Error.FINAL_VERDICT_NOT_SUBMITTED);
		}else{
			textPane.setText(Controllers.REVIEW.getSelectedReview().getFinalVerdict());
		}
		textPane.setEditable(false);
		textPane.setBounds(133, 104, 258, 58);
		frame.getContentPane().add(textPane);
		
//		JLabel label_2 = new JLabel("REVIEW");
//		label_2.setForeground(Color.BLACK);
//		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
//		label_2.setBounds(65, 248, 58, 14);
//		frame.getContentPane().add(label_2);
//
//		JTextPane textPane_1 = new JTextPane();
//		textPane_1.setText("<Review>");
//		textPane_1.setEditable(false);
//		textPane_1.setBounds(133, 230, 258, 58);
//		frame.getContentPane().add(textPane_1);
		
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
		
		JLabel lblFinalReview = new JLabel("FINAL VERDICT");
		lblFinalReview.setBounds(246, 40, 100, 14);
		frame.getContentPane().add(lblFinalReview);
		
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
