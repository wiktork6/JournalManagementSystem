package app.controllers.generic;

import app.pojo.Article;
import app.pojo.Identifiable;
import app.pojo.User;
import app.services.generic.GenericService;

import java.util.ArrayList;

public abstract class GenericController<Item extends Identifiable> implements Controller<Item> {
    protected GenericService<Item> service;

    public GenericController(GenericService<Item> service){
        this.service = service;
    }

    protected Item addItem(Item item) {
        if(!validateItem(item)){
            return null;
        }
        Integer itemId = this.service.addItem(item);
        if(itemId != null && itemId > 0){
            item.setId(itemId);
            return item;
        }
        return null;
    }

    protected Item updateItem(Item item) {
        validateItem(item);

        Integer updated = this.service.updateItem(item);
        if(updated != null && updated > 0){
            return item;
        }
        return null;
    }

    protected ArrayList<Item> getItems(){
        return service.getItems();
    }
    protected Item getItem(Integer id) { return service.getItem(id); }

    protected abstract boolean validateItem(Item item);

    protected Integer removeItem(Integer id){ return service.removeItem(id); }
}
