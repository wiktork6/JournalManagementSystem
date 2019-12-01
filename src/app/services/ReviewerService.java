package app.services;

import app.database.dataAccessControllers.ReviewerDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Reviewer;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class ReviewerService extends GenericService<Reviewer> {
    public ReviewerService() {
        super(new ReviewerDataAccessController());
    }

    public Reviewer getUserReviewer(Integer userId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("user_id", userId));
        return dac.getItemWhere(filters);
    }
}
