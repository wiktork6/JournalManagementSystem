package app.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BrowseArticles {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowseArticles window = new BrowseArticles();
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
	public BrowseArticles() {
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
		
		JLabel lblBrowseArticles = new JLabel("Browse Articles");
		lblBrowseArticles.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblBrowseArticles.setBounds(28, 53, 201, 86);
		frame.getContentPane().add(lblBrowseArticles);
		
		JButton btnViewJournals = new JButton("View Journals");
		btnViewJournals.setBounds(69, 197, 160, 86);
		frame.getContentPane().add(btnViewJournals);
		
		JButton btnViewArticles = new JButton("Look for articles");
		btnViewArticles.setBounds(367, 197, 147, 86);
		frame.getContentPane().add(btnViewArticles);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WelcomePage wlcmpge = new WelcomePage();
				wlcmpge.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(441, 356, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(267, 20, 61, 16);
		frame.getContentPane().add(lbl42);
	}

}
