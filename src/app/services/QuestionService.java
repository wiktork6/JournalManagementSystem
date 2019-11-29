package app.services;

import app.database.generic.Filter;
import app.database.generic.GenericDataAccessController;
import app.pojo.Question;
import app.pojo.Volume;

import java.util.ArrayList;

public class QuestionService extends GenericService<Question> {
    QuestionService(GenericDataAccessController<Question> dac) {
        super(dac);
    }

    public ArrayList<Question> getReviewQuestions(String reviewId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("review_id", reviewId));
        return dac.getItemsWhere(filters);
    }
}
