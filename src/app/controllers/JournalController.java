package app.controllers;

import app.database.databaseInterfaces.DataAccessController;
import app.pojo.Editor;
import app.pojo.Journal;

public class JournalController {
    private Journal journal;
    DataAccessController dataAccessController;

    public JournalController(Journal journal, DataAccessController dataAccessController) {
        this.journal = journal;
        this.dataAccessController = dataAccessController;
    }

//    public boolean changeChiefEditor(){
//
//    }
//    public boolean addNewEditor(){
//
//    }
//
//    public boolean getSubmissionsList(){
//
//    }
//
////    public boolean retire(Editor editor){
////        if(editor.getId() != journal.getChiefEditorId()){
////            dataAccessController.removeEditor();
////        }
////
////    }
//    public boolean publishArticle(){
//
//    }
//    public boolean rejectArticle(){
//
//    }
//
//    public boolean publishNextEdition() {
//
//    }
}
