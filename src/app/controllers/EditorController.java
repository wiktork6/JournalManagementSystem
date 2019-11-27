package app.controllers;

import app.database.databaseInterfaces.DataAccessController;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.Submission;
import app.pojo.User;

import java.util.ArrayList;

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
