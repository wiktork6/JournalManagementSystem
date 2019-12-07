package app.views.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewReviews {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReviews window = new ViewReviews();
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
	public ViewReviews() {
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
		label.setBounds(254, 11, 70, 14);
		frame.getContentPane().add(label);
		
		JLabel lblReviews = new JLabel("Reviews");
		lblReviews.setBounds(97, 64, 46, 14);
		frame.getContentPane().add(lblReviews);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText("1.");
		textPane.setBounds(97, 77, 413, 186);
		frame.getContentPane().add(textPane);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UploadOrReview uor = new UploadOrReview();
				uor.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ReviewPage revp = new ReviewPage();
				revp.frame.setVisible(true);
			}
		});
		btnSelect.setBounds(421, 274, 89, 23);
		frame.getContentPane().add(btnSelect);
	}
}
