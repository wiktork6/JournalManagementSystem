package app;

import app.pojo.Article;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Article> listOfArticles = new ArrayList<>();
        for (int i = 0; i < listOfArticles.size(); i++){
            System.out.println(listOfArticles.get(i).getId());

        }

    }
}
