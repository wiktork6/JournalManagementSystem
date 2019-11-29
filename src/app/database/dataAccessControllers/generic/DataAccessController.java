package app.database.dataAccessControllers.generic;

import java.util.ArrayList;

public interface DataAccessController<Item> {
    ArrayList<Item> getItemsWhere(ArrayList<Filter> filters);
    ArrayList<Item> getItems();
    Item getItem(Object id);
    Item getItemWhere(ArrayList<Filter> filters);
    Integer addItem(Item item);

    //ArrayList<User> getUsers();
    //Integer getUserId(String email);
    //ArrayList<Journal> getJournals();
    //ArrayList<Volume> getVolumes();
    //ArrayList<Volume> getVolumes(String issnNumber);
    //ArrayList<Edition> getEditions(Integer volumeId);
    //ArrayList<Edition> getEditions();
    //ArrayList<Article> getArticles(Integer editionId);
    //ArrayList<Article> getArticles();
    //Article showArticle(Integer articleId);
    //ArrayList<Review> getReviews(Integer submissionId);
    //ArrayList<Question> getQuestions(Integer reviewId);

    //User getUser(Integer id);
    //Integer getAuthor(Integer userId);
    //Integer getEditor(Integer userId);

    //Integer insertUser(String title, String forname, String surname, String university, String email, String password);
    //Integer insertAuthor(Integer userId);
    //Integer insertEditor(Integer userId);
    //boolean insertJournal(Journal journal);

    //Integer insertSubmission(String title, String abstractText, String draftArticle, Integer authorId, String issn);

    // ADDITIONAL FUNCTIONS
    //boolean insertCoAuthor(Integer submissionId, Integer authorId);
    //ArrayList<String> getAvailableJournals(Integer editorId);
    //boolean insertJournalEditor(Journal journal, Editor editor);
    //ArrayList<Author> getSubmissionsCoAuthors(Integer submissionId);
}


