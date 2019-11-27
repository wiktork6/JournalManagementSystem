package app.controllers.register;

import app.database.databaseInterfaces.DataAccessController;

import app.pojo.Editor;
import app.pojo.Journal;

public class RegisterJournal {

    private DataAccessController dataAccessController;

    public RegisterJournal( DataAccessController dataAccessController) {

        this.dataAccessController = dataAccessController;
    }

    public Journal registerNewJournal(Editor editor, String ISSN, String title){
        Journal journal = new Journal(ISSN, title, 0, editor.getId());
        dataAccessController.insertJournal(journal);
        dataAccessController.insertJournalEditor(journal, editor);
        return journal;
    }
}
