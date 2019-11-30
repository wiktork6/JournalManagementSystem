package app.controllers;

import app.controllers.generic.GenericController;
import app.pojo.Article;
import app.services.ArticleService;

import java.util.ArrayList;

public class ArticleController extends GenericController<Article> {

    public ArticleController(){ super(new ArticleService());}

    public ArrayList<Article> getArticles(){
        return this.getItems();
    }

    public Article getLatest(){
        return ((ArticleService)this.service).getLatest();
    }

    @Override
    protected boolean validateItem(Article article) {
        return true;
    }
}
