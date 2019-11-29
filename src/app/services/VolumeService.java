package app.services;

import app.database.dataAccessControllers.VolumeDataAccessController;
import app.database.dataAccessControllers.generic.Filter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Volume;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class VolumeService extends GenericService<Volume> {
    public VolumeService() {
        super(new VolumeDataAccessController());
    }

    public ArrayList<Volume> getJournalVolumes(String journalIssn){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("ISSN", journalIssn));
        return dac.getItemsWhere(filters);
    }
}
