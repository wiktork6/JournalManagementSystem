package app.views.ui;

import app.controllers.Controllers;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Edition;
import app.pojo.Journal;
import app.pojo.Submission;
import app.pojo.Volume;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

public class Publishing {

    public JFrame frame;
    private ActionResult<ArrayList<Submission>> submissionAcceptedActionResult;
    private ActionResult<ArrayList<Submission>> submissionCompletedActionResult;
    private Volume currentVolume;
    private Edition currentEdition;
    private JTextField volumeYear;



    public Publishing() {
        this.submissionAcceptedActionResult = Controllers.SUBMISSION.getSubmissionsWithStatus(Controllers.JOURNAL.getChosenJournal(),"Accepted");
        this.submissionCompletedActionResult = Controllers.SUBMISSION.getSubmissionsWithStatus(Controllers.JOURNAL.getChosenJournal(),"Completed");
        this.currentVolume = Controllers.VOLUME.getLastVolume(Controllers.JOURNAL.getChosenJournal());
        this.currentEdition = Controllers.EDITION.getLastEdition(currentVolume);
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

        //Error
        JLabel error = new JLabel();
        error.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        error.setBounds(200, 320, 350, 30);
        frame.getContentPane().add(error);


        JLabel currentEditionLabel = null;
        if(currentVolume==null){
            currentEditionLabel = new JLabel("vol.0" + "No.0");
        }else if(currentEdition==null){
            currentEditionLabel = new JLabel("vol."+ this.currentVolume.getVolumeNumber() + "No.0");
        } else{
            currentEditionLabel = new JLabel("vol." + this.currentVolume.getVolumeNumber() + " No." + this.currentEdition.getEdition_number() + " " + this.currentEdition.getMonthOfPublication());
        }
        currentEditionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentEditionLabel.setBounds(330, 50, 191, 16);
        frame.getContentPane().add(currentEditionLabel);

            JButton newVolumeButton = new JButton("Create Volume");
            newVolumeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(currentEdition!=null){
                        if(currentEdition.getEdition_number()<4){
                            error.setText(Messages.Error.MIN_EDITION_PER_VOLUME);
                        }else{
                            Controllers.VOLUME.createNewVolume(Controllers.JOURNAL.getChosenJournal());
                            frame.dispose();
                            Publishing publishing = new Publishing();
                            publishing.frame.setVisible(true);

                        }
                    }else{
                        error.setText(Messages.Error.MIN_EDITION_PER_VOLUME);
                    }
                }
            });
            newVolumeButton.setBounds(250, 360, 120, 23);
            frame.getContentPane().add(newVolumeButton);


        if(currentVolume!=null  ){
            JButton newEditionButton = new JButton("Create Edition");
            newEditionButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (currentEdition == null) {
                        Controllers.EDITION.createNewEdition(currentVolume);
                        frame.dispose();
                        Publishing publishing = new Publishing();
                        publishing.frame.setVisible(true);
                    } else if (currentEdition.getEdition_number() != 6) {
                        Controllers.EDITION.createNewEdition(currentVolume);
                        frame.dispose();
                        Publishing publishing = new Publishing();
                        publishing.frame.setVisible(true);
                    } else {
                        error.setText(Messages.Error.MAX_EDITIONS_PER_VOLUME);
                    }
                }
            });
            newEditionButton.setBounds(400, 360, 120, 23);
            frame.getContentPane().add(newEditionButton);
        }else{
            error.setText(Messages.Error.CREATE_NEW_VOLUME);
        }


        JLabel label_1 = new JLabel("TEAM 42");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setBounds(261, 11, 61, 16);
        frame.getContentPane().add(label_1);


        //List of Accepted Articles
        JList acceptedArticles = new JList();
        acceptedArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        acceptedArticles.setBounds(40, 96, 200, 150);
        frame.getContentPane().add(acceptedArticles);

        DefaultListModel submissionsListModel = new DefaultListModel();
        for(int i = 0; i<submissionAcceptedActionResult.getResult().size();i++){
            submissionsListModel.add(i,submissionAcceptedActionResult.getResult().get(i).getTitle());
        }
        acceptedArticles.setModel(submissionsListModel);

        //Button add to next edition
        JButton addToNextEdition = new JButton("Add to next edition");
        addToNextEdition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(acceptedArticles.getSelectedIndex()!=-1){
                    if(submissionCompletedActionResult.getResult().size()>=8){
                        Integer index = acceptedArticles.getSelectedIndex();
                        Controllers.SUBMISSION.setStatus(submissionAcceptedActionResult.getResult().get(index),"Completed");
                        frame.dispose();
                        Publishing publishing = new Publishing();
                        publishing.frame.setVisible(true);

                    }else{
                        error.setText(Messages.Error.MAXIMUM_NUMBER_OF_ARTICLES_ACHIEVED);
                    }
                }else{
                    error.setText(Messages.Error.FIELD_IS_EMPTY);
                }

            }
        });
        addToNextEdition.setBounds(65, 250, 150, 23);
        frame.getContentPane().add(addToNextEdition);

        //List of articles to publish
        JList nextEdition = new JList();
        nextEdition.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nextEdition.setBounds(250, 96, 200, 150);
        frame.getContentPane().add(nextEdition);

        DefaultListModel submissionsAcceptedListModel = new DefaultListModel();
        for(int i = 0; i<submissionCompletedActionResult.getResult().size();i++){
            submissionsAcceptedListModel.add(i,submissionCompletedActionResult.getResult().get(i).getTitle());
        }
        nextEdition.setModel(submissionsAcceptedListModel);

        //publish next edition
        JButton publishNext = new JButton("Publish next edition");
        publishNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(nextEdition.getSelectedIndex()!=-1){
                    if(currentEdition!=null && currentVolume!=null){
                        if(submissionCompletedActionResult.getResult().size()>0){
                            for(int i=0; i<submissionCompletedActionResult.getResult().size(); i++){
                                Controllers.ARTICLE.publishArticle(submissionCompletedActionResult.getResult().get(i),currentEdition);
//                                Controllers.SUBMISSION.setStatus(submissionCompletedActionResult.getResult().get(i),"Published");
                            }
                            if(currentEdition.getEdition_number()==6){
                                Controllers.VOLUME.createNewVolume(Controllers.JOURNAL.getChosenJournal());
                            }else{
                                Controllers.EDITION.createNewEdition(currentVolume);
                            }
                            frame.dispose();
                            Publishing publishing = new Publishing();
                            publishing.frame.setVisible(true);

                        }else{
                            error.setText(Messages.Error.MINIMUM_NUMBER_OF_ARTICLES_NOT_ACHIEVED);

                        }
                    }else{
                        error.setText(Messages.Error.CREATE_VOLUME_OR_EDITION);
                    }


                }else{
                    error.setText(Messages.Error.FIELD_IS_EMPTY);
                }

            }
        });
        publishNext.setBounds(270, 250, 150, 23);
        frame.getContentPane().add(publishNext);



















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

    }
}
