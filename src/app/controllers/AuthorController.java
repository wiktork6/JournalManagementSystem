package app.controllers;

import app.controllers.generic.GenericController;
import app.pojo.Author;
import app.services.AuthorService;

public class AuthorController extends GenericController<Author> {

    public AuthorController() {
        super(new AuthorService());
    }

    @Override
    protected boolean validateItem(Author author) {
        return true;
    }
//    public void createNewSubmission(String abstractText, String title, String draftArticle){
//        Submission newSubmission = new Submission(abstractText, title, draftArticle, this.author.getAuthorId());
//        MySqlDataInsertController.insertSubmission(newSubmission);
//    }
//
//    public void revisedArticle(){
//        MySqlDataAccessController.insertRevisedArticle();
//    }
//
//    public void registerAuthor(String title, String forname, String surname, String university, String email, String password) {
//        User user = new User(title, forname, surname, university, email, password);
//        MySqlDataAccessController.insertUser(user);
//        MySqlDataInsertController.insertNewAuthor(MySqlDataAccessController.getUserId(user.getEmail()));
//    }
//
//    public void seeReviews (Integer articleId){
//        MySqlDataAccessController.getReviews(author.getAuthorId(), articleId);
//    }
//
//
//
//    public void seeResponses(){
//        MySqlDataAccessController.getResponses();
//    }
//
//
//    public void respond (){
//        MySqlDataAccessController.setResponse();
//    }
//
//    public void becomeReviewer(Author author){
//        MySqlDataAccessController.insertReviewer();
//    }
//
//    public void seeQuestions(){
//        MySqlDataAccessController.getQuestions();
//    }
}
