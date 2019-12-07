package app.services;

import app.controllers.tools.generic.ActionResult;
import app.database.dataAccessControllers.SubmissionDataAccessController;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Author;
import app.pojo.Journal;
import app.pojo.Submission;
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
        ArrayList<KVPair> filters = new ArrayList<>();
        filters.add(new KVPair("author_id",author.getId()));
        return dac.getItemsWhere(filters);
    }

    public ArrayList<Submission> getJournalsSubmissions(Journal journal){

        ArrayList<KVPair> filters = new ArrayList<>();
        filters.add(new KVPair("journal_id",journal.getId()));
        return dac.getItemsWhere(filters);
    }

    public ArrayList<Submission> getStatusSubmissions(Journal journal, String status){
        ArrayList<KVPair> filters = new ArrayList<>();
        filters.add(new KVPair("journal_id",journal.getId()));
        filters.add(new KVPair("status", status));
        return dac.getItemsWhere(filters);
    }
}
