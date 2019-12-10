package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.*;
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

    public Article publishArticle(Submission submission,Edition edition){
        Article article = new Article("001-002",submission.getAbstractText(),submission.getTitle(),submission.getDraftArticle(),submission.getAuthorId(),edition.getId());
        Integer articleId = service.addItem(article);
        ActionResult<ArrayList<Author>> actionResult = Controllers.SUBMISSION.getCoAuthors(submission.getId());
        insertCoAuthors(actionResult.getResult(),articleId);
        article.setId(articleId);
        return article;
    }

    public void insertCoAuthors(ArrayList<Author> listOfAuthors, Integer articleId){
        for(int i=0; i<listOfAuthors.size(); i++){
            Controllers.AUTHOR.insertCoAuthor(articleId, listOfAuthors.get(i).getId());
        }
    }

    public ArrayList<Author> getCoAuthors(Article article){
        return ((ArticleService)this.service).getArticleCoAuthors(article.getId());
    }
}
