package app.services;

import app.database.generic.Filter;
import app.database.generic.GenericDataAccessController;
import app.pojo.Article;
import app.pojo.Volume;

import java.util.ArrayList;

public class ArticleService extends GenericService<Article> {
    ArticleService(GenericDataAccessController<Article> dac) {
        super(dac);
    }

    public ArrayList<Article> getEditionArticles(String editionId){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new Filter("edition_id", editionId));
        return dac.getItemsWhere(filters);
    }
}
