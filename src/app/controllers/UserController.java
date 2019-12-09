package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.roles.Role;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.User;
import app.services.AuthorService;
import app.services.EditorService;
import app.services.ReviewerService;
import app.services.UserService;
import com.mysql.cj.util.StringUtils;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserController extends GenericController<User> {
    private User loggedUser;

    public UserController(){
        super(new UserService());
    }

    public ActionResult<User> login(String email, String password){
        User user = ((UserService)this.service).authentecateUser(email, password);
        this.loggedUser = user;
        ActionResult<User> ar = null;
        if(user != null){
            ar = new ActionResult<>(user, true, Messages.Info.SUCCESSFUL_LOGIN);
        } else {
            ar = new ActionResult<>(null, false, Messages.Error.WRONG_CREDENTIALS);
        }
        return ar;
    }

    public ActionResult<User> register(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        if(!password.equals(repeatPassword)) {
            ActionResult<User> userActionResult = new ActionResult<>();
            userActionResult.setSuccess(false);
            userActionResult.setMessage(Messages.Error.PASSWORD_NOT_MATCH);
            password = null;
            repeatPassword = null;
            return userActionResult;
        }
        ActionResult<User> ar = this.addItem(new User(title, forname, surname, university, email, password));
        password = null;
        repeatPassword = null;
        return ar;
    }

    public ActionResult<User> updateAccount(Integer id, String title, String forname, String surname, String university,
                                            String email, String oldPassword, String newPassword, String repeatPassword)
    {
        User user = new User(id, title, forname, surname, university, email);
        if(!StringUtils.isNullOrEmpty(oldPassword) && !StringUtils.isNullOrEmpty(newPassword) && !StringUtils.isNullOrEmpty(repeatPassword)) {
            if (!newPassword.equals(repeatPassword)) {
                ActionResult<User> userActionResult = new ActionResult<>();
                userActionResult.setSuccess(false);
                userActionResult.setMessage(Messages.Error.PASSWORD_NOT_MATCH);
                oldPassword = null;
                newPassword = null;
                repeatPassword = null;
                return userActionResult;
            }
            ActionResult<User> authenticationResult = login(this.loggedUser.getEmail(), oldPassword);
            if(!authenticationResult.getSuccess()){
                oldPassword = null;
                newPassword = null;
                repeatPassword = null;
                return authenticationResult;
            }
            user.setPassword(newPassword);
        }
         ActionResult<User> result = this.updateItem(user);
        if(result.getSuccess()){
            result.getResult().setId(this.loggedUser.getId());
            this.loggedUser = result.getResult();
        }
        oldPassword = null;
        newPassword = null;
        repeatPassword = null;
        this.loggedUser.setPassword(null);
        return result;
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
    public List<Role> getAvailableRoles() {
        List<Role> roleList = new ArrayList<Role>();
        if (isAuthor(this.loggedUser)) {
            roleList.add(Controllers.AUTHOR);
        }
        if (isEditor(this.loggedUser)){
            roleList.add(Controllers.EDITOR);
        }
        if (isReviewer(this.loggedUser)){
            roleList.add(Controllers.REVIEWER);
        }
        return roleList;
    }

    public boolean isAuthor(User user){
        AuthorService authorService = new AuthorService();
        return authorService.getUserAuthor(user.getId()) != null;
    }
    public boolean isEditor(User user){
        EditorService editorService = new EditorService();
        return editorService.getUserEditor(user.getId()) != null;

    }
    public boolean isReviewer(User user){
        ReviewerService reviewerService = new ReviewerService();
        return reviewerService.getUserReviewer(user.getId()) != null;

    }

    public ActionResult<User> getUserByEmail(String email){
        Integer userId = ((UserService)this.service).getUserId(email);
        ActionResult<User> userActionResult = new ActionResult<>();
        User user = this.service.getItem(userId);
        userActionResult.setResult(user);
        if(userActionResult.getResult()!=null){
            userActionResult.setSuccess(true);
            userActionResult.setMessage(Messages.Info.COAUTHOR_ADDED);
        }else{
            userActionResult.setSuccess(false);
            userActionResult.setMessage(Messages.Error.COAUTHOR_NOT_FOUND);
        }
        return userActionResult;
    }

    public boolean isEmailTaken(String email){
        ActionResult<User> userActionResult = getUserByEmail(email);
        return !userActionResult.getSuccess();
    }


}
