package app.services;

import app.database.generic.Filter;
import app.database.generic.GenericDataAccessController;
import app.pojo.Author;

import java.util.ArrayList;

public class AuthorService extends GenericService<Author> {
    public AuthorService(GenericDataAccessController<Author> dac) {
        super(dac);
    }

    public Author getUserAuthor(Integer userId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("user_id", userId));
        return dac.getItemWhere(filters);
    }
}
