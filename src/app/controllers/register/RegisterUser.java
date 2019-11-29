package app.controllers.register;

import app.database.UserDataAccessController;
import app.database.generic.DataAccessController;
import app.pojo.Author;
import app.pojo.Editor;
import app.pojo.User;

public class RegisterUser {
    private UserDataAccessController userDataAccessController;

    public RegisterUser( UserDataAccessController dataAccessController) {
        this.userDataAccessController = dataAccessController;
    }
//Implement that emails cant be the same
    private User registerNewUser(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        if(password.equals(repeatPassword)){
            Integer userId = userDataAccessController.addItem(new User(title, forname, surname, university, email, password));
            return userDataAccessController.getItem(userId);

        }
        return null;
    }
}
