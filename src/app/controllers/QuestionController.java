package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Question;
import app.pojo.Review;
import app.services.QuestionService;
import app.services.SubmissionService;

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
        Integer result = ((QuestionService)service).answerQuestion(question, response);

        SubmissionService ss = new SubmissionService();
        if(ss.unansweredReviewQuestions(Controllers.SUBMISSION.getSelectedSubmission().getId()) == 0){
            ss.changeSubmissionStatus(Controllers.SUBMISSION.getSelectedSubmission(), "Response received");
        }
        return result;
    }

    public ActionResult<Question> addQuestion(Question question){
        return super.addItem(question);
    }
}
