package com.company.review;

import com.company.database.MySqlDataAccessController;
import com.company.question.Question;


import java.util.ArrayList;

public class ReviewController {
    private Review review;

    public ReviewController(Review review) {
        this.review = review;
    }

    public ArrayList<Question> getQuestions(){
        return MySqlDataAccessController.getQuestions(review.getId());
    }
}
