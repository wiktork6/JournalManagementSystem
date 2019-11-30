package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDataAccessController extends GenericDataAccessController<Question> {

    @Override
    protected String getTableName() {
        return "questions";
    }

    @Override
    protected String getAllFields() {
        return "id, question_number, question, review_id";
    }

    @Override
    protected Question readItem(ResultSet res) throws SQLException {
        Integer questionId = res.getInt(1);
        Integer questionNumber = res.getInt(2);
        String questionText = res.getString(3);
        Integer reviewIdNumber = res.getInt(4);

        return new Question(questionId, questionNumber, questionText, reviewIdNumber);
    }

    @Override
    protected String getModifyFields() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Integer setModifyPreparedStatement(PreparedStatement preparedStatement, Question question) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
