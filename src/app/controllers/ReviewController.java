package app.controllers;

import app.database.MySqlDataAccessController;
import app.pojo.Question;
import app.pojo.Review;


import java.util.ArrayList;

public class ReviewController {
    private Review review;

    public ReviewController(Review review) {
        this.review = review;
    }

//    public ArrayList<Question> getQuestions(){
//        return MySqlDataAccessController.getQuestions(review.getId());
//    }
}
