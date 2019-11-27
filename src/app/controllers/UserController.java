package app.controllers;

import app.database.MySqlDataAccessController;
import app.database.databaseInterfaces.DataAccessController;
import app.pojo.Author;
import app.pojo.User;

import java.util.ArrayList;


public class UserController  {
    private User user;

    public UserController(User user){
        this.user = user;
    }

    private boolean changePassword(String password){
        return false;
    }
//    private boolean updateEmail(String email){
//        DataAccessController.updateEmail();
//    }


//    public boolean login(String email, String password){
//        DataAccessController dataAccessController = new MySqlDataAccessController();
//        ArrayList<User> listOfUsers = dataAccessController.getUsers();
//        for(int i=0; i<listOfUsers.size(); i++){
//            User user = listOfUsers.get(i);
//            if(user.getEmail().equals(email) || user.getPassword().equals(password)){
//                return true;
//            }
//        }
//        return false;
//    }
//    public User register(String forname, String surname, String title, String university, String email, String password){
//        return new Author(title, forname, surname, university, email, password,null); // should be user not author i think
//    }
    public void logout(){

    }
}
