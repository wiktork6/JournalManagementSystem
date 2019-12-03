package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        throw new UnsupportedOperationException();
    }

    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Review review) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
