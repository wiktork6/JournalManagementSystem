package com.company.submission;

public class Submission {
    private Integer id;
    private String abstractText;
    private String title;
    private String draftArticle;
    private Integer authorId;

    public Submission( String abstractText, String title, String draftArticle, Integer authorId) {
        this.abstractText = abstractText;
        this.title = title;
        this.draftArticle = draftArticle;
        this.authorId = authorId;
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
}
