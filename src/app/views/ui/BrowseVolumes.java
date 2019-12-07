package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Volume;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class BrowseVolumes {

	public JFrame frame;
	private ActionResult<ArrayList<Volume>> listOfVolumes = Controllers.VOLUME.getJournalVolumes(Controllers.JOURNAL.getChosenJournal());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowseVolumes window = new BrowseVolumes();
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
	public BrowseVolumes() {
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
		lbl42.setBounds(267, 19, 61, 16);
		frame.getContentPane().add(lbl42);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(200, 360, 250, 30);
		frame.getContentPane().add(error);



		JList volumesList = new JList();
		//Default List Model for titles
		DefaultListModel volumesListModel = new DefaultListModel();
		for(int i = 0; i<listOfVolumes.getResult().size();i++){
			volumesListModel.add(i,listOfVolumes.getResult().get(i).getYearOfPublication());
		}
		volumesList.setModel(volumesListModel);


		JScrollPane spEditor = new JScrollPane(volumesList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spEditor.setBounds(46, 126, 511, 204);
		frame.getContentPane().add(spEditor);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.JOURNAL.removeChosenJournal();
				frame.dispose();
				BrowseJournals brws = new BrowseJournals();
				brws.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(46, 360, 117, 29);
		frame.getContentPane().add(btnGoBack);

		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(volumesList.getSelectedIndex()!=-1){
					Integer index = volumesList.getSelectedIndex();
					Controllers.VOLUME.setChosenVolume(listOfVolumes.getResult().get(index));
					frame.dispose();
					BrowseEditions brws = new BrowseEditions();
					brws.frame.setVisible(true);
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}
			}
		});
		btnSelect.setBounds(440, 360, 117, 29);
		frame.getContentPane().add(btnSelect);

		if(!listOfVolumes.getSuccess()){
			error.setText(listOfVolumes.getMessage());
			btnSelect.setVisible(false);
		}
		
		JLabel lblVolumes = new JLabel("Volumes");
		lblVolumes.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblVolumes.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolumes.setBounds(217, 85, 162, 29);
		frame.getContentPane().add(lblVolumes);
	}

}
