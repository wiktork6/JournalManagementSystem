package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TypographicalErrors {

    public JFrame frame;
    private Integer reviewNumber;

    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public TypographicalErrors(Integer reviewNumber) {
        this.reviewNumber = reviewNumber;
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
        label.setBounds(260, 11, 89, 14);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("TYPOGRAPHICALL ERRORS");
        label_1.setForeground(Color.BLACK);
        label_1.setFont(new Font("Tahoma", Font.BOLD, 10));
        label_1.setBounds(65, 127, 200, 14);
        frame.getContentPane().add(label_1);

        JTextPane textPane = new JTextPane();
        if(Controllers.REVIEW.getSelectedReview().getTypographicalErrors()==null){
            textPane.setText(Messages.Error.TYPOGRAPHICALL_ERRORS_NOT_SUBMITTED);
        }else{
            textPane.setText(Controllers.REVIEW.getSelectedReview().getTypographicalErrors());
        }
        textPane.setEditable(false);
        textPane.setBounds(250, 104, 258, 58);
        frame.getContentPane().add(textPane);


        JButton btnGoBack = new JButton("Go Back");
        btnGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ReviewPage revp = new ReviewPage(reviewNumber);
                revp.frame.setVisible(true);
            }
        });
        btnGoBack.setBounds(10, 377, 89, 23);
        frame.getContentPane().add(btnGoBack);

        JLabel lblFinalReview = new JLabel("TYPOGRAPHICALL ERRORS");
        lblFinalReview.setBounds(210, 40, 300, 14);
        frame.getContentPane().add(lblFinalReview);

        JButton btnLogin = new JButton("LOGOUT");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controllers.USER.logout();
                Controllers.REVIEW.setSelectedReview(null);
                Controllers.SUBMISSION.setSelectedSubmission(null);
                frame.dispose();
                Login lgn = new Login();
                lgn.frame.setVisible(true);
            }
        });
        btnLogin.setBounds(10, 7, 89, 23);
        frame.getContentPane().add(btnLogin);
    }
}
