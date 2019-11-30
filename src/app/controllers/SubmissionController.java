package app.controllers;

import app.controllers.generic.GenericController;
import app.pojo.Author;
import app.pojo.Submission;
import app.services.JournalService;
import app.services.SubmissionService;

import java.util.ArrayList;

public class SubmissionController extends GenericController<Submission> {

    public SubmissionController() {
        super(new SubmissionService());
    }

    public boolean addCoAuthor(Integer submissionId, Integer authorId){
        return ((SubmissionService)service).addCoAuthor(submissionId, authorId);
    }

    public ArrayList<Author> getCoAuthors(Integer submissionId){
        return ((SubmissionService)service).getSubmissionsCoAuthors(submissionId);
    }

    public Submission addSubmission(String abstractText, String title, String draftArticle, Integer authorId, String issn){
        Integer journalId = new JournalService().getJournalByISSN(issn).getId();
        return this.addItem(new Submission(abstractText, title, draftArticle, authorId, journalId));
    }

    @Override
    protected boolean validateItem(Submission submission) {
        return true;
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
