package app.views.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class RegisteredNewJournal {

	public JFrame frame;
	private JTextField txtFJornalName;
	private JTextField txtFISSN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteredNewJournal window = new RegisteredNewJournal();
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
	public RegisteredNewJournal() {
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
		
		JLabel lblISSN = new JLabel("Journal ISSN number");
		lblISSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblISSN.setBounds(235, 218, 130, 16);
		frame.getContentPane().add(lblISSN);
		
		txtFJornalName = new JTextField();
		txtFJornalName.setColumns(10);
		txtFJornalName.setBounds(235, 168, 130, 26);
		frame.getContentPane().add(txtFJornalName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JournalCreated jrnlcrtd = new JournalCreated();
				jrnlcrtd.frame.setVisible(true);
			}
		});
		btnSubmit.setBackground(new Color(0, 128, 0));
		btnSubmit.setBounds(235, 311, 130, 67);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblJournalName = new JLabel("New journal name");
		lblJournalName.setHorizontalAlignment(SwingConstants.CENTER);
		lblJournalName.setBounds(235, 151, 130, 16);
		frame.getContentPane().add(lblJournalName);
		
		txtFISSN = new JTextField();
		txtFISSN.setColumns(10);
		txtFISSN.setBounds(235, 236, 130, 26);
		frame.getContentPane().add(txtFISSN);
	}
}
