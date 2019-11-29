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
		
		JButton btnNewButton = new JButton("View Journals");
		btnNewButton.setBounds(69, 197, 160, 86);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Look for articles");
		btnNewButton_1.setBounds(367, 197, 147, 86);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Go back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				WelcomePage wlcmpge = new WelcomePage();
				wlcmpge.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(441, 356, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel label = new JLabel("TEAM 42");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(267, 20, 61, 16);
		frame.getContentPane().add(label);
	}

}
