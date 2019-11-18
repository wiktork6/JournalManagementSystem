package com.company.users.author;

import com.company.users.User;

public class Author extends User {
    private Integer userId;

    public Author(String title, String forname, String surname, String university, String email, String password, Integer userId) {
        super(title, forname, surname, university, email, password);
        this.userId = userId;
    }
}
