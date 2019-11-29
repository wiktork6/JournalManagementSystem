package app.controllers.register;

import app.database.SubmissionDataAccessController;
import app.database.generic.DataAccessController;

import app.pojo.Author;
import app.pojo.Submission;

public class RegisterSubmission {

    private SubmissionDataAccessController dataAccessController;

    public RegisterSubmission(SubmissionDataAccessController dataAccessController) {

        this.dataAccessController = dataAccessController;
    }


    public Integer registerNewSubmission(Author author, String title, String abstractText, String draftArticle, String issn){
        Integer submissionId = dataAccessController.addItem(new Submission(-1, title, abstractText, draftArticle, author.getAuthorId(), issn));
        dataAccessController.insertCoAuthor(author.getAuthorId(), submissionId);
        return submissionId;
    }


}
