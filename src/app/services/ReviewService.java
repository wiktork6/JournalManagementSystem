package app.services;

import app.database.generic.Filter;
import app.database.generic.GenericDataAccessController;
import app.pojo.Review;
import app.pojo.Volume;

import java.util.ArrayList;

public class ReviewService extends GenericService<Review> {
    ReviewService(GenericDataAccessController<Review> dac) {
        super(dac);
    }

    public ArrayList<Review> getSubmissionReviews(String submissionId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("submission_id", submissionId));
        return dac.getItemsWhere(filters);
    }
}
