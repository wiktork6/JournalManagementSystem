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

    public ArrayList<Review> getSubmissionReviews(String submissionId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("submission_id", submissionId));
        return dac.getItemsWhere(filters);
    }
}
