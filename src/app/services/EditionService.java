package app.services;

import app.database.dataAccessControllers.EditionDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Edition;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class EditionService extends GenericService<Edition> {
    public EditionService() {
        super(new EditionDataAccessController());
    }

    public ArrayList<Edition> getVolumeEditions(int volumeId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("volume_id", volumeId));
        return dac.getItemsWhere(filters);
    }
}
