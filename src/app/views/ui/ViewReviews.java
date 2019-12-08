package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Review;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ViewReviews {

	public JFrame frame;

	private ActionResult<ArrayList<Review>> reviewsActionResult = Controllers.REVIEW.getSubmissionReviews(Controllers.SUBMISSION.getSelectedSubmission());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReviews window = new ViewReviews();
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
	public ViewReviews() {
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
		label.setBounds(254, 11, 70, 14);
		frame.getContentPane().add(label);
		
		JLabel lblReviews = new JLabel("Available reviews");
		lblReviews.setBounds(97, 64, 150, 14);
		frame.getContentPane().add(lblReviews);

		JLabel error = new JLabel();
		error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		error.setBounds(70, 330, 400, 30);
		frame.getContentPane().add(error);

		JList reviewsList = new JList();
		//Default List Model for titles
		DefaultListModel reviewsListModel = new DefaultListModel();
		for(int i = 0; i<reviewsActionResult.getResult().size();i++){
			reviewsListModel.add(i,"Review " + (i+1));
		}
		reviewsList.setModel(reviewsListModel);


		JScrollPane spEditor = new JScrollPane(reviewsList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spEditor.setBounds(46, 126, 511, 204);
		frame.getContentPane().add(spEditor);
		
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
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(reviewsActionResult.getResult().size()==3){
					if(reviewsList.getSelectedIndex()!=-1){
						Integer index = reviewsList.getSelectedIndex();
						Controllers.REVIEW.setSelectedReview(reviewsActionResult.getResult().get(index));
						frame.dispose();
						ReviewPage reviewPage = new ReviewPage(reviewsList.getSelectedIndex()+1);
						reviewPage.frame.setVisible(true);
					}else{
						error.setText(Messages.Error.FIELD_IS_EMPTY);
					}

				}else{
					error.setText(Messages.Error.YOU_MUST_WAIT_FOR_REVIEWS);
				}

			}
		});
		btnSelect.setBounds(440, 360, 117, 29);
		frame.getContentPane().add(btnSelect);

		if(!reviewsActionResult.getSuccess()){
			error.setText(reviewsActionResult.getMessage());
			btnSelect.setVisible(false);
		}
	}
}
