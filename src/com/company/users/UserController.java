package com.company.users;

import com.company.database.DataAccessController;

public class UserController  {
    private User user;

    public UserController(User user){
        this.user = user;
    }

    private boolean changePassword(String password){
        return false;
    }
    private boolean insertUser(User user){
        return DataAccessController.insertUser(user);
    }

    public boolean login(String email, String password){
        return true;
    }
}
