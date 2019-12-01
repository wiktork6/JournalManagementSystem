package app.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class SeeReview {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeReview window = new SeeReview();
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
	public SeeReview() {
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
		lbl42.setBounds(281, 33, 61, 16);
		frame.getContentPane().add(lbl42);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Reviews rev = new Reviews();
				rev.frame.setVisible(true);
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
		
		JLabel lblVerdict = new JLabel("Verdict");
		lblVerdict.setHorizontalAlignment(SwingConstants.LEFT);
		lblVerdict.setBounds(28, 107, 61, 16);
		frame.getContentPane().add(lblVerdict);
		
		JLabel lblReview = new JLabel("Review");
		lblReview.setHorizontalAlignment(SwingConstants.LEFT);
		lblReview.setBounds(28, 154, 61, 16);
		frame.getContentPane().add(lblReview);
		
		JLabel lblQuestions = new JLabel("Questions");
		lblQuestions.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuestions.setBounds(28, 271, 84, 16);
		frame.getContentPane().add(lblQuestions);
		
		JLabel lblArticleName = new JLabel("<Article Name>");
		lblArticleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblArticleName.setBounds(28, 69, 135, 26);
		frame.getContentPane().add(lblArticleName);
		
		//ADDFUNC - replace <number> with the review number
		JLabel lblReviewNo = new JLabel("Review <Number>");
		lblReviewNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReviewNo.setBounds(439, 74, 135, 26);
		frame.getContentPane().add(lblReviewNo);
		
		//ADDFUNC - replace <status> with the status
		JLabel lblStatus = new JLabel("Status: <Status>");
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setBounds(439, 11, 135, 26);
		frame.getContentPane().add(lblStatus);
		
		JButton btnRespond = new JButton("Respond");
		btnRespond.setBounds(457, 360, 117, 29);
		frame.getContentPane().add(btnRespond);
		
		JTextPane txtVerdict = new JTextPane();
		txtVerdict.setEditable(false);
		txtVerdict.setBounds(136, 106, 206, 30);
		frame.getContentPane().add(txtVerdict);
		
		JTextPane txtReview = new JTextPane();
		txtReview.setEditable(false);
		JScrollPane spEditor = new JScrollPane(txtReview,
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    spEditor.setBounds(136, 154, 206, 105);
		frame.getContentPane().add(spEditor);
		
		JList lstQuestions = new JList();
		lstQuestions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstQuestions.setBounds(136, 286, 206, 51);
		frame.getContentPane().add(lstQuestions);
	}
}
