package app.services;

import app.database.dataAccessControllers.QuestionDataAccessController;
import app.database.dataAccessControllers.generic.Filter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Question;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class QuestionService extends GenericService<Question> {
    QuestionService() {
        super(new QuestionDataAccessController());
    }

    public ArrayList<Question> getReviewQuestions(String reviewId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("review_id", reviewId));
        return dac.getItemsWhere(filters);
    }
}
