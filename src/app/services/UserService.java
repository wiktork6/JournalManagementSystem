package app.services;

import app.database.UserDataAccessController;
import app.database.generic.Filter;
import app.database.generic.GenericDataAccessController;
import app.pojo.User;

import java.util.ArrayList;

public class UserService extends GenericService<User> {
    public UserService(GenericDataAccessController<User> dac) {
        super(dac);
    }

    public Integer getUserId(String email){
        return ((UserDataAccessController) dac).getUserId(email);
    }

    public User authentecateUser(String email, String password){
        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(new Filter("email", email));
        filters.add(new Filter("password", password));
        return dac.getItemWhere(filters);
    }
}
