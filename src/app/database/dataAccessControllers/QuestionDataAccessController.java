package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.Question;
import app.pojo.Submission;

import java.sql.*;
import java.util.ArrayList;

public class QuestionDataAccessController extends GenericDataAccessController<Question> {

    @Override
    protected String getTableName() {
        return "questions";
    }

    @Override
    protected String getAllFields() {
        return "id, question_number, question,response, is_answered, review_id";
    }

    @Override
    protected String getIndexFields(){
        return "id, question_number";
    }

    @Override
    protected Question readItem(ResultSet res) throws SQLException {
        Integer questionId = res.getInt(1);
        Integer questionNumber = res.getInt(2);
        String questionText = res.getString(3);
        String response = res.getString(4);
        Boolean isAnswered = res.getBoolean(5);
        Integer reviewIdNumber = res.getInt(6);

        return new Question(questionId, questionNumber, questionText,response, isAnswered, reviewIdNumber);
    }

    @Override
    protected String getInsertFields() {
        return "question_number, question, response, is_answered, review_id";
    }

    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Question question) throws SQLException {
        preparedStatement.setInt(1,question.getQuestion_number());
        preparedStatement.setString(2,question.getQuestion());
        preparedStatement.setString(3,question.getResponse());
        preparedStatement.setBoolean(4,question.isAnswered());
        preparedStatement.setInt(5,question.getReviewId());
        return 5;
    }

    public ArrayList<Question> getAllQuestions(Submission submission) {
        try (Connection conn = DriverManager.getConnection(DbConnection.STRING);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT q.id, q.question_number, q.question, q.response, q.is_answered, q.review_id FROM questions q INNER JOIN reviews r ON q.review_id = r.id INNER JOIN submissions s ON r.submission_id = s.id WHERE s.id = ?;")) {

            preparedStatement.setInt(1, submission.getId());
            ArrayList<Question> listOfQuestions = new ArrayList<>();
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                listOfQuestions.add(readItem(res));
            }


            return listOfQuestions;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
