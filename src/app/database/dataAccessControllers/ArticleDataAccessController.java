package app.database.dataAccessControllers;

import app.database.dataAccessControllers.Tools.BlobFileConverter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.pojo.Article;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
        File fullArticle;
        try {
            fullArticle = BlobFileConverter.getFileFromBlob(res.getBlob(5), id.toString() + ".pdf");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Integer mainAuthorId = res.getInt(6);
        Integer editionId = res.getInt(7);
        return new Article(id, pageNumberRange, abstractText, title, fullArticle, mainAuthorId, editionId);
    }

    @Override
    protected String getInsertFields() {
        return "page_number_range, abstract, title, final_full_article, main_author_id, edition_id";
    }


    @Override
    protected Integer setInsertPreparedStatement(PreparedStatement preparedStatement, Article article) throws SQLException {
        preparedStatement.setString(1, article.getPageNumberRange());
        preparedStatement.setString(2, article.getAbstractText());
        preparedStatement.setString(3, article.getTitle());
        try {
            preparedStatement.setBlob(4, new ByteArrayInputStream(BlobFileConverter.getByteArrayFromFile(article.getFullArticle())));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        preparedStatement.setInt(5, article.getMainAuthorId());
        preparedStatement.setInt(6, article.getEditionId());
        return 6;
    }

    public Article getLatest(){
        return this.getItem(this.getItemsQueryString() + " ORDER BY id DESC LIMIT 1", null);
    }
}
