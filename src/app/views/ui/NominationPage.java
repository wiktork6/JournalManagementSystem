package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Editor;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class NominationPage {

	private ArrayList<Editor> editorsList;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NominationPage window = new NominationPage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public NominationPage() {
		this.editorsList =Controllers.EDITOR.getJournalsEditors(Controllers.JOURNAL.getChosenJournal()).getResult();
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
		
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.JOURNAL.removeChosenJournal();
				Controllers.USER.logout();
				frame.dispose();
				Login lgn=new Login();
				lgn.frame.setVisible(true);
			}
		});

		JList listAvailableEditors = new JList();
		listAvailableEditors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAvailableEditors.setBounds(75, 72, 465, 220);
		frame.getContentPane().add(listAvailableEditors);

		editorsList.removeIf(editor -> editor.getId()==Controllers.EDITOR.getEditor(Controllers.USER.getLoggedUser()).getId());

		DefaultListModel journalsListModel = new DefaultListModel();
		for(int i = 0; i<editorsList.size(); i++){
			journalsListModel.add(i, editorsList.get(i).toString());
		}

		listAvailableEditors.setModel(journalsListModel);

		//Titles Scroll Pane
		JScrollPane editorsScrollPane = new JScrollPane();
		editorsScrollPane.setViewportView(listAvailableEditors);
		listAvailableEditors.setLayoutOrientation(JList.VERTICAL);
		editorsScrollPane.setBounds(100, 100, 380, 200);
		frame.getContentPane().add(editorsScrollPane);




		JLabel label = new JLabel("TEAM 42");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(252, 11, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(Controllers.JOURNAL.getChosenJournal().getName());
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(187, 38, 191, 16);
		frame.getContentPane().add(label_1);
		
		JButton btnYes = new JButton("YES");
		btnYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer index = listAvailableEditors.getSelectedIndex();
				Editor newChiefEditor = editorsList.get(index);
				Controllers.JOURNAL.changeChiefEditor(newChiefEditor,Controllers.JOURNAL.getChosenJournal());
				frame.dispose();
				JournalOf jo=new JournalOf();
				jo.frame.setVisible(true);
			}
		});
		btnYes.setBackground(Color.GREEN);
		btnYes.setBounds(435, 358, 89, 23);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("NO");
		btnNo.setBackground(Color.RED);
		btnNo.setBounds(313, 358, 89, 23);
		frame.getContentPane().add(btnNo);
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to nominate selected editor as new chief editor?");
		lblAreYouSure.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAreYouSure.setBounds(124, 330, 450, 23);
		frame.getContentPane().add(lblAreYouSure);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JournalOf jo=new JournalOf();
				jo.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(10, 358, 89, 23);
		frame.getContentPane().add(btnGoBack);
	}
}
