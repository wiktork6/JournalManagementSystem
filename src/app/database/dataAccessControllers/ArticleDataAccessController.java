package app.database.dataAccessControllers;

import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDataAccessController extends GenericDataAccessController<Article> {
    @Override
    protected String getItemsQueryString() {
        return "SELECT id, page_number_range, abstract, title, final_full_article, main_author_id, edition_id FROM articles";
    }

    @Override
    protected Article readItem(ResultSet res) throws SQLException {
        Integer id = res.getInt(1);
        String pageNumberRange = res.getString(2);
        String abstractText = res.getString(3);
        String title = res.getString(4);
        String fullArticle = res.getString(5);
        Integer mainAuthorId = res.getInt(7);
        Integer editionId = res.getInt(8);
        return new Article(id, pageNumberRange, abstractText, title, fullArticle, mainAuthorId, editionId);
    }

    @Override
    protected String insertItemQueryString() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void setInsertPreparedStatement(PreparedStatement preparedStatement, Article article) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
