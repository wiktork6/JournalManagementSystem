package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Article;
import app.services.ArticleService;

import java.util.ArrayList;

public class ArticleController extends GenericController<Article> {

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
}
