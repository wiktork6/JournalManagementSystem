package app;

import app.database.*;


import app.pojo.*;
import app.services.*;
import app.views.ui.WelcomePage;


import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        CreateDb.createDatabase();
        CreateDb.createTables();

        runGUI();
    }


    public static void runGUI() {

        try {
            WelcomePage window = new WelcomePage();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
