package app.services;

import app.database.dataAccessControllers.UserDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.User;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class UserService extends GenericService<User> {
    public UserService() {
        super(new UserDataAccessController());
    }

    public Integer getUserId(String email){
        return ((UserDataAccessController) dac).getUserId(email);
    }

    public User authentecateUser(String email, String password){
        ArrayList<KVPair> filters = new ArrayList<>();
        filters.add(new KVPair("email", email));
        filters.add(new KVPair("password", password));
        return dac.getItemWhere(filters);
    }
}
