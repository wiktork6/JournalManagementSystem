package app.controllers;


import app.controllers.roles.Role;
import app.views.ui.ArticleReviewSelection;
import app.views.ui.RegisteredNewArticle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReviewerController implements Role {
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

}
