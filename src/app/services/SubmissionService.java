package app.services;

import app.controllers.tools.generic.ActionResult;
import app.database.dataAccessControllers.ArticleDataAccessController;
import app.database.dataAccessControllers.SubmissionDataAccessController;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.*;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class SubmissionService extends GenericService<Submission> {
    public SubmissionService() {
        super(new SubmissionDataAccessController());
    }

    public boolean addCoAuthor(Integer submissionId, Integer authorId){
        return ((SubmissionDataAccessController) dac).insertCoAuthor(submissionId, authorId);
    }

    public ArrayList<Author> getSubmissionsCoAuthors(Integer submissionId){
        return ((SubmissionDataAccessController) dac).getSubmissionsCoAuthors(submissionId);
    }

    public ArrayList<Submission> getSubmissions(Author author){
        return ((SubmissionDataAccessController)dac).getAuthorSubmissions(author);
    }

    public ArrayList<Submission> getJournalsSubmissions(Journal journal){

        ArrayList<KVPair> filters = new ArrayList<>();
        filters.add(new KVPair("journal_id",journal.getId()));
        return dac.getItemsWhere(filters);
    }
//    public ArrayList<Submission> getJournalsSubmissionsNoConflict(Journal journal, Editor editor){
//        ArrayList<KVPair> filters = new ArrayList<>();
//        filters.add(new KVPair("journal_id",journal.getId()));
//        filters.add(new KVPair(,editor.getUser().getUniversity()));
//        return dac.
//    }

    public ArrayList<Submission> getStatusSubmissions(Journal journal, String status){
        ArrayList<KVPair> filters = new ArrayList<>();
        filters.add(new KVPair("journal_id",journal.getId()));
        filters.add(new KVPair("status", status));
        return dac.getItemsWhere(filters);
    }

    public ArrayList<Submission> getReviewerSubmissions(String university, Integer reviewerId, Integer authorId){
        return ((SubmissionDataAccessController)dac).getReviewerSubmissions(university, reviewerId, authorId);
    }

    public ArrayList<Submission> getSelectedSubmissions(Integer reviewerId){
        return ((SubmissionDataAccessController)dac).getSelectedSubmissions(reviewerId);
    }

    public Integer changeSubmissionStatus(Submission submission, String status){
        Submission updatedSubmission = submission;
        updatedSubmission.setStatus(status);
        return dac.updateItem(updatedSubmission);
    }
}
