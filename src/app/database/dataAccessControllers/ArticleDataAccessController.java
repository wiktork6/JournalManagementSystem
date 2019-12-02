package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDataAccessController extends GenericDataAccessController<Article> {
    @Override
    protected String getTableName() {
        return "articles";
    }

    @Override
    protected String getAllFields() {
        return "id, page_number_range, abstract, title, final_full_article, main_author_id, edition_id";
    }

    @Override
    protected String getIndexFields(){
        return "id, title";
    }

    @Override
    protected Article readItem(ResultSet res) throws SQLException {
        Integer id = res.getInt(1);
        String pageNumberRange = res.getString(2);
        String abstractText = res.getString(3);
        String title = res.getString(4);
        String fullArticle = res.getString(5);
        Integer mainAuthorId = res.getInt(6);
        Integer editionId = res.getInt(7);
        return new Article(id, pageNumberRange, abstractText, title, fullArticle, mainAuthorId, editionId);
    }

    @Override
    protected String getModifyFields() {
        throw new UnsupportedOperationException();
    }


    @Override
    protected Integer setModifyPreparedStatement(PreparedStatement preparedStatement, Article article) throws SQLException {
        throw new UnsupportedOperationException();
    }

    public Article getLatest(){
        return this.getItem(this.getItemsQueryString() + " ORDER BY id DESC LIMIT 1", null);
    }
}
