package app.services;

import app.database.dataAccessControllers.VolumeDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Volume;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class VolumeService extends GenericService<Volume> {
    public VolumeService() {
        super(new VolumeDataAccessController());
    }

    public ArrayList<Volume> getJournalVolumes(String journalId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("journal_id", journalId));
        return dac.getItemsWhere(filters);
    }
}
