package app.controllers;


import app.pojo.Reviewer;

public class ReviewerController {

    // If u need some functionallity that does not exist do something like [ClassName].[methodName()]
// and then the person responsible for that class will implement the method later
    private Reviewer reviewer;

    public ReviewerController(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

}
