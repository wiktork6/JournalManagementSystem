package com.company.users.author;

import com.company.users.User;

public class Author extends User {
    private Integer authorId;

    public Author(String title, String forname, String surname, String university, String email, String password, Integer authorId) {
        super(title, forname, surname, university, email, password);
        this.authorId = authorId;
    }

    public Integer getAuthorId() {
        return authorId;
    }
}
