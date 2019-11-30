package app.services;

import app.database.dataAccessControllers.JournalDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Journal;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class JournalService extends GenericService<Journal> {
    public JournalService() {
        super(new JournalDataAccessController());
    }

    public boolean insertJournalEditor(String journalId, Integer editorId){
        return ((JournalDataAccessController)dac).insertJournalEditor(journalId, editorId);
    }

    public ArrayList<Journal> getAvailableJournals(Integer editorId){
        ArrayList<KVPair> filters = new ArrayList<>();
        filters.add(new KVPair("editor_id", editorId));
        return dac.getItemsWhere(filters);
    }

    public Journal getJournalByISSN(String issn){
        ArrayList<KVPair> filters = new ArrayList<>();
        filters.add(new KVPair("ISSN", issn));
        return dac.getItemWhere(filters);
    }
}
