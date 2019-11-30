package app.controllers;

import app.controllers.generic.GenericController;
import app.pojo.Review;
import app.services.ReviewService;

public class ReviewController extends GenericController<Review> {

    public ReviewController() {
        super(new ReviewService());
    }

    @Override
    protected boolean validateItem(Review review) {
        return true;
    }

}
