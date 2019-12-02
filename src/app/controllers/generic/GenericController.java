package app.controllers.generic;

import app.controllers.tools.ActionSuccess;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Identifiable;
import app.services.generic.GenericService;

import java.util.ArrayList;

public abstract class GenericController<Item extends Identifiable> implements Controller<Item> {
    protected GenericService<Item> service;

    public GenericController(GenericService<Item> service){
        this.service = service;
    }

    protected ActionResult<Item> addItem(Item item) {
        if(!validateItem(item)){
            return new ActionResult<>(null, false, Messages.Error.ITEM_NOT_VALID);
        }
        Integer itemId = this.service.addItem(item);
        if(itemId != null && itemId > 0){
            item.setId(itemId);
            ActionResult<Item> result = new ActionResult<>(item, true, Messages.Info.ITEM_ADDED_SUCCESSFULLY);
            return result;
        }
        return new ActionResult<>(null, false, Messages.Error.ITEM_NOT_ADDED);
    }

    protected ActionResult<Item> updateItem(Item item) {
        validateItem(item);

        Integer updated = this.service.updateItem(item);
        if(updated != null && updated > 0){
            return new ActionResult<>(item, true, Messages.Info.ITEM_UPDATED_SUCCESSFULLY);
        }
        return new ActionResult<>(null, false, Messages.Error.ITEM_NOT_UPDATED);
    }

    protected ActionResult<ArrayList<Item>> getItems(){
        return new ActionResult<>(service.getItems(), true, "");
    }
    protected ActionResult<Item> getItem(Integer id) {
        Item item = service.getItem(id);
        if(item != null){
            return new ActionResult<>(item, true, Messages.Info.ITEM_FOUND);
        }
        return new ActionResult<>(null, false, Messages.Error.ITEM_NOT_FOUND);
    }

    protected abstract boolean validateItem(Item item);

    protected ActionSuccess removeItem(Integer id){
        Integer deleted = service.removeItem(id);
        if(deleted == 1){
            return new ActionSuccess(true, Messages.Info.ITEM_DELETED);
        }
        return new ActionSuccess(false, Messages.Error.ITEM_NOT_DELETED);
    }
}
