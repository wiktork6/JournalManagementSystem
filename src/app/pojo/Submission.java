package app.pojo;

import java.io.File;

public class Submission implements Identifiable {
    private Integer id;
    private String abstractText;
    private String title;
    private File draftArticle;
    private Integer authorId;
    private Integer journalId;
    private String status;
    private Integer reviewsSelected;

    public Submission(){
    }


    public Submission(String abstractText, String title, File draftArticle, Integer authorId, Integer journalId, String status, Integer reviewsSelected){
        this.abstractText = abstractText;
        this.title = title;
        this.draftArticle = draftArticle;
        this.authorId = authorId;
        this.journalId = journalId;
        this.status = status;
        this.reviewsSelected = reviewsSelected;
    }

    public Submission(Integer id, String abstractText, String title, File draftArticle, Integer authorId, Integer journalId, String status, Integer reviewsSelected) {
        this(abstractText, title, draftArticle, authorId, journalId, status, reviewsSelected);
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

    public File getDraftArticle() {
        return draftArticle;
    }

    public void setDraftArticle(File draftArticle) {
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

    @Override
    public String toString() {
        return getTitle() + " " + getStatus();
    }

    public Integer getReviewsSelected() {
        return reviewsSelected;
    }

    public void setReviewsSelected(Integer reviewsSelected) {
        this.reviewsSelected = reviewsSelected;
    }
}
