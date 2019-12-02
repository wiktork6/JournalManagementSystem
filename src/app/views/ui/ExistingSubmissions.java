package app.views.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExistingSubmissions {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExistingSubmissions window = new ExistingSubmissions();
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
	public ExistingSubmissions() {
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
		
		JList listSubmissions = new JList();
		listSubmissions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane spEditor = new JScrollPane(listSubmissions,
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    spEditor.setBounds(46, 126, 511, 204);
		frame.getContentPane().add(spEditor);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserWelcomePage usrwlcm = new UserWelcomePage();
				usrwlcm.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Reviews rev = new Reviews();
				rev.frame.setVisible(true);
			}
		});
		btnSelect.setBounds(440, 360, 117, 29);
		frame.getContentPane().add(btnSelect);
		
		JLabel lblExistingSubmissions = new JLabel("Existing Submissions:");
		lblExistingSubmissions.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblExistingSubmissions.setHorizontalAlignment(SwingConstants.LEFT);
		lblExistingSubmissions.setBounds(46, 83, 218, 31);
		frame.getContentPane().add(lblExistingSubmissions);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(287, 36, 61, 16);
		frame.getContentPane().add(lbl42);
		
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
		
	}
}
