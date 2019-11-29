package app.services;

import app.database.dataAccessControllers.JournalDataAccessController;
import app.database.dataAccessControllers.generic.Filter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Journal;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class JournalService extends GenericService<Journal> {
    public JournalService() {
        super(new JournalDataAccessController());
    }

    public boolean insertJournalEditor(String journalIssn, Integer editorId){
        return ((JournalDataAccessController)dac).insertJournalEditor(journalIssn, editorId);
    }

    public ArrayList<Journal> getAvailableJournals(Integer editorId){
        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(new Filter("editor_id", editorId));
        return dac.getItemsWhere(filters);
    }
}
