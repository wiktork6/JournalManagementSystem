package app.ui;

import app.database.databaseInterfaces.DataAccessController;
import app.database.databaseInterfaces.DataInsertController;
import app.pojo.Author;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.Submission;

public class RegisterSubmission {
    private DataInsertController dataInsertController;
    private DataAccessController dataAccessController;

    public RegisterSubmission(DataInsertController dataInsertController, DataAccessController dataAccessController) {
        this.dataInsertController = dataInsertController;
        this.dataAccessController = dataAccessController;
    }


    public void registerNewSubmission(Author author, String title, String abstractText, String draftArticle, String issn){
        dataInsertController.insertSubmission(title, abstractText, draftArticle, author.getAuthorId(), issn);
    }
}
