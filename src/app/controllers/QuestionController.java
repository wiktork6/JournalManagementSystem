package app.controllers;

import app.controllers.generic.GenericController;
import app.pojo.Question;
import app.services.QuestionService;
import app.services.generic.GenericService;

public class QuestionController extends GenericController<Question> {

    public QuestionController() {
        super(new QuestionService());
    }

    @Override
    protected boolean validateItem(Question question) {
        return true;
    }
}
