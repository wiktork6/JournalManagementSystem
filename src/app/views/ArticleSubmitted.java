package app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArticleSubmitted {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleSubmitted window = new ArticleSubmitted();
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
	public ArticleSubmitted() {
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
		label.setBounds(251, 24, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Acount created!");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		label_1.setBounds(157, 107, 291, 80);
		frame.getContentPane().add(label_1);
		
		JLabel lblArticlesubmitted = new JLabel("Article submitted!");
		lblArticlesubmitted.setVerticalAlignment(SwingConstants.TOP);
		lblArticlesubmitted.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblArticlesubmitted.setBounds(157, 171, 291, 70);
		frame.getContentPane().add(lblArticlesubmitted);
		
		JButton button = new JButton("Login Page");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		button.setBounds(372, 314, 182, 60);
		frame.getContentPane().add(button);
	}

}
