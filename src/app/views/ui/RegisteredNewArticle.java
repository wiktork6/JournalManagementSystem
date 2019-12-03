package app.views.ui;

import app.pojo.Submission;
import app.pojo.User;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;

public class RegisteredNewArticle {

	public JFrame frame;
	private JTextField txtFTitle;
	private JTextField txtFISSN;
	private JTextField txtFArticle;


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
		lblTitle.setBounds(244, 165, 130, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblISSN = new JLabel("Journal ISSN number");
		lblISSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblISSN.setBounds(209, 104, 164, 16);
		frame.getContentPane().add(lblISSN);
		
		txtFTitle = new JTextField();
		txtFTitle.setColumns(10);
		txtFTitle.setBounds(244, 183, 130, 26);
		frame.getContentPane().add(txtFTitle);
		
		txtFISSN = new JTextField();
		txtFISSN.setColumns(10);
		txtFISSN.setBounds(244, 122, 130, 26);
		frame.getContentPane().add(txtFISSN);
		
		JButton btnNext = new JButton("Next");
//		btnNext.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ArrayList<User> listOfCoAuthors = new ArrayList<>();
//				frame.dispose();
//				AddCoAuthors addCo = new AddCoAuthors(listOfCoAuthors, submission);
//				addCo.frame.setVisible(true);
//			}
//		});
		btnNext.setBackground(new Color(0, 128, 0));
		btnNext.setBounds(242, 300, 130, 67);
		frame.getContentPane().add(btnNext);
		
		JLabel lblArticle = new JLabel("Article Text");
		lblArticle.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticle.setBounds(244, 239, 130, 16);
		frame.getContentPane().add(lblArticle);
		
		txtFArticle = new JTextField();
		txtFArticle.setColumns(10);
		txtFArticle.setBounds(244, 255, 130, 26);
		frame.getContentPane().add(txtFArticle);
	}
}
