package app.services;

import app.database.JournalDataAccessController;
import app.database.generic.Filter;
import app.database.generic.GenericDataAccessController;
import app.pojo.Journal;

import java.util.ArrayList;

public class JournalService extends GenericService<Journal> {
    JournalService(GenericDataAccessController<Journal> dac) {
        super(dac);
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
