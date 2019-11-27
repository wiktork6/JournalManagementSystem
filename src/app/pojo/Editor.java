package app.pojo;

public class Editor extends User {
    private Integer editorId;

    public Editor(Integer id, String title, String forname, String surname, String university, String email, Integer editorId) {
        super(id, title, forname, surname, university, email);
        this.editorId = editorId;
    }
}