package app.services;

import app.database.dataAccessControllers.ArticleDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Article;
import app.pojo.Author;
import app.services.generic.GenericService;
import java.util.ArrayList;

public class ArticleService extends GenericService<Article> {
    public ArticleService(){super(new ArticleDataAccessController());}

    public ArrayList<Article> getEditionArticles(Integer editionId){
        ArrayList<KVPair> filters = new ArrayList<KVPair>();
        filters.add(new KVPair("edition_id", editionId));
        return dac.getItemsWhere(filters);
    }

    public Article getLatest(){
        return ((ArticleDataAccessController)dac).getLatest();
    }

    public ArrayList<Author> getArticleCoAuthors(Integer articleId){
        return ((ArticleDataAccessController)dac).getArticleCoAuthors(articleId);
    }

}
