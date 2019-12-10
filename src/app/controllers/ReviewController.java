package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.*;
import app.services.JournalService;
import app.services.ReviewService;
import app.services.SubmissionService;
import com.mysql.cj.util.StringUtils;

import javax.swing.*;
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

    public ActionResult<Review> addReview(Review item){
        return this.addItem(item);
    }

    public boolean canSubmitInitialReview(Submission submission, User loggedUser){
        Reviewer reviewer = Controllers.REVIEWER.getUserReviewer(loggedUser.getId());
        Review review = ((ReviewService)this.service).getSubmissionReviewerReview(submission.getId(), reviewer.getId());
        return StringUtils.isNullOrEmpty(review.getInitialVerdict());
    }

    public boolean canSubmitFinalReview(Submission submission, User loggedUser){
        Reviewer reviewer = Controllers.REVIEWER.getUserReviewer(loggedUser.getId());
        Review review = ((ReviewService)this.service).getSubmissionReviewerReview(submission.getId(), reviewer.getId());
        return StringUtils.isNullOrEmpty(review.getFinalVerdict()) && submission.getStatus().toLowerCase().equals("article updated");
    }

    public ActionResult<Review> submitInitialReview(Submission submission, User loggedUser,
                                                    String reviewSummary, String typographicalErrors, String initialVerdict,
                                                    ArrayList<Question> questions){
        Reviewer reviewer = Controllers.REVIEWER.getUserReviewer(loggedUser.getId());
        Review review = ((ReviewService)this.service).getSubmissionReviewerReview(submission.getId(), reviewer.getId());
        review.setReviewSummary(reviewSummary);
        review.setTypographicalErrors(typographicalErrors);
        review.setInitialVerdict(initialVerdict);

        ActionResult<Review> ar = super.updateItem(review);
        review = ar.getResult();
        for(Question question : questions){
            question.setReviewId(review.getId());
            Controllers.QUESTION.addQuestion(question);
        }

        int initialReviews = ((ReviewService)this.service).initialReviewsCount(submission.getId());
        if(initialReviews == 3){
            submission.setStatus("Initial Review");
            new SubmissionService().updateItem(submission);
        }

        return ar;
    }

    public ActionResult<Review> submitFinalReview(Submission submission, User loggedUser, String finalVerdict){
        Reviewer reviewer = Controllers.REVIEWER.getUserReviewer(loggedUser.getId());
        Review review = ((ReviewService)this.service).getSubmissionReviewerReview(submission.getId(), reviewer.getId());
        review.setFinalVerdict(finalVerdict);
        ActionResult<Review> ar = super.updateItem(review);

        Controllers.REVIEWER.removeReviewer(reviewer.getId());
        if(!(Controllers.USER.isAuthor(loggedUser) || Controllers.USER.isEditor(loggedUser))){
            Controllers.USER.removeUser(loggedUser.getId());
        }

        int finalReviews = ((ReviewService)this.service).finalReviewsCount(submission.getId());
        if(finalReviews == 3){
            submission.setStatus("Final Review");
            new SubmissionService().updateItem(submission);
        }
        return ar;
    }

    public Review getReview(Submission submission, Reviewer reviewer){
        return ((ReviewService)this.service).getSubmissionReviewerReview(submission.getId(), reviewer.getId());
    }

}
