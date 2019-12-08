package app.services;

import app.database.dataAccessControllers.ReviewDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Review;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class ReviewService extends GenericService<Review> {
    public ReviewService() {
        super(new ReviewDataAccessController());
    }

    public ArrayList<Review> getSubmissionReviews(Integer submissionId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("submission_id", submissionId));
        return dac.getItemsWhere(filters);
    }

    public Review getSubmissionReviewerReview(Integer submissionId, Integer reviewerId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("submission_id", submissionId));
        filters.add(new KVPair("reviewer_id", reviewerId));
        return dac.getItemWhere(filters);
    }

    public Integer initialReviewsCount(Integer submissionId){
        return ((ReviewDataAccessController)dac).initialReviewsCount(submissionId);
    }

    public Integer finalReviewsCount(Integer submissionId){
        return ((ReviewDataAccessController)dac).finalReviewsCount(submissionId);
    }
}
