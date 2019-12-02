package app.views.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JournalCreated {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JournalCreated window = new JournalCreated();
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
	public JournalCreated() {
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
		
		JLabel lblJournalSubmitted = new JLabel("Journal Created");
		lblJournalSubmitted.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblJournalSubmitted.setBounds(208, 180, 291, 80);
		frame.getContentPane().add(lblJournalSubmitted);
		
		JButton btnBack = new JButton("Back to login page");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
				login.frame.setVisible(true);
			}
		});
		btnBack.setBounds(384, 308, 176, 68);
		frame.getContentPane().add(btnBack);
	}

}
