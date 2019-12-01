package app.controllers;


import app.controllers.roles.Role;

import java.util.ArrayList;
import java.util.List;

public class ReviewerController implements Role {
    @Override
    public String getName() {
        return "Reviewer";
    }

    @Override
    public List<String> getAvailableActions() {
        List<String> listOfAvailableActions = new ArrayList<>();
        listOfAvailableActions.add("REVIEW SUBMISSIONS");
        return listOfAvailableActions;
    }

}
