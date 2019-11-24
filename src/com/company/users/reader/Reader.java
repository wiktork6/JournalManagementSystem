package com.company.users.reader;

import com.company.article.Article;
import com.company.database.MySqlDataAccessController;
import com.company.database.databaseInterfaces.DataAccessController;
import com.company.edition.Edition;
import com.company.journal.Journal;
import com.company.volume.Volume;

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

    public static void logout(){

    }
}
