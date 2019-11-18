package com.company.users;


public class User {
    private String title;
    private String forname;
    private String surname;
    private String university;
    private String email;
    private String password;

    public User(String title, String forname, String surname, String university, String email, String password) {
        this.title = title;
        this.forname = forname;
        this.surname = surname;
        this.university = university;
        this.email = email;
        this.password = password;

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


    public String getPassword() {
        return password;
    }
}
