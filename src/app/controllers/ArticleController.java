package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Article;
import app.pojo.Edition;
import app.pojo.User;
import app.services.ArticleService;

import javax.swing.*;
import java.util.ArrayList;

public class ArticleController extends GenericController<Article> {
    private Article chosenArticle;

    public ArticleController(){ super(new ArticleService());}

    public ActionResult<ArrayList<Article>> getArticles(){
        return this.getItems();
    }

    public ActionResult<Article> getLatest(){
        Article article = ((ArticleService)this.service).getLatest();
        if(article != null){
            return new ActionResult<>(article, true, Messages.Info.ITEM_FOUND);
        }
        return new ActionResult<>(null, false, Messages.Error.ITEM_NOT_FOUND);
    }

    @Override
    protected boolean validateItem(Article article) {
        return true;
    }

    public Article getChosenArticle() {
        return this.chosenArticle;
    }

    public void setChosenArticle(Article chosenArticle) {
        this.chosenArticle = chosenArticle;
    }

    public ActionResult<ArrayList<Article>> getEditionArticles(Edition edition){
        ActionResult<ArrayList<Article>> actionResult = new ActionResult<>();
        ArrayList<Article> listOfArticles = ((ArticleService)this.service).getEditionArticles(edition.getId());
        actionResult.setResult(listOfArticles);
        if(listOfArticles.size()==0){
            actionResult.setSuccess(false);
            actionResult.setMessage(Messages.Error.ARTICLES_NOT_FOUND);
        }else{
            actionResult.setSuccess(true);
        }
        return actionResult;
    }
}
