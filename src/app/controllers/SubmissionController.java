package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.ActionSuccess;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Author;
import app.pojo.Journal;
import app.pojo.Submission;
import app.services.JournalService;
import app.services.SubmissionService;

import java.util.ArrayList;

public class SubmissionController extends GenericController<Submission> {

    public SubmissionController() {
        super(new SubmissionService());
    }

    public ActionSuccess addCoAuthor(Integer submissionId, Integer authorId){
        if(((SubmissionService)service).addCoAuthor(submissionId, authorId)){
            return new ActionSuccess(true, Messages.Info.COAUTHOR_ADDED);
        }
        return new ActionSuccess(false, Messages.Error.COAUTHOR_NOT_ADDED);
    }

    public ActionResult<ArrayList<Author>> getCoAuthors(Integer submissionId){
        return new ActionResult<>(
                ((SubmissionService)service).getSubmissionsCoAuthors(submissionId), true, "");
    }

    public ActionResult<Submission> addSubmission(String abstractText, String title, String draftArticle, Integer authorId, String issn, String status){
        Integer journalId = new JournalService().getJournalByISSN(issn).getId();
        return this.addItem(new Submission(abstractText, title, draftArticle, authorId, journalId, status));
    }

    @Override
    protected boolean validateItem(Submission submission) {
        return true;
    }
//
//    public ActionResult<ArrayList<Submission>> getSubmissions(Author author){
//        ArrayList<Submission> listOfSubmissions = new ArrayList<>();
//
//    }
    public ActionResult<ArrayList<Submission>> getJournalsSubmissions(Journal journal){
        ActionResult<ArrayList<Submission>> result = new ActionResult<>();
        result.setResult(((SubmissionService)service).getJournalsSubmissions(journal));

        return result;
    }

    public ActionResult<ArrayList<Submission>> getSubmissionWithStatus(Journal journal, String status){
        ActionResult<ArrayList<Submission>> actionResult = new ActionResult<>();
        ArrayList<Submission> submissions = ((SubmissionService)service).getStatusSubmissions(journal, status);
        actionResult.setResult(submissions);
        if(submissions==null){
            actionResult.setSuccess(false);
            actionResult.setMessage(Messages.Error.SUBMISSION_NOT_FOUND);
        } else{
            actionResult.setSuccess(true);
        }
        return actionResult;
    }
}
