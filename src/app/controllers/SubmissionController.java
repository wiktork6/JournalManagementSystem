package app.controllers;

import app.controllers.generic.GenericController;
import app.pojo.Author;
import app.pojo.Submission;
import app.services.JournalService;
import app.services.SubmissionService;

import java.util.ArrayList;

public class SubmissionController extends GenericController<Submission> {

    public SubmissionController() {
        super(new SubmissionService());
    }

    public boolean addCoAuthor(Integer submissionId, Integer authorId){
        return ((SubmissionService)service).addCoAuthor(submissionId, authorId);
    }

    public ArrayList<Author> getCoAuthors(Integer submissionId){
        return ((SubmissionService)service).getSubmissionsCoAuthors(submissionId);
    }

    public Submission addSubmission(String abstractText, String title, String draftArticle, Integer authorId, String issn, String status){
//        Submission submission = new Submission(abstractText, title, draftArticle, authorId, status);
        Integer journalId = new JournalService().getJournalByISSN(issn).getId();
        return this.addItem(new Submission(abstractText, title, draftArticle, authorId, journalId, status));
    }

    @Override
    protected boolean validateItem(Submission submission) {
        return true;
    }




}
