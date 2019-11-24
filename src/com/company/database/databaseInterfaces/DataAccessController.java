package com.company.database.databaseInterfaces;

import com.company.article.Article;
import com.company.edition.Edition;
import com.company.journal.Journal;
import com.company.question.Question;
import com.company.review.Review;
import com.company.volume.Volume;

import java.util.ArrayList;

public interface DataAccessController {
    ArrayList<String> getUsers();
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

}
