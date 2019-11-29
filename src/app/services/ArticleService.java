package app.services;

import app.database.dataAccessControllers.ArticleDataAccessController;
import app.database.dataAccessControllers.generic.Filter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Article;
import app.services.generic.GenericService;

import java.util.ArrayList;

public class ArticleService extends GenericService<Article> {
    public ArticleService(){super(new ArticleDataAccessController());}

    public ArrayList<Article> getEditionArticles(Integer editionId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("edition_id", editionId));
        return dac.getItemsWhere(filters);
    }
}
