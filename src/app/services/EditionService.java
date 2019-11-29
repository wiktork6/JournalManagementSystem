package app.services;

import app.database.dataAccessControllers.generic.Filter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Edition;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class EditionService extends GenericService<Edition> {
    public EditionService(GenericDataAccessController<Edition> dac) {
        super(dac);
    }

    public ArrayList<Edition> getVolumeEditions(int volumeId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("volume_id", volumeId));
        return dac.getItemsWhere(filters);
    }
}
