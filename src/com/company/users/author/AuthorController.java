package com.company.users.author;

import com.company.database.DataAccessController;
// If u need some functionallity that does not exist do something like [ClassName].[methodName()]
// and then the person responsible for that class will implement the method later
public class AuthorController {
    private Author author;

    public AuthorController(Author author) {
        this.author = author;
    }

    public void createNewSubmission(){
        DataAccessController.insertArticle();
    }
}
