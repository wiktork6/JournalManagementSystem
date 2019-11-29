package app.pojo;

public class Submission {
    private Integer id;
    private String abstractText;
    private String title;
    private String draftArticle;
    private Integer authorId;
    private String issn;

    public Submission(){
    }

    public Submission(Integer id, String abstractText, String title, String draftArticle, Integer authorId, String issn) {
        this.id = id;
        this.abstractText = abstractText;
        this.title = title;
        this.draftArticle = draftArticle;
        this.authorId = authorId;
        this.issn = issn;
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

    public String getIssn(){
        return this.issn;
    }

    public void setIssn(String issn){
        this.issn = issn;
    }
}
