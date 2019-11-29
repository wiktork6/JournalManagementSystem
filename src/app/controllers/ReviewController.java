package app.controllers;

import app.pojo.Review;

public class ReviewController {
    private Review review;

    public ReviewController(Review review) {
        this.review = review;
    }

//    public ArrayList<Question> getQuestions(){
//        return MySqlDataAccessController.getQuestions(review.getId());
//    }
}
