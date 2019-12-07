package app.views.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class InitialReview {

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
					CheckInitialReview window = new CheckInitialReview();
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
	public InitialReview() {
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
				ReviewHub rvwhb = new ReviewHub();
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
		
		JLabel lblArticleName = new JLabel("<Article Name>");
		lblArticleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblArticleName.setBounds(28, 69, 135, 26);
		frame.getContentPane().add(lblArticleName);
		
		JLabel lblReview = new JLabel("Review");
		lblReview.setHorizontalAlignment(SwingConstants.LEFT);
		lblReview.setBounds(127, 152, 135, 26);
		frame.getContentPane().add(lblReview);
		
		JLabel lblQuestion = new JLabel("Question 1");
		lblQuestion.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuestion.setBounds(127, 204, 135, 26);
		frame.getContentPane().add(lblQuestion);
		
		JLabel lblQuestion2 = new JLabel("Question 2");
		lblQuestion2.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuestion2.setBounds(127, 230, 135, 26);
		frame.getContentPane().add(lblQuestion2);
		
		textFReview = new JTextField();
		textFReview.setBounds(254, 152, 189, 26);
		frame.getContentPane().add(textFReview);
		textFReview.setColumns(10);
		
		textFQ1 = new JTextField();
		textFQ1.setColumns(10);
		textFQ1.setBounds(254, 204, 189, 26);
		frame.getContentPane().add(textFQ1);
		
		txtFQ2 = new JTextField();
		txtFQ2.setColumns(10);
		txtFQ2.setBounds(254, 230, 189, 26);
		frame.getContentPane().add(txtFQ2);
		
		JLabel lblQuestion3 = new JLabel("Question 3");
		lblQuestion3.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuestion3.setBounds(127, 256, 135, 26);
		frame.getContentPane().add(lblQuestion3);
		
		txtFQ3 = new JTextField();
		txtFQ3.setColumns(10);
		txtFQ3.setBounds(254, 256, 189, 26);
		frame.getContentPane().add(txtFQ3);
		
		JLabel lblVerdict = new JLabel("Verdict");
		lblVerdict.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerdict.setBounds(127, 305, 135, 26);
		frame.getContentPane().add(lblVerdict);
		
		JComboBox comboBoxVerdicts = new JComboBox();
		comboBoxVerdicts.setBounds(258, 306, 148, 27);
		frame.getContentPane().add(comboBoxVerdicts);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.setBounds(412, 348, 159, 53);
		frame.getContentPane().add(btnSubmit);
		
		
	}
}
