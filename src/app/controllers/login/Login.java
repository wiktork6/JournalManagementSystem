package app.controllers.login;

import app.controllers.AuthorController;
import app.controllers.EditorController;
import app.controllers.ReviewerController;
import app.database.databaseInterfaces.DataAccessController;
import app.pojo.Author;
import app.pojo.Editor;
import app.pojo.Reviewer;
import app.pojo.User;

import java.util.ArrayList;

public class Login {
    private DataAccessController dataAccessController;

    public Login(DataAccessController dataAccessController) {
        this.dataAccessController = dataAccessController;
    }

    public User login(String email, String password){
        return dataAccessController.getUserToLogin(email,password);

    }

    public AuthorController loginAuthor(User user){
        Integer authorId = dataAccessController.getAuthor(user.getId());
        if(authorId!= null){
            return new AuthorController(new Author(user.getId(),user.getTitle(), user.getForname(), user.getSurname(), user.getUniversity(), user.getEmail(), authorId));
        }
        return null;
    }

    public ReviewerController loginReviewer(User user){
        Integer reviewerId = dataAccessController.getReviewer(user.getId());
        if(reviewerId!= null){
            return new ReviewerController(new Reviewer(user.getId(),user.getTitle(), user.getForname(), user.getSurname(), user.getUniversity(), user.getEmail(), reviewerId));
        }
        return null;
    }

//    public EditorController loginEditor(User user){
//        Integer editorId = dataAccessController.getEditor(user.getId());
//        if(editorId!= null){
//            return new EditorController(new Editor(user.getId(),user.getTitle(), user.getForname(), user.getSurname(), user.getUniversity(), user.getEmail(), editorId));
//        }
//        return null;
//    }
}
