package app.services;

import app.database.SubmissionDataAccessController;
import app.database.generic.GenericDataAccessController;
import app.pojo.Author;
import app.pojo.Submission;

import java.util.ArrayList;

public class SubmissionService extends GenericService<Submission> {
    public SubmissionService(GenericDataAccessController<Submission> dac) {
        super(dac);
    }

    public boolean addCoAuthor(Integer submissionId, Integer authorId){
        return ((SubmissionDataAccessController) dac).insertCoAuthor(submissionId, authorId);
    }

    public ArrayList<Author> getSubmissionsCoAuthors(Integer submissionId){
        return ((SubmissionDataAccessController) dac).getSubmissionsCoAuthors(submissionId);
    }
}
