package app.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class FinalReview {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalReview window = new FinalReview();
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
	public FinalReview() {
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
		label.setBounds(258, 34, 60, 16);
		frame.getContentPane().add(label);
		
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
		
		JLabel label_1 = new JLabel("<Article Name>");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(28, 69, 135, 26);
		frame.getContentPane().add(label_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(28, 92, 530, 179);
		frame.getContentPane().add(textPane);
		
		JLabel label_2 = new JLabel("Final Verdict");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(43, 299, 135, 26);
		frame.getContentPane().add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(190, 300, 148, 27);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(386, 336, 159, 53);
		frame.getContentPane().add(btnNewButton);
	}
}
