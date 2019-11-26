package app.pojo;

public class Author extends User {
    private Integer authorId;

    public Author(Integer id, String title, String forname, String surname, String university, String email, Integer authorId) {
        super(id, title, forname, surname, university, email);
        this.authorId = authorId;
    }

    public Integer getAuthorId() {
        return authorId;
    }
}
