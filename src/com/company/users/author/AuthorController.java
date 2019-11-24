package com.company.users.author;

import com.company.database.MySqlDataAccessController;
import com.company.database.DataInsertController;
import com.company.submission.Submission;
import com.company.users.User;

public class AuthorController {
    private Author author;

    public AuthorController(Author author) {
        this.author = author;
    }
    public void createNewSubmission(String abstractText, String title, String draftArticle){
        Submission newSubmission = new Submission(abstractText, title, draftArticle, this.author.getAuthorId());
        DataInsertController.insertSubmission(newSubmission);
    }

    public void revisedArticle(){
        MySqlDataAccessController.insertRevisedArticle();
    }

    public void registerAuthor(String title, String forname, String surname, String university, String email, String password) {
        User user = new User(title, forname, surname, university, email, password);
        MySqlDataAccessController.insertUser(user);
        DataInsertController.insertNewAuthor(MySqlDataAccessController.getUserId(user.getEmail()));
    }

    public void seeReviews (Integer articleId){
        MySqlDataAccessController.getReviews(author.getAuthorId(), articleId);
    }



    public void seeResponses(){
        MySqlDataAccessController.getResponses();
    }


    public void respond (){
        MySqlDataAccessController.setResponse();
    }

    public void becomeReviewer(Author author){
        MySqlDataAccessController.insertReviewer();
    }

    public void seeQuestions(){
        MySqlDataAccessController.getQuestions();
    }
}