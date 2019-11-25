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

    public User createNewUser(String title,){
        return new User()
    }
    public boolean acceptArticle(Submission submission){
        insertArticle();
    }
    public boolean rejecttArticle(Submission submission){
        deleteSubmission();
    }
    public boolean getSubmissionsList(){

    }
    public Editor nominateNewEditor(){

    }
    public Editor appointNewEditor(){

    }
    public Editor retire(){

    }

    public ArrayList<Journal> getAvailableJournals(){
        return dataAccessController.getAvailableJournals(editor.getId());
    }

}
