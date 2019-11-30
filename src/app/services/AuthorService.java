package app.services;

import app.database.dataAccessControllers.AuthorDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Author;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class AuthorService extends GenericService<Author> {
    public AuthorService() {
        super(new AuthorDataAccessController());
    }

    public Author getUserAuthor(Integer userId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("user_id", userId));
        return dac.getItemWhere(filters);
    }
}
