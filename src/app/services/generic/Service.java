package app.services.generic;

import app.pojo.Identifiable;

import java.util.ArrayList;

public interface Service<Item extends Identifiable> {
    ArrayList<Item> getItems();
    Item getItem(Integer id);
    Integer addItem(Item item);
    Integer updateItem(Item item);
}
