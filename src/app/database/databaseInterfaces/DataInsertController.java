package app.database.databaseInterfaces;

import app.pojo.Editor;
import app.pojo.Journal;

public interface DataInsertController {
    boolean insertUser(String title, String forname, String surname, String university, String email, String password);
    boolean insertAuthor(Integer userId);
    boolean insertEditor(Integer userId);
    boolean insertJournal(Journal journal);
    boolean insertJournalEditor(Journal journal, Editor editor);
    boolean insertSubmission(String title, String abstractText, String draftArticle, Integer authorId, String issn);
}
