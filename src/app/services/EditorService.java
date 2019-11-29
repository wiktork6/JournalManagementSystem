package app.services;

import app.database.dataAccessControllers.EditorDataAccessController;
import app.database.dataAccessControllers.generic.Filter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Editor;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class EditorService extends GenericService<Editor> {
    public EditorService() {
        super(new EditorDataAccessController());
    }

    public Editor getUserEditor(Integer userId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("user_id", userId));
        return dac.getItemWhere(filters);
    }
}
