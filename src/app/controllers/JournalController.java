package app.controllers;


import app.controllers.generic.GenericController;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Journal;
import app.services.JournalService;

public class JournalController extends GenericController<Journal> {
    public JournalController() {
        super(new JournalService());
    }

    public ActionResult<Journal> getJournal(Integer journalId){
        return this.getItem(journalId);
    }

    @Override
    protected boolean validateItem(Journal journal) {
        return true;
    }



}
