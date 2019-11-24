package com.company.users;

import com.company.users.author.Author;

// If u need some functionallity that does not exist do something like [ClassName].[methodName()]
// and then the person responsible for that class will implement the method later
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

    public boolean loginAsReader(){
        return true;
    }
    public boolean loginAsReviewer(){
        return true;
    }
    public boolean loginAsEditor(){
        return true;
    }
    public boolean loginAsAuthor(){
        return true;
    }
    public User register(String forname, String surname, String title, String university, String email, String password){
        return new Author(title, forname, surname, university, email, password,null); // should be user not author i think
    }
    public void logout(){

    }
}
