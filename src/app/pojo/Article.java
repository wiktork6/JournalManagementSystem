package app.pojo;

public class Article {
    private Integer id;
    private String pageNumberRange;
    private String abstractText;
    private String title;
    private String fullArticle;
    private Integer mainAuthorId;
    private Integer editionId;

    public Article(Integer id, String pageNumberRange, String abstractText, String title, String fullArticle, Integer mainAuthorId, Integer editionId) {
        this.id = id;
        this.pageNumberRange = pageNumberRange;
        this.abstractText = abstractText;
        this.title = title;
        this.fullArticle = fullArticle;
        this.mainAuthorId = mainAuthorId;
        this.editionId = editionId;
    }


}
