package app.views.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class RegisteredArticleSubmitted {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteredArticleSubmitted window = new RegisteredArticleSubmitted();
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
	public RegisteredArticleSubmitted() {
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
		lbl42.setBounds(251, 24, 61, 16);
		frame.getContentPane().add(lbl42);
		
		
		JLabel lblArticlesubmitted = new JLabel("Article submitted!");
		lblArticlesubmitted.setVerticalAlignment(SwingConstants.TOP);
		lblArticlesubmitted.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblArticlesubmitted.setBounds(193, 171, 291, 70);
		frame.getContentPane().add(lblArticlesubmitted);
		
		JButton btnBack = new JButton("Back to main page");
//		btnBack.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.dispose();
//				UserWelcomePage usrwlcmpg = new UserWelcomePage();
//				usrwlcmpg.frame.setVisible(true);
//			}
//		});
		btnBack.setBounds(384, 308, 176, 68);
		frame.getContentPane().add(btnBack);
	}

}
