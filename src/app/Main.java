package app;

import app.database.*;

import app.database.dataAccessControllers.*;
import app.pojo.*;
import app.services.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CreateDb.createTables();
       registerNewEditorAndJournalButton("Mr", "Wiktor", "Koprowski", "University of Sheffield", "1234@gmail.com", "1234","1234","A1234567", "Journal Of Computer Science");
       registerNewAuthorAndSubmissionButton("Mrs", "Emma", "Norling", "The University of Sheffield", "Norling@Sheffield.ac.uk","abcd", "abcd","A1234567", "AI modern way", "This is article text ver sophisticated article", "abstract article sophisticated");
       Integer submissionId = registerNewAuthorAndSubmissionButton("Mr", "Dawid", "Bogut", "Politechnika Gdanska", "DawidB@gmail.com","Brylant", "Brylant","A1234567", "Koszykowka najpiekniejszy sport", "Koszywkoa jest to niesamowity sport. zakochalem sie w nim od 3 klasy podstawiwki i do dzisiaj gram w kosza, super gra polecam", "O moim zyciu i koszykowce");
        addCoAuthorToSubmissionButtom("Mr", "Bob", "Black", "University of Manchester", "BobBlack@manchester.ac.uk","BB1234", "BB1234", submissionId);
       //        viewJournalsButton();

    }
//    public static boolean loginButton(String email, String password){
//        DataAccessController dataAccessController = new MySqlDataAccessController();
//        Login login = new Login(dataAccessController);
//        if(login.login(email, password)!=0){
//
//        }else{
//            System.out.println("Incorrect email or password");
//            return false;
//        }
//    }

    //It needs to print author to the box, to be added later
    public static Integer addCoAuthorToSubmissionButtom(String title, String forname, String surname, String university, String email, String password, String repeatPassword, Integer submissionId){
        UserService us = new UserService(new UserDataAccessController());
        User user = new User(title, forname, surname, university, email, password);
        Integer userId = us.addItem(user);

        AuthorService as = new AuthorService(new AuthorDataAccessController());
        Integer authorId = as.addItem(new Author(userId));

        SubmissionService ss = new SubmissionService(new SubmissionDataAccessController());
        ss.addCoAuthor(submissionId, authorId);
        return authorId;

    }
    public static Integer registerNewAuthorAndSubmissionButton(String title, String forname, String surname, String university, String email, String password, String repeatPassword, String issn, String articleTitle, String text, String abstractText){
        UserService us = new UserService(new UserDataAccessController());
        User user = new User(title, forname, surname, university, email, password);
        Integer userId = us.addItem(user);

        AuthorService as = new AuthorService(new AuthorDataAccessController());
        Integer authorId = as.addItem(new Author(userId));

        SubmissionService ss = new SubmissionService(new SubmissionDataAccessController());
        Integer submissionId = ss.addItem(new Submission(-1, abstractText, articleTitle, text, authorId, issn));
        return  submissionId;
    }



    public static Integer registerNewEditorAndJournalButton(String title, String forname, String surname, String university, String email, String password, String repeatPassword, String issn, String name){
        UserService us = new UserService(new UserDataAccessController());
        User user = new User(title, forname, surname, university, email, password);
        Integer userId = us.addItem(user);

        EditorService es = new EditorService(new EditorDataAccessController());
        Integer editorId = es.addItem(new Editor(userId));

        JournalService js = new JournalService(new JournalDataAccessController());
        return js.addItem(new Journal(issn, name, editorId));
    }

    public static ArrayList<Journal> viewJournalsButton(){
        return new JournalService(new JournalDataAccessController()).getItems();
    }
    public static ArrayList<Volume> viewVolumesButtom(String issn){
        return new VolumeService(new VolumeDataAccessController()).getJournalVolumes(issn);
    }

    public static ArrayList<Edition> viewEditionsButtom(Integer volumeId){
        return new EditionService(new EditionDataAccessController()).getVolumeEditions(volumeId);
    }
    public static ArrayList<Article> viewArticlesButton(Integer editionId) {
        return new ArticleService(new ArticleDataAccessController()).getEditionArticles(editionId);
    }
}
