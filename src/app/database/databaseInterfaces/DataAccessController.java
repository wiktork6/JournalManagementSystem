package app.database.databaseInterfaces;

import app.pojo.*;

import java.util.ArrayList;

public interface DataAccessController {
    ArrayList<User> getUsers();
    Integer getUserId(String email);
    ArrayList<Journal> getJournals();
    ArrayList<Volume> getVolumes();
    ArrayList<Volume> getVolumes(String issnNumber);
    ArrayList<Edition> getEditions(Integer volumeId);
    ArrayList<Edition> getEditions();
    ArrayList<Article> getArticles(Integer editionId);
    ArrayList<Article> getArticles();
    Article showArticle(Integer articleId);
    ArrayList<Review> getReviews(Integer submissionId);
    ArrayList<Question> getQuestions(Integer reviewId);
    ArrayList<String> getAvailableJournals(Integer editorId);
    User getUser(Integer id);
    Integer getAuthor(Integer userId);
    Integer getEditor(Integer userId);
    ArrayList<Author> getSubmissionsCoAuthors(Integer submissionId);
    Integer getLastSubmissionId();

}
