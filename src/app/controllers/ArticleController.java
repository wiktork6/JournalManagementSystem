package app.controllers;

import app.pojo.Article;
import app.services.ArticleService;

import java.util.ArrayList;

public class ArticleController {

    protected ArticleService service;

    ArticleController(){ this.service = new ArticleService();}

    public ArrayList<Article> listItems(){
        return service.getItems();
    }
}
