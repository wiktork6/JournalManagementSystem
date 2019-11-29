package app.services.generic;

import app.database.dataAccessControllers.generic.GenericDataAccessController;

import java.util.ArrayList;

public class GenericService<Item> implements Service<Item> {

    protected GenericDataAccessController<Item> dac;

    public GenericService(GenericDataAccessController<Item> dac){
        this.dac = dac;
    }

    @Override
    public ArrayList<Item> getItems() {
        return dac.getItems();
    }

    @Override
    public Item getItem(Object id) {
        return dac.getItem(id);
    }

    @Override
    public Integer addItem(Item item) {
        return dac.addItem(item);
    }
}
