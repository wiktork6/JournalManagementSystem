package app.controllers;

import app.pojo.Submission;

public class SubmissionController {
    private Submission submission;

    public SubmissionController(Submission submission) {
        this.submission = submission;
    }

    public Submission createNewSubmission(){

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
