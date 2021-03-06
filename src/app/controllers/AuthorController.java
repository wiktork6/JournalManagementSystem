package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.roles.Role;
import app.controllers.tools.ActionSuccess;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Author;
import app.pojo.Editor;
import app.pojo.User;
import app.services.AuthorService;
import app.views.ui.ExistingSubmissions;
import app.views.ui.RegisteredNewArticle;
import app.views.ui.RegisteredNewJournal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AuthorController extends GenericController<Author> implements Role {

    public AuthorController() {
        super(new AuthorService());
    }

    @Override
    protected boolean validateItem(Author author) {
        return true;
    }

    @Override
    public String getName() {
        return "Author";
    }

    @Override
    public HashMap<String, ActionListener> getAvailableActions(JFrame frame) {
        HashMap<String, ActionListener> availableActions = new HashMap<>();

        availableActions.put("CHECK STATUS OF EXISTING SUBMISSIONS", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ExistingSubmissions sub = new ExistingSubmissions();
                sub.frame.setVisible(true);
            }
        });
        return availableActions;
    }

    public Author register(User user){
        Author author = new Author();
        author.setUser(user);
        Integer authorId = service.addItem(author);
        author.setId(authorId);
        return author;
    }

    public ArrayList<Author> getAllAuthors(){
        return service.getItems();
    }

    public Author getAuthor(User user){
        return ((AuthorService)service).getUserAuthor(user.getId());
    }

    public ActionSuccess removeAuthor(Integer authorId){
        return super.removeItem(authorId);
    }
    public boolean insertCoAuthor(Integer articleId, Integer authorId){
        return ((AuthorService)service).insertCoAuthor(articleId,authorId);
    }

}
