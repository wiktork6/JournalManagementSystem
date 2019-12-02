package app.pojo;

public class Submission implements Identifiable {
    private Integer id;
    private String abstractText;
    private String title;
    private String draftArticle;
    private Integer authorId;
    private Integer journalId;
    private String status;

    public Submission(){
    }


    public Submission(String abstractText, String title, String draftArticle, Integer authorId, Integer journalId, String status){
        this.abstractText = abstractText;
        this.title = title;
        this.draftArticle = draftArticle;
        this.authorId = authorId;
        this.journalId = journalId;
        this.status = status;
    }

    public Submission(Integer id, String abstractText, String title, String draftArticle, Integer authorId, Integer journalId, String status) {
        this(abstractText, title, draftArticle, authorId, journalId, status);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDraftArticle() {
        return draftArticle;
    }

    public void setDraftArticle(String draftArticle) {
        this.draftArticle = draftArticle;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getJournalId(){
        return this.journalId;
    }

    public void setJournalId(Integer journalId){
        this.journalId = journalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
