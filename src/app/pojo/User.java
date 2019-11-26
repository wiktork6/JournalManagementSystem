package app.pojo;


public class User {
    private Integer id;
    private String title;
    private String forname;
    private String surname;
    private String university;
    private String email;

    public User(Integer id, String title, String forname, String surname, String university, String email) {
        this.id = id;
        this.title = title;
        this.forname = forname;
        this.surname = surname;
        this.university = university;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public String getForname() {
        return forname;
    }

    public String getSurname() {
        return surname;
    }

    public String getUniversity() {
        return university;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }
}
