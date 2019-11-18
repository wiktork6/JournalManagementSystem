package com.company.users.editor;

import com.company.users.User;

public class Editor extends User {
    private Integer editorId;

    public Editor(String title, String forname, String surname, String university, String email, String password, Integer editorId) {
        super(title, forname, surname, university, email, password);
        this.editorId = editorId;
    }
}
