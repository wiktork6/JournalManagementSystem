package app.services;

import app.database.dataAccessControllers.QuestionDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Question;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class QuestionService extends GenericService<Question> {
    public QuestionService() {
        super(new QuestionDataAccessController());
    }

    public ArrayList<Question> getReviewQuestions(String reviewId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("review_id", reviewId));
        return dac.getItemsWhere(filters);
    }
}
