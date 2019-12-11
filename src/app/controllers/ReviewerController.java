package app.controllers;


import app.controllers.generic.Controller;
import app.controllers.generic.GenericController;
import app.controllers.roles.Role;
import app.controllers.tools.ActionSuccess;
import app.controllers.tools.generic.ActionResult;
import app.pojo.*;
import app.services.ReviewerService;
import app.services.generic.GenericService;
import app.views.ui.ArticleReviewSelection;
import app.views.ui.RegisteredNewArticle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewerController extends GenericController<Reviewer> implements Role {
    public ReviewerController() {
        super(new ReviewerService());
    }

    @Override
    public String getName() {
        return "Reviewer";
    }

    @Override
    public HashMap<String, ActionListener> getAvailableActions(JFrame frame) {
        HashMap<String, ActionListener> availableActions = new HashMap<>();
        availableActions.put("REVIEW SUBMISSIONS", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ArticleReviewSelection artclrvw = new ArticleReviewSelection();
                artclrvw.frame.setVisible(true);
            }
        });
        return availableActions;
    }

    public Reviewer register(User user){
        Reviewer reviewer = new Reviewer();
        reviewer.setUser(user);
        Integer reviewerId = service.addItem(reviewer);
        reviewer.setId(reviewerId);
        return reviewer;
    }

    public Reviewer getUserReviewer(Integer userId){
        return ((ReviewerService)this.service).getUserReviewer(userId);
    }

//    public ActionSuccess removeReviewer(Integer reviewerId){
//        return super.removeItem(reviewerId);
//    }

    @Override
    protected boolean validateItem(Reviewer reviewer) {
        return true;
    }



    public Integer submissionsToReview(){
        User user = Controllers.USER.getLoggedUser();
        Reviewer reviewer = Controllers.REVIEWER.getUserReviewer(user.getId());
        Author author = Controllers.AUTHOR.getAuthor(user);

        ActionResult<ArrayList<Submission>> submissionsActionResult = Controllers.SUBMISSION.getSubmissions(author);
        ArrayList<Submission> submissionsList = submissionsActionResult.getResult();
        if(submissionsList.size()==0){
            return 0;
        }
        int sumOfChosenReviews = 0;
        for(int i=0; i<submissionsList.size();i++){
            sumOfChosenReviews+=submissionsList.get(i).getReviewsSelected();
        }
        return submissionsList.size()*3-sumOfChosenReviews;
    }







}
