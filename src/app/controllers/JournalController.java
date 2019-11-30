package app.controllers;


import app.controllers.generic.GenericController;
import app.pojo.Journal;
import app.services.JournalService;

public class JournalController extends GenericController<Journal> {
    public JournalController() {
        super(new JournalService());
    }

    @Override
    protected boolean validateItem(Journal journal) {
        return true;
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
