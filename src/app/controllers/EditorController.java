package app.controllers;

import app.controllers.generic.GenericController;
import app.pojo.Editor;
import app.services.EditorService;

public class EditorController extends GenericController<Editor> {

    public EditorController() {
        super(new EditorService());
    }

    @Override
    protected boolean validateItem(Editor editor) {
        return false;
    }


//    public ArrayList<Journal> getAvailableJournals(){
//        return dataAccessController.getAvailableJournals(editor.getId());
//    }

}
