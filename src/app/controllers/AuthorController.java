package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.roles.Role;
import app.pojo.Author;
import app.services.AuthorService;

import java.util.ArrayList;
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
    public List<String> getAvailableActions() {
        List<String> listOfAvailableActions = new ArrayList<>();
        listOfAvailableActions.add("CREATE NEW SUBMISSION");
        listOfAvailableActions.add("CHECK STATUS OF EXISTING SUBMISSIONS");
        listOfAvailableActions.add("SEE MY ARTICLES");
        listOfAvailableActions.add("CREATE NEW JOURNAL");
        return listOfAvailableActions;
    }


}
