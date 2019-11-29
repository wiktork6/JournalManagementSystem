package app.pojo;


public class User {
    private Integer id;
    private String title;
    private String forname;
    private String surname;
    private String university;
    private String email;
    private String password; // Used only when creating a user

    public User(){
    }

    public User(Integer id){
        this.id = id;
    }

    public User(Integer id, String title, String forname, String surname, String university, String email, String password) {
        this.id = id;
        this.title = title;
        this.forname = forname;
        this.surname = surname;
        this.university = university;
        this.email = email;
        this.password = password;
    }

    public User(Integer id, String title, String forname, String surname, String university, String email) {
        this(id, title, forname, surname, university, email, null);
    }

    public User(String title, String forname, String surname, String university, String email, String password) {
        this(-1, title, forname, surname, university, email, password);
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

    public String getPassword() { return password; }
}
