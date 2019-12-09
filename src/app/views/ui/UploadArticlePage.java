package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;
import app.pojo.Submission;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class UploadArticlePage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadArticlePage window = new UploadArticlePage();
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
	public UploadArticlePage() {
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



		JButton btnChooseFile = new JButton("Choose file");
		final File[] selectedFile = new File[1];
		JLabel lblSelectedFile = new JLabel("No file selected.");
		lblSelectedFile.setBounds(460, 370, 117, 16);
		frame.getContentPane().add(lblSelectedFile);
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Select an article");
				fc.setCurrentDirectory(new File(System.getProperty("user.home")));
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fc.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
					selectedFile[0] = fc.getSelectedFile();
					lblSelectedFile.setText(selectedFile[0].getName());

				} else {
					lblSelectedFile.setText("File not approved.");
				}
			}
		});
		btnChooseFile.setBounds(300, 350, 149, 54);
		frame.getContentPane().add(btnChooseFile);




		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(150, 325, 200, 30);
		frame.getContentPane().add(error);


		JButton btnNewButton = new JButton("UPLOAD FILE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedFile[0] != null){
					Submission selectedSubmission = Controllers.SUBMISSION.getSelectedSubmission();
					selectedSubmission.setDraftArticle(selectedFile[0]);
					Controllers.SUBMISSION.setStatus(selectedSubmission,"Article Updated");
					frame.dispose();
					UploadConfirmation upc = new UploadConfirmation();
					upc.frame.setVisible(true);
				}else{
					error.setText(Messages.Error.FIELD_IS_EMPTY);
				}

			}
		});
		btnNewButton.setBounds(210, 193, 133, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("TEAM 42");
		label.setBounds(254, 11, 67, 14);
		frame.getContentPane().add(label);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UploadOrReview uor = new UploadOrReview();
				uor.frame.setVisible(true);
			}
		});
		btnGoBack.setBounds(10, 377, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		JButton btnLogin = new JButton("LOGOUT");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login lgn = new Login();
				lgn.frame.setVisible(true);
			}
		});
		btnLogin.setBounds(10, 7, 89, 23);
		frame.getContentPane().add(btnLogin);
	}

}
