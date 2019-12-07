package app.pojo;

import java.io.File;

public class Article implements Identifiable {
    private Integer id;
    private String pageNumberRange;
    private String abstractText;
    private String title;
    private File fullArticle;
    private Integer mainAuthorId;
    private Integer editionId;

    public Article()
    {
    }

    public Article(Integer id, String pageNumberRange, String abstractText, String title, File fullArticle, Integer mainAuthorId, Integer editionId) {
        this.id = id;
        this.pageNumberRange = pageNumberRange;
        this.abstractText = abstractText;
        this.title = title;
        this.fullArticle = fullArticle;
        this.mainAuthorId = mainAuthorId;
        this.editionId = editionId;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPageNumberRange() {
        return pageNumberRange;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public String getTitle() {
        return title;
    }

    public File getFullArticle() {
        return fullArticle;
    }

    public Integer getMainAuthorId() {
        return mainAuthorId;
    }

    public Integer getEditionId() {
        return editionId;
    }
}
