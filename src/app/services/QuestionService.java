package app.services;

import app.database.dataAccessControllers.QuestionDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Question;
import app.pojo.Submission;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class QuestionService extends GenericService<Question> {
    public QuestionService() {
        super(new QuestionDataAccessController());
    }

    public ArrayList<Question> getQuestionsToAnswer(Integer reviewId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("review_id", reviewId));
        filters.add(new KVPair("is_answered", false));
        return dac.getItemsWhere(filters);
    }

    public Integer answerQuestion(Question question, String response){
        question.setResponse(response);
        question.setAnswered(true);
        return dac.updateItem(question);
    }

    public ArrayList<Question> getAllQuestions(Submission submission){
        return ((QuestionDataAccessController)dac).getAllQuestions(submission);
    }
}
