package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.roles.Role;
import app.pojo.Editor;
import app.pojo.User;
import app.services.EditorService;
import app.views.ui.RegisteredNewArticle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
    public HashMap<String, ActionListener> getAvailableActions(JFrame frame) {
        HashMap<String, ActionListener> availableActions = new HashMap<>();
        availableActions.put("VIEW AVAILABLE JOURNALS", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//                RegisteredNewArticle na = new RegisteredNewArticle();
//                na.frame.setVisible(true);
            }
        });
        return availableActions;
    }

}
