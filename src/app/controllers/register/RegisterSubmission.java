package app.controllers.register;

import app.database.databaseInterfaces.DataAccessController;

import app.pojo.Author;
import app.pojo.Editor;
import app.pojo.Journal;
import app.pojo.Submission;

public class RegisterSubmission {

    private DataAccessController dataAccessController;

    public RegisterSubmission(DataAccessController dataAccessController) {

        this.dataAccessController = dataAccessController;
    }


    public Integer registerNewSubmission(Author author, String title, String abstractText, String draftArticle, String issn){
        Integer submissionId = dataAccessController.insertSubmission(title, abstractText, draftArticle, author.getAuthorId(), issn);
        dataAccessController.insertCoAuthor(author.getAuthorId(), submissionId);
        return submissionId;
    }


}
