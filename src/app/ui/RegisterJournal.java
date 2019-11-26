package app.ui;

import app.database.databaseInterfaces.DataAccessController;
import app.database.databaseInterfaces.DataInsertController;
import app.pojo.Editor;
import app.pojo.Journal;

public class RegisterJournal {
    private DataInsertController dataInsertController;
    private DataAccessController dataAccessController;

    public RegisterJournal(DataInsertController dataInsertController, DataAccessController dataAccessController) {
        this.dataInsertController = dataInsertController;
        this.dataAccessController = dataAccessController;
    }

    public Journal registerNewJournal(Editor editor, String ISSN, String title){
        Journal journal = new Journal(ISSN, title, 0, editor.getId());
        dataInsertController.insertJournal(journal);
        dataInsertController.insertJournalEditor(journal, editor);
        return journal;
    }
}
