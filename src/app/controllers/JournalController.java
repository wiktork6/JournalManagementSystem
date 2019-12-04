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
        return ((((JournalService)this.service).getJournalByISSN(journal.getIssn()) == null) && (((JournalService)this.service).getJournalByName(journal.getName())==null));

    }

    public ActionResult<Journal> register(Journal journal){

        return this.addItem(journal);
    }

    public ArrayList<Journal> getAllJournals(){
        return service.getItems();
    }

    public boolean addNewEditorToJournal(Integer journalId, Integer editorId){
        return ((JournalService)this.service).insertJournalEditor(journalId,editorId);
    }

    public boolean isExist(String issn, String name){
        return ((((JournalService)this.service).getJournalByISSN(issn) == null) && (((JournalService)this.service).getJournalByName(name)==null));
    }


}
