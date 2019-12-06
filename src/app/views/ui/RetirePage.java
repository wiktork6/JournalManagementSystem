package app.views.ui;

import app.controllers.Controllers;
import app.controllers.generic.Controller;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Editor;
import app.pojo.Journal;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RetirePage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetirePage window = new RetirePage();
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
	public RetirePage() {
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
		label.setBounds(257, 11, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Journal Of <Journal.Name>");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(192, 38, 191, 16);
		frame.getContentPane().add(label_1);
		
		JTextPane txtpnAreYouSure = new JTextPane();
		txtpnAreYouSure.setEditable(false);
		txtpnAreYouSure.setText("Are you sure you would like to retire from editor role in " + Controllers.JOURNAL.getChosenJournal().getName() + "?");
		txtpnAreYouSure.setBounds(76, 174, 448, 26);
		frame.getContentPane().add(txtpnAreYouSure);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(100, 300, 250, 30);
		frame.getContentPane().add(error);
		
		JButton btnYes = new JButton("YES");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor editor = Controllers.EDITOR.getEditor(Controllers.USER.getLoggedUser());
				Journal journal = Controllers.JOURNAL.getChosenJournal();
				ActionResult<Boolean> actionResult = Controllers.EDITOR.retire(editor, journal);
				if(actionResult.getResult()){
					Controllers.USER.logout();
					Controllers.JOURNAL.removeChosenJournal();
					frame.dispose();
					Login lgn = new Login();
					lgn.frame.setVisible(true);
				}else{
					error.setText(actionResult.getMessage());
				}

			}
		});
		btnYes.setBackground(Color.GREEN);
		btnYes.setBounds(373, 261, 89, 23);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JournalOf jo=new JournalOf();
				jo.frame.setVisible(true);
			}
		});
		btnNo.setBackground(Color.RED);
		btnNo.setBounds(135, 261, 89, 23);
		frame.getContentPane().add(btnNo);

	}
}
