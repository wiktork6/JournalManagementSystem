package app.services;

import app.database.dataAccessControllers.SubmissionDataAccessController;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Author;
import app.pojo.Submission;
import app.services.generic.GenericService;

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
