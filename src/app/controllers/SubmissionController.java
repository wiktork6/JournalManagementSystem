package app.controllers;

import app.database.dataAccessControllers.SubmissionDataAccessController;

import app.pojo.Author;
import app.pojo.Submission;

import java.util.ArrayList;

public class SubmissionController {
    private Submission submission;

    private SubmissionDataAccessController dataAccessController;

    public SubmissionController(Submission submission, SubmissionDataAccessController dataAccessController) {
        this.submission = submission;

        this.dataAccessController = dataAccessController;
    }

    public boolean addCoAuthor(Author author){
        if(dataAccessController.insertCoAuthor(submission.getId(), author.getAuthorId())){
            return true;
        }
        return false;
    }

    public ArrayList<Author> getCoAuthors(){
        return dataAccessController.getSubmissionsCoAuthors(submission.getId());
    }




//    public ArrayList<Review> getReviews(){
//        return MySqlDataAccessController.getReviews(submission.getId());
//    }
//
//    public ArrayList<String> getInitialVerdicts(){
//        ArrayList<String> initialVerdicts = new ArrayList<>();
//        ArrayList<Review> reviews = getReviews();
//        for(int i = 0; i<reviews.size(); i++){
//            initialVerdicts.add(reviews.get(i).getInitialVerdict());
//        }
//        return initialVerdicts;
//    }
//    public ArrayList<String> getFinalVerdicts(){
//        ArrayList<String> finalVerdicts = new ArrayList<>();
//        ArrayList<Review> reviews = getReviews();
//        for(int i = 0; i<reviews.size(); i++){
//            finalVerdicts.add(reviews.get(i).getInitialVerdict());
//        }
//        return finalVerdicts;
//    }


}
