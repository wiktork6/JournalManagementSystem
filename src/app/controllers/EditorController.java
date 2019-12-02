package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.roles.Role;
import app.pojo.Editor;
import app.pojo.User;
import app.services.EditorService;

import java.util.ArrayList;
import java.util.List;

public class EditorController extends GenericController<Editor> implements Role {

    public EditorController() {
        super(new EditorService());
    }
    public Editor register(User user){
        Editor editor = new Editor();
        editor.setUser(user);
        Integer editorId = service.addItem(editor);
        editor.setId(editorId);
        return editor;
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
