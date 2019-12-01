package app.controllers;


import app.controllers.generic.GenericController;
import app.pojo.Journal;
import app.services.JournalService;

public class JournalController extends GenericController<Journal> {
    public JournalController() {
        super(new JournalService());
    }

    @Override
    protected boolean validateItem(Journal journal) {
        return true;
    }



}
