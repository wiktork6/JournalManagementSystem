package app.services;

import app.database.generic.GenericDataAccessController;

import java.util.ArrayList;

public class GenericService<Item> implements Service<Item> {

    private GenericDataAccessController<Item> dac;

    GenericService(GenericDataAccessController<Item> dac){
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
