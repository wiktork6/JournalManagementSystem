package app.ui;

import app.database.databaseInterfaces.DataAccessController;
import app.database.databaseInterfaces.DataInsertController;
import app.pojo.Author;
import app.pojo.Editor;
import app.pojo.User;

public class RegisterUser {
    private DataInsertController dataInsertController;
    private DataAccessController dataAccessController;

    public RegisterUser(DataInsertController dataInsertController, DataAccessController dataAccessController) {
        this.dataInsertController = dataInsertController;
        this.dataAccessController = dataAccessController;
    }
//Implement that emails cant be the same
    private User registerNewUser(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        if(password.equals(repeatPassword)){
            dataInsertController.insertUser(title, forname, surname, university, email, password);
            return dataAccessController.getUser(dataAccessController.getUserId(email));

        }
        return null;
    }
    public Author registerNewAuthor(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        User user = registerNewUser(title, forname, surname, university, email, password, repeatPassword);
        Integer userId = user.getId();
        dataInsertController.insertAuthor(userId);
        Integer authorId = dataAccessController.getAuthor(userId);
        return new Author(user.getId(), user.getTitle(), user.getForname(), user.getSurname(), user.getUniversity(), user.getEmail(), authorId);
    }
    public Editor registerNewEditor(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        User user = registerNewUser(title, forname, surname, university, email, password, repeatPassword);
        Integer userId = user.getId();
        dataInsertController.insertEditor(userId);
        Integer editorId = dataAccessController.getEditor(userId);
        return new Editor(user.getId(), user.getTitle(), user.getForname(), user.getSurname(), user.getUniversity(), user.getEmail(), editorId);
    }
}
