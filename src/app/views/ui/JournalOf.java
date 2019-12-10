package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.User;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class JournalOf {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JournalOf window = new JournalOf();
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
	public JournalOf() {
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

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(100, 300, 250, 30);
		frame.getContentPane().add(error);
		
		JLabel lbl42 = new JLabel("TEAM 42");
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		lbl42.setBounds(265, 25, 61, 16);
		frame.getContentPane().add(lbl42);
		
		JButton btnNewButton = new JButton("Publish Next Edition");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor loggedEditor = Controllers.EDITOR.getEditor(Controllers.USER.getLoggedUser());
				Journal journal = Controllers.JOURNAL.getChosenJournal();
				Integer editorId = loggedEditor.getId();
				Integer chiefEditorId = journal.getChiefEditorId();
				if (editorId != chiefEditorId) {
					error.setText(Messages.Error.FUNCTION_NOT_ALLOWED);
				} else {
					frame.dispose();
					Publishing publishing = new Publishing();
					publishing.frame.setVisible(true);
				}

			}
		});
		btnNewButton.setBounds(60, 103, 200, 23);
		frame.getContentPane().add(btnNewButton);



		JButton btnPublishrejectArticle = new JButton("Accept/Reject Article");
		btnPublishrejectArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DecidingArticle da = new DecidingArticle();
				da.frame.setVisible(true);
			}
		});
		btnPublishrejectArticle.setBounds(60, 177, 200, 23);
		frame.getContentPane().add(btnPublishrejectArticle);
		if(Controllers.JOURNAL.submissionsEditorAffiliationOverlap(Controllers.USER.getLoggedUser(), Controllers.JOURNAL.getChosenJournal().getId()) > 0) {
			btnPublishrejectArticle.setEnabled(false);
			btnNewButton.setEnabled(false);
			JLabel lblAffiliationOverlap = new JLabel("You have affiliation overlap");
			lblAffiliationOverlap.setHorizontalAlignment(SwingConstants.CENTER);
			lblAffiliationOverlap.setBounds(60, 205, 191, 16);
			frame.getContentPane().add(lblAffiliationOverlap);
		}
		
		JButton btnAddEditor = new JButton("Add Editor");
		btnAddEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor loggedEditor = Controllers.EDITOR.getEditor(Controllers.USER.getLoggedUser());
				Journal journal = Controllers.JOURNAL.getChosenJournal();
				Integer editorId = loggedEditor.getId();
				Integer chiefEditorId = journal.getChiefEditorId();
				if(editorId!=chiefEditorId){
					error.setText(Messages.Error.FUNCTION_NOT_ALLOWED);
				}else{
					frame.dispose();
					AddEditor ae=new AddEditor();
					ae.frame.setVisible(true);;
				}
			}
		});
		btnAddEditor.setBounds(60, 249, 200, 23);
		frame.getContentPane().add(btnAddEditor);
		
		JButton btnCheckSubmissionList = new JButton("Check Submission List");
		btnCheckSubmissionList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SubmissionList sl=new SubmissionList();
				sl.frame.setVisible(true);
			}
		});
		btnCheckSubmissionList.setBounds(340, 103, 200, 23);
		frame.getContentPane().add(btnCheckSubmissionList);
		
		JButton btnRetire = new JButton("Retire");
		btnRetire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RetirePage rp=new RetirePage();
				rp.frame.setVisible(true);
			}
		});
		btnRetire.setBounds(340, 177, 200, 23);
		frame.getContentPane().add(btnRetire);


		
		JButton btnNominateNewEditor = new JButton("Nominate New Chief Editor");
		btnNominateNewEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor loggedEditor = Controllers.EDITOR.getEditor(Controllers.USER.getLoggedUser());
				Journal journal = Controllers.JOURNAL.getChosenJournal();
				Integer editorId = loggedEditor.getId();
				Integer chiefEditorId = journal.getChiefEditorId();

				if(editorId!=chiefEditorId){
					error.setText(Messages.Error.FUNCTION_NOT_ALLOWED);
				}else{
					frame.dispose();
					NominationPage np=new NominationPage();
					np.frame.setVisible(true);
				}
			}
		});
		btnNominateNewEditor.setBounds(340, 249, 200, 23);
		frame.getContentPane().add(btnNominateNewEditor);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.JOURNAL.removeChosenJournal();
				frame.dispose();
				AvailableJournals ajs=new AvailableJournals();
				ajs.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(66, 347, 153, 38);
		frame.getContentPane().add(btnGoBack);
		
		JLabel lblJournalOf = new JLabel(Controllers.JOURNAL.getChosenJournal().getName());
		lblJournalOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblJournalOf.setBounds(200, 52, 191, 16);
		frame.getContentPane().add(lblJournalOf);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controllers.USER.logout();

				Controllers.JOURNAL.removeChosenJournal();
				frame.dispose();
				Login lgn=new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogOut.setBounds(10, 22, 200, 23);
		frame.getContentPane().add(btnLogOut);
	}
}
