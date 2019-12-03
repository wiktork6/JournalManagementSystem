package app.database.dataAccessControllers.generic;

import app.pojo.Identifiable;

import java.util.ArrayList;

public interface DataAccessController<Item extends Identifiable> {
    ArrayList<Item> getItemsWhere(ArrayList<KVPair> filters);
    ArrayList<Item> getItems();
    Item getItem(Integer id);
    Item getItemWhere(ArrayList<KVPair> filters);
    Integer addItem(Item item);
    Integer updateItem(Item item);
    Integer removeItem(Integer id);

    // ADDITIONAL FUNCTIONS
    //boolean insertCoAuthor(Integer submissionId, Integer authorId);
    //ArrayList<String> getAvailableJournals(Integer editorId);
    //boolean insertJournalEditor(Journal journal, Editor editor);
    //ArrayList<Author> getSubmissionsCoAuthors(Integer submissionId);
}


