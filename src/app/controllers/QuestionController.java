package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Question;
import app.pojo.Review;
import app.services.QuestionService;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class QuestionController extends GenericController<Question> {
    private Question selectedQuestion;

    public QuestionController() {
        super(new QuestionService());
    }

    @Override
    protected boolean validateItem(Question question) {
        return true;
    }

    public Question getSelectedQuestion() {
        return selectedQuestion;
    }

    public void setSelectedQuestion(Question selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }

    public ActionResult<ArrayList<Question>> getReviewQuestions(Review review){
        ActionResult<ArrayList<Question>> actionResult = new ActionResult<>();
        ArrayList<Question> listOfQuestions = ((QuestionService)service).getReviewQuestions(review.getId());
        actionResult.setResult(listOfQuestions);
        if(listOfQuestions.size()==0){
            actionResult.setSuccess(false);
            actionResult.setMessage(Messages.Error.REVIEWER_NO_QUESTION);
        }else{
            actionResult.setSuccess(true);
        }
        return actionResult;
    }

    public void answerQuestion(Question question, String response){
        ((QuestionService)service).answerQuestion(question, response);
    }
}
