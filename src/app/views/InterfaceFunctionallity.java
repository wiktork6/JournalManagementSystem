package app.views;

import app.pojo.User;
import app.services.UserService;
import app.views.ui.UserWelcomePage;

import javax.swing.*;

public class InterfaceFunctionallity {

    public InterfaceFunctionallity() {
    }

    public void login(String email, String password, JLabel error, JFrame frame){
        UserService userService = new UserService();
        User user = userService.authentecateUser(email,password);
        if(user!= null){
            frame.dispose();
            UserWelcomePage usrwlcm = new UserWelcomePage();
            usrwlcm.frame.setVisible(true);
        }else{
            error.setText("Invalid username or password");
        }
    }
}
