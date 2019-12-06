package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Color;

public class DecidingArticle {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecidingArticle window = new DecidingArticle();
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
	public DecidingArticle() {
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
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();
				Controllers.JOURNAL.removeChosenJournal();
				frame.dispose();
				Login lgn=new Login();
				lgn.frame.setVisible(true);
			}
		});
		button.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel(Controllers.JOURNAL.getChosenJournal().getName());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(195, 42, 191, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("TEAM 42");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(263, 15, 61, 16);
		frame.getContentPane().add(label_1);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(66, 69, 465, 220);
		frame.getContentPane().add(list);
		
		JButton btnAccept = new JButton("ACCEPT");
		btnAccept.setBackground(Color.GREEN);
		btnAccept.setForeground(Color.BLACK);
		btnAccept.setBounds(316, 319, 89, 23);
		frame.getContentPane().add(btnAccept);
		
		JButton btnReject = new JButton("REJECT");
		btnReject.setForeground(Color.BLACK);
		btnReject.setBackground(Color.RED);
		btnReject.setBounds(442, 319, 89, 23);
		frame.getContentPane().add(btnReject);
		
		JButton button_1 = new JButton("Go Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JournalOf jo=new JournalOf();
				jo.frame.setVisible(true);
			}
		});
		button_1.setBounds(10, 362, 153, 38);
		frame.getContentPane().add(button_1);
	}
}
