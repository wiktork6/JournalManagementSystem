package app.controllers;

import app.database.dataAccessControllers.generic.DataAccessController;
import app.pojo.Editor;

public class EditorController {

    private Editor editor;
    private DataAccessController dataAccessController;

    public EditorController(Editor editor, DataAccessController dataAccessController) {
        this.editor = editor;
        this.dataAccessController = dataAccessController;

    }




//    public ArrayList<Journal> getAvailableJournals(){
//        return dataAccessController.getAvailableJournals(editor.getId());
//    }

}
