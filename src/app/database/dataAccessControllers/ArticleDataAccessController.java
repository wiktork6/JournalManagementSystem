package app.database.dataAccessControllers;

import app.database.DbConnection;
import app.database.dataAccessControllers.Tools.BlobFileConverter;
import app.database.dataAccessControllers.generic.GenericDataAccessController;
import app.database.dataAccessControllers.generic.KVPair;
import app.pojo.Article;
import app.pojo.Author;
import app.pojo.User;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList<Author> getArticleCoAuthors(Integer articleId) {
        try(Connection conn = DriverManager.getConnection(DbConnection.STRING);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT u.id, u.email, u.title, u.forname, u.surname, u.university, a.id FROM article_author s INNER JOIN authors a ON a.id=s.author_id INNER JOIN users u ON u.id=a.user_id WHERE s.article_id = ?;")){
            preparedStatement.setInt(1,articleId);
            ResultSet res = preparedStatement.executeQuery();
            ArrayList<Author> arrayList = new ArrayList<>();
            while(res.next()){
                Integer id = res.getInt(1);
                String email = res.getString(2);
                String title = res.getString(3);
                String forname = res.getString(4);
                String surname = res.getString(5);
                String university = res.getString(6);
                Integer authorId = res.getInt(7);
                User user = new User(id,title,forname,surname,university,email);
                Author author = new Author(user,authorId);
                arrayList.add(author);
            }

            res.close();
            return arrayList;

        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

}
