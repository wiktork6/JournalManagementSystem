package app.pojo;

import app.pojo.Article;
import app.database.databaseInterfaces.DataAccessController;
import app.pojo.Edition;
import app.pojo.Journal;
import app.pojo.Volume;

import java.util.ArrayList;

public class Reader {
    private DataAccessController dataAccessController;

    public Reader(DataAccessController dataAccessController) {
        this.dataAccessController = dataAccessController;
    }
    public ArrayList<Journal> getJournals(){
        return dataAccessController.getJournals();
    }
    public ArrayList<Volume> getVolumes(String issn){
        return dataAccessController.getVolumes(issn);
    }
    public ArrayList<Volume> getVolumes(){
        return dataAccessController.getVolumes();
    }
    public ArrayList<Edition> getEditions() {
        return dataAccessController.getEditions();
    }
    public ArrayList<Edition> getEditions(Integer volumeId){
        return dataAccessController.getEditions(volumeId);
    }
    public ArrayList<Article> getArticles(Integer editionId){
        return dataAccessController.getArticles(editionId);
    }
    public ArrayList<Article> getArticles(){
        return dataAccessController.getArticles();
    }
    public Article showArticle(Integer articleId){
        return dataAccessController.showArticle(articleId);
    }

}
