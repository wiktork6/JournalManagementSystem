package app.controllers;

import app.controllers.generic.Controller;
import app.controllers.generic.GenericController;
import app.controllers.roles.Role;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Author;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.User;
import app.services.AuthorService;
import app.services.EditorService;
import app.views.ui.AvailableJournals;
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
                frame.dispose();
                AvailableJournals avail = new AvailableJournals();
                avail.frame.setVisible(true);
            }
        });
        return availableActions;
    }

    public Editor getEditor(User user) {
        return ((EditorService) service).getUserEditor(user.getId());
    }


    public ActionResult<ArrayList<Editor>> getJournalsEditors(Journal journal){
        ActionResult<ArrayList<Editor>> editorActionResult = new ActionResult<>();
        ArrayList<Editor> listOfEditors = ((EditorService) service).getJournalsEditors(journal);
        editorActionResult.setResult(listOfEditors);
        if(listOfEditors == null){
            editorActionResult.setSuccess(false);
        }else{
            editorActionResult.setSuccess(true);
        }
        return editorActionResult;

    }



    public ActionResult<Boolean> retire(Editor editor, Journal journal){
        ActionResult<Boolean> actionResult = new ActionResult<>();
        if(getJournalsEditors(journal).getResult().size()==1){
            actionResult.setMessage(Messages.Error.CANT_RETIRE);
            actionResult.setSuccess(false);
            actionResult.setResult(false);
            return actionResult;
        }
        if(journal.getChiefEditorId()!=editor.getId()){
            Controllers.JOURNAL.retireEditor(editor,journal);
        }else{
            Controllers.JOURNAL.retireEditor(editor,journal);
            Editor newChiefEditor = getJournalsEditors(journal).getResult().get(0);
            Controllers.JOURNAL.changeChiefEditor(newChiefEditor, journal);
        }
        if(Controllers.JOURNAL.getEditorsJournals(editor).getSuccess()){
            this.service.removeItem(editor.getId());
            if(!(Controllers.USER.isAuthor(Controllers.USER.getLoggedUser()) ||
                    Controllers.USER.isReviewer(Controllers.USER.getLoggedUser()))){
                Controllers.USER.removeUser(Controllers.USER.getLoggedUser().getId());
            }
        }
        actionResult.setSuccess(true);
        actionResult.setResult(true);
        return actionResult;
    }
}
