package com.company.users.reviewer;

import com.company.users.User;

public class Reviewer extends User {
    private Integer reviewerId;

    public Reviewer(String title, String forname, String surname, String university, String email, String password, Integer reviewerId) {
        super(title, forname, surname, university, email, password);
        this.reviewerId = reviewerId;
    }
}
