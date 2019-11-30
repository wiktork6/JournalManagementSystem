package app.controllers;

import app.controllers.generic.GenericController;
import app.pojo.User;
import app.services.UserService;


public class UserController extends GenericController<User> {
    private User loggedUser;

    public UserController(){
        super(new UserService());
    }

    public User login(String email, String password){
        this.loggedUser = ((UserService)this.service).authentecateUser(email, password);
        return this.loggedUser;
    }

    public User register(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        if(password.equals(repeatPassword)) {
            return null;
        }
        return this.addItem(new User(title, forname, surname, university, email, password));
    }

    public User updateAccount(Integer id, String title, String forname, String surname, String university, String email, String password, String repeatPassword)
    {
        if(password != null && repeatPassword != null && !password.equals(repeatPassword)) {
            return null;
        }
        User updated = this.updateItem(new User(id, title, forname, surname, university, email, password));
        if(updated != null){
            updated.setId(this.loggedUser.getId());
            this.loggedUser = updated;
        }
        return updated;
    }

    public User getLoggedUser(){
        return this.loggedUser;
    }

    public void logout(){
        this.loggedUser = null;
    }

    @Override
    protected boolean validateItem(User user) {
        return true;
    }
}
