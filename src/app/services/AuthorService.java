package app.services;

import app.database.dataAccessControllers.AuthorDataAccessController;
import app.database.dataAccessControllers.generic.Filter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Author;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class AuthorService extends GenericService<Author> {
    public AuthorService() {
        super(new AuthorDataAccessController());
    }

    public Author getUserAuthor(Integer userId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("user_id", userId));
        return dac.getItemWhere(filters);
    }
}
