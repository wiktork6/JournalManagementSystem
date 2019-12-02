package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.roles.Role;
import app.pojo.Editor;
import app.services.EditorService;

import java.util.ArrayList;
import java.util.List;

public class EditorController extends GenericController<Editor> implements Role {

    public EditorController() {
        super(new EditorService());
    }

    @Override
    protected boolean validateItem(Editor editor) {
        return false;
    }

    @Override
    public String getName() {
        return "Editor";
    }

    @Override
    public List<String> getAvailableActions() {
        List<String> listOfAvailableActions = new ArrayList<>();
        listOfAvailableActions.add("VIEW AVAILABLE JOURNALS");
        return listOfAvailableActions;
    }

}
