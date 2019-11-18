package com.company.users.reviewer;

import com.company.users.User;

public class Reviewer extends User {
    // If u need some functionallity that does not exist do something like [ClassName].[methodName()]
// and then the person responsible for that class will implement the method later
    private Integer reviewerId;

    public Reviewer(String title, String forname, String surname, String university, String email, String password, Integer reviewerId) {
        super(title, forname, surname, university, email, password);
        this.reviewerId = reviewerId;
    }
}
