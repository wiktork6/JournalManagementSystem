package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Review;

import java.sql.*;

public class ReviewDataAccessController extends GenericDataAccessController<Review> {
    @Override
    protected String getTableName() {
        return "reviews";
    }

    @Override
    protected String getAllFields() {
        return "id, review_summary, typographical_errors, initial_verdict, final_verdict, submission_id, reviewer_id";
    }

    @Override
    protected Review readItem(ResultSet res) throws SQLException {
        Integer reviewId = res.getInt(1);
        String reviewSummary = res.getString(2);
        String typographicallErorrs = res.getString(3);
        String initialVerdict = res.getString(4);
        String finalVerdict = res.getString(5);
        Integer submissionIdNumber = res.getInt(6);
        Integer reviewerId = res.getInt(7);
        return new Review(reviewId, reviewSummary, typographicallErorrs, initialVerdict, finalVerdict, submissionIdNumber, reviewerId);
    }

    @Override
    protected String getInsertFields() {
        return "review_summary, typographical_errors, initial_verdict, final_verdict, submission_id, reviewer_id";
    }

    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Review review) throws SQLException {
        preparedStatement.setString(1, review.getReviewSummary());
        preparedStatement.setString(2, review.getTypographicalErrors());
        preparedStatement.setString(3, review.getInitialVerdict());
        preparedStatement.setString(4, review.getFinalVerdict());
        preparedStatement.setInt(5, review.getSubmissionId());
        preparedStatement.setInt(6, review.getReviewerId());
        return 6;
    }

    public Integer initialReviewsCount(Integer submissionId){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT COUNT(*) FROM " + getTableName() + " WHERE submission_id = ? AND LENGTH(initial_verdict) > 0")){
            preparedStatement.setInt(1, submissionId);
            ResultSet res = preparedStatement.executeQuery();
            res.next();
            return res.getInt(1);
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Integer finalReviewsCount(Integer submissionId){
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT COUNT(*) FROM " + getTableName() + " WHERE submission_id = ? AND LENGTH(final_verdict) > 0")){
            preparedStatement.setInt(1, submissionId);

            ResultSet res = preparedStatement.executeQuery();
            res.next();
            return res.getInt(1);
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
