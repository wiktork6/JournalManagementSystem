package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Edition;
import app.pojo.Submission;
import app.pojo.Volume;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

public class PublishNextEdition {

	public JFrame frame;
	private ActionResult<ArrayList<Submission>> submissionActionResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublishNextEdition window = new PublishNextEdition();
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
	public PublishNextEdition() {
		this.submissionActionResult = Controllers.SUBMISSION.getSubmissionsWithStatus(Controllers.JOURNAL.getChosenJournal(),"Accepted");
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
		
		JLabel label = new JLabel(Controllers.JOURNAL.getChosenJournal().getName());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(195, 38, 191, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("TEAM 42");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(261, 11, 61, 16);
		frame.getContentPane().add(label_1);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(65, 96, 465, 220);
		frame.getContentPane().add(list);

		String monthOfPublication = Integer.toString(Calendar.getInstance().get(Calendar.MONTH));
		ArrayList<Volume> volumes = Controllers.VOLUME.getJournalVolumes(Controllers.JOURNAL.getChosenJournal()).getResult();


		Volume volume = null;
		Integer lastEditionNumber = 0;
		if(volumes != null && volumes.size() > 0) {
			volume = volumes.get(volumes.size() - 1);
			ArrayList<Edition> editions = Controllers.EDITION.getVolumeEditions(volume).getResult();
			if(editions != null && editions.size() > 0){
				lastEditionNumber = editions.get(editions.size()-1).getEdition_number();
			}
		}
		
		JLabel lblYouHave = new JLabel("You have " + submissionActionResult.getResult().size() +"  in edition " + lastEditionNumber + 1 + " month " + monthOfPublication);
		lblYouHave.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHave.setBounds(94, 69, 406, 16);
		frame.getContentPane().add(lblYouHave);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JournalOf jo=new JournalOf();
				jo.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(65, 360, 101, 23);
		frame.getContentPane().add(btnGoBack);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(200, 360, 250, 30);
		frame.getContentPane().add(error);


		JButton btnPublishEdition = new JButton("Publish Edition");
		Volume finalVolume = volume;
		Integer finalLastEditionNumber = lastEditionNumber;
		btnPublishEdition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(submissionActionResult.getResult().size()>=3){
					if(finalVolume != null) {
						Edition edition = new Edition();
						edition.setMonthOfPublication(monthOfPublication);
						edition.setEdition_number(finalLastEditionNumber + 1);
						edition.setVolumeId(finalVolume.getId());
						Controllers.EDITION.addEdition(edition);
					}

				}else{
					error.setText(Messages.Error.MINIMUM_NUMBER_OF_ARTICLES_NOT_ACHIEVED);
				}
			}
		});
		btnPublishEdition.setBounds(429, 360, 101, 23);
		frame.getContentPane().add(btnPublishEdition);
	}
}
