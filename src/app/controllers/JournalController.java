package app.controllers;


import app.controllers.generic.GenericController;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Journal;
import app.services.JournalService;

import java.util.ArrayList;

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

    public Journal register(Journal journal){
        return this.addItem(journal);
    }

    public ArrayList<Journal> getAllJournals(){
        return service.getItems();
    }



}
