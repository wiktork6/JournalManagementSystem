package app.controllers;

import app.database.databaseInterfaces.DataAccessController;
import app.database.databaseInterfaces.DataInsertController;
import app.pojo.Author;
import app.pojo.Submission;

import java.util.ArrayList;

public class SubmissionController {
    private Submission submission;
    private DataInsertController dataInsertController;
    private DataAccessController dataAccessController;

    public SubmissionController(Submission submission, DataInsertController dataInsertController, DataAccessController dataAccessController) {
        this.submission = submission;
        this.dataInsertController = dataInsertController;
        this.dataAccessController = dataAccessController;
    }

    public boolean addCoAuthor(Author author){
        if(dataInsertController.insertCoAuthor(submission.getId(), author.getAuthorId())){
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
