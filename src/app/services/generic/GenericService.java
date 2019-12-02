package app.services.generic;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Identifiable;

import java.util.ArrayList;

public class GenericService<Item extends Identifiable> implements Service<Item> {

    protected GenericDataAccessController<Item> dac;

    public GenericService(GenericDataAccessController<Item> dac){
        this.dac = dac;
    }

    @Override
    public ArrayList<Item> getItems() {
        return dac.getItems();
    }

    @Override
    public Item getItem(Integer id) {
        return dac.getItem(id);
    }

    @Override
    public Integer addItem(Item item) {
        return dac.addItem(item);
    }

    @Override
    public Integer updateItem(Item item){
        return dac.updateItem(item);
    }

    @Override
    public Integer removeItem(Integer id) { return dac.removeItem(id); }

}
