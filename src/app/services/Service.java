package app.services;

import java.util.ArrayList;

public interface Service<Item> {
    ArrayList<Item> getItems();
    Item getItem(Object id);
    Integer addItem(Item item);
}
