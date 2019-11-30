package app.services;

import app.database.dataAccessControllers.EditorDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Editor;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class EditorService extends GenericService<Editor> {
    public EditorService() {
        super(new EditorDataAccessController());
    }

    public Editor getUserEditor(Integer userId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("user_id", userId));
        return dac.getItemWhere(filters);
    }
}
