package app.controllers.register;

import app.database.databaseInterfaces.DataAccessController;
import app.pojo.Author;
import app.pojo.Editor;
import app.pojo.User;

public class RegisterUser {
    private DataAccessController dataAccessController;

    public RegisterUser( DataAccessController dataAccessController) {
        this.dataAccessController = dataAccessController;
    }
//Implement that emails cant be the same
    private User registerNewUser(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        if(password.equals(repeatPassword)){
            Integer userId = dataAccessController.insertUser(title, forname, surname, university, email, password);
            return dataAccessController.getUser(userId);

        }
        return null;
    }
    public Author registerNewAuthor(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        User user = registerNewUser(title, forname, surname, university, email, password, repeatPassword);
        Integer userId = user.getId();
        Integer authorId = dataAccessController.insertAuthor(userId);
        return new Author(user.getId(), user.getTitle(), user.getForname(), user.getSurname(), user.getUniversity(), user.getEmail(), authorId);
    }
    public Editor registerNewEditor(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        User user = registerNewUser(title, forname, surname, university, email, password, repeatPassword);
        Integer userId = user.getId();
        Integer editorId = dataAccessController.insertEditor(userId);
        return new Editor(user.getId(), user.getTitle(), user.getForname(), user.getSurname(), user.getUniversity(), user.getEmail(), editorId);
    }
}
