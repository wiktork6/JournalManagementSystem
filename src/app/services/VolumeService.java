package app.services;

import app.database.generic.Filter;
import app.database.generic.GenericDataAccessController;
import app.pojo.Volume;

import java.util.ArrayList;

public class VolumeService extends GenericService<Volume> {
    public VolumeService(GenericDataAccessController<Volume> dac) {
        super(dac);
    }

    public ArrayList<Volume> getJournalVolumes(String journalIssn){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("ISSN", journalIssn));
        return dac.getItemsWhere(filters);
    }
}
