package app.controllers.register;

import app.database.JournalDataAccessController;
import app.database.generic.DataAccessController;

import app.pojo.Editor;
import app.pojo.Journal;

public class RegisterJournal {

    private JournalDataAccessController dataAccessController;

    public RegisterJournal( JournalDataAccessController dataAccessController) {

        this.dataAccessController = dataAccessController;
    }

    public Journal registerNewJournal(Editor editor, String ISSN, String title){
        Journal journal = new Journal(ISSN, title, 0, editor.getId());
        dataAccessController.addItem(journal);
        dataAccessController.insertJournalEditor(journal, editor);
        return journal;
    }
}
