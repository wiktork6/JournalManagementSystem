package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Review;
import app.pojo.Submission;
import app.services.JournalService;
import app.services.ReviewService;

import java.util.ArrayList;

public class ReviewController extends GenericController<Review> {
    private Review selectedReview;

    public ReviewController() {
        super(new ReviewService());
    }

    @Override
    protected boolean validateItem(Review review) {
        return true;
    }

    public ActionResult<ArrayList<Review>> getSubmissionReviews(Submission submission){
        ActionResult<ArrayList<Review>> actionResult = new ActionResult<>();

       actionResult.setResult(((ReviewService)this.service).getSubmissionReviews(submission.getId()));
       if(actionResult.getResult().size()==0){
           actionResult.setSuccess(false);
           actionResult.setMessage(Messages.Error.REVIEW_NOT_FOUND);
       }else{
           actionResult.setSuccess(true);
       }
       return actionResult;
    }

    public void setSelectedReview(Review selectedReview){
        this.selectedReview=selectedReview;
    }

    public Review getSelectedReview(){
        return this.selectedReview;
    }

}
