package app.pojo;

public class Author extends User {
    private Integer authorId;

    public Author(Integer id, String title, String forname, String surname, String university, String email, String password, Integer authorId) {
        super(id, title, forname, surname, university, email, password);
        this.authorId = authorId;
    }

    public Integer getAuthorId() {
        return authorId;
    }
}
