package app.services;

import app.database.generic.Filter;
import app.database.generic.GenericDataAccessController;
import app.pojo.Author;
import app.pojo.Editor;

import java.util.ArrayList;

public class EditorService extends GenericService<Editor> {
    public EditorService(GenericDataAccessController<Editor> dac) {
        super(dac);
    }

    public Editor getUserEditor(Integer userId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("user_id", userId));
        return dac.getItemWhere(filters);
    }
}
