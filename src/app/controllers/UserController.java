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

import java.util.ArrayList;
import java.util.List;


public class UserController extends GenericController<User> {
    private User loggedUser;

    public UserController(){
        super(new UserService());
    }

    public ActionResult<User> login(String email, String password){
        User user = ((UserService)this.service).authentecateUser(email, password);
        this.loggedUser = user;

        if(user != null){
            return new ActionResult<>(user, true, Messages.Info.SUCCESSFUL_LOGIN);
        }
        return new ActionResult<>(null, false, Messages.Error.WRONG_CREDENTIALS);
    }

    public ActionResult<User> register(String title, String forname, String surname, String university, String email, String password, String repeatPassword){
        if(!password.equals(repeatPassword)) {
            ActionResult<User> userActionResult = new ActionResult<>();
            userActionResult.setSuccess(false);
            userActionResult.setMessage(Messages.Error.PASSWORD_NOT_MATCH);
            return userActionResult;
        }
        return this.addItem(new User(title, forname, surname, university, email, password));
    }

    public ActionResult<User> updateAccount(Integer id, String title, String forname, String surname, String university, String email)
    {
        ActionResult<User> result = this.updateItem(new User(id, title, forname, surname, university, email));
        if(result.getSuccess()){
            result.getResult().setId(this.loggedUser.getId());
            this.loggedUser = result.getResult();
        }
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

    private boolean isAuthor(User user){
        AuthorService authorService = new AuthorService();
        return authorService.getUserAuthor(user.getId()) !=null;
    }
    private boolean isEditor(User user){
        EditorService editorService = new EditorService();
        return editorService.getUserEditor(user.getId()) !=null;

    }
    private boolean isReviewer(User user){
        ReviewerService reviewerService = new ReviewerService();
        return reviewerService.getUserReviewer(user.getId()) !=null;

    }
}
