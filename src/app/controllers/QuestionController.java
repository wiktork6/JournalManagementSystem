package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Question;
import app.pojo.Review;
import app.pojo.Submission;
import app.services.QuestionService;

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

    public ActionResult<ArrayList<Question>> getQuestionsToAnswer(Review review){
        ActionResult<ArrayList<Question>> actionResult = new ActionResult<>();
        ArrayList<Question> listOfQuestions = ((QuestionService)service).getQuestionsToAnswer(review.getId());
        actionResult.setResult(listOfQuestions);
        if(listOfQuestions.size()==0){
            actionResult.setSuccess(false);
            actionResult.setMessage(Messages.Error.REVIEWER_NO_QUESTION);
        }else{
            actionResult.setSuccess(true);
        }
        return actionResult;
    }

    public Integer answerQuestion(Question question, String response){
        return ((QuestionService)service).answerQuestion(question, response);
    }

    public ActionResult<Question> addQuestion(Question question){
        return super.addItem(question);
    }

    public boolean isAllAnswered(Submission submission){
        ArrayList<Question> listOfAllQuestions = ((QuestionService)service).getAllQuestions(submission);
        for(int i =0; i<listOfAllQuestions.size();i++){
            if(!listOfAllQuestions.get(i).isAnswered()){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Question> getQuestionsAnswered(Review review){
        return ((QuestionService)this.service).getQuestionsAnswered(review.getId());
    }
}
