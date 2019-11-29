package app;

import app.database.generic.DataAccessController;

import app.pojo.*;
import app.controllers.register.RegisterJournal;
import app.controllers.register.RegisterSubmission;
import app.controllers.register.RegisterUser;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       registerNewEditorAndJournalButton("Mr", "Wiktor", "Koprowski", "University of Sheffield", "1234@gmail.com", "1234","1234","A1234567", "Journal Of Computer Science");
       registerNewAuthorAndSubmissionButton("Mrs", "Emma", "Norling", "The University of Sheffield", "Norling@Sheffield.ac.uk","abcd", "abcd","A1234567", "AI modern way", "This is article text ver sophisticated article", "abstract article sophisticated");
       Integer submissionId = registerNewAuthorAndSubmissionButton("Mr", "Dawid", "Bogut", "Politechnika Gdanska", "DawidB@gmail.com","Brylant", "Brylant","A1234567", "Koszykowka najpiekniejszy sport", "Koszywkoa jest to niesamowity sport. zakochalem sie w nim od 3 klasy podstawiwki i do dzisiaj gram w kosza, super gra polecam", "O moim zyciu i koszykowce");
        addCoAuthorToSubmissionButtom("Mr", "Bob", "Black", "University of Manchester", "BobBlack@manchester.ac.uk","BB1234", "BB1234", submissionId);
       //        viewJournalsButton();

    }

    //It needs to print author to the box, to be added later
    public static Author addCoAuthorToSubmissionButtom(String title, String forname, String surname, String university, String email, String password, String repeatPassword, Integer submissionId){
        DataAccessController dataAccessController = new MySqlDataAccessController();
        RegisterUser registerUser = new RegisterUser(dataAccessController);
        Author author = registerUser.registerNewAuthor(title, forname, surname, university, email, password, repeatPassword);
        dataAccessController.insertCoAuthor(submissionId, author.getAuthorId());
        return author;

    }
    public static Integer registerNewAuthorAndSubmissionButton(String title, String forname, String surname, String university, String email, String password, String repeatPassword, String issn, String articleTitle, String text, String abstractText){
        DataAccessController dataAccessController = new MySqlDataAccessController();

        RegisterUser registerUser = new RegisterUser(dataAccessController);
        Author author = registerUser.registerNewAuthor(title, forname, surname, university, email, password, repeatPassword);
        RegisterSubmission registerSubmission = new RegisterSubmission(dataAccessController);
        Integer submissionId = registerSubmission.registerNewSubmission(author,articleTitle,abstractText, text, issn);
        return  submissionId;
    }



    public static void registerNewEditorAndJournalButton(String title, String forname, String surname, String university, String email, String password, String repeatPassword, String issn, String name){
        DataAccessController dataAccessController = new MySqlDataAccessController();
        RegisterUser registerUser = new RegisterUser(dataAccessController);
        Editor editor = registerUser.registerNewEditor(title,forname,surname,university,email,password,repeatPassword);
        RegisterJournal registerJournal = new RegisterJournal( dataAccessController);
        registerJournal.registerNewJournal(editor, issn, name);
    }

    public static void viewJournalsButton(){
        DataAccessController dataAccessController = new MySqlDataAccessController();
        Reader reader = new Reader(dataAccessController);
        ArrayList<Journal> listOfJournals = dataAccessController.getJournals();

        for(int i =0; i<listOfJournals.size(); i++){
            String word = "";
            word += listOfJournals.get(i).getIssn() + " ";
            word += listOfJournals.get(i).getName() + " ";
            word += listOfJournals.get(i).getNumberOfVolumes() + " ";
            word += listOfJournals.get(i).getChiefEditorId();
            System.out.println(word);
        }
    }
    public static void viewVolumesButtom(String issn){
        DataAccessController dataAccessController = new MySqlDataAccessController();
        Reader reader = new Reader(dataAccessController);
        ArrayList<Volume> listOfVolumes = dataAccessController.getVolumes(issn);

        for(int i =0; i<listOfVolumes.size(); i++){
            String word = "";
            word += listOfVolumes.get(i).getId() + " ";
            word += listOfVolumes.get(i).getIssn() + " ";
            word += listOfVolumes.get(i).getYearOfPublication() + " ";
            word += listOfVolumes.get(i).getVolumeNumber() + " ";
            word += listOfVolumes.get(i).getNumberOfEdition();
            System.out.println(word);
        }
    }

    public static void viewEditionsButtom(Integer volumeId){
        DataAccessController dataAccessController = new MySqlDataAccessController();
        Reader reader = new Reader(dataAccessController);
        ArrayList<Edition> listOfEditions = dataAccessController.getEditions(volumeId);
        for(int i =0; i<listOfEditions.size(); i++){
            String word = "";
            word += listOfEditions.get(i).getId() + " ";
            word += listOfEditions.get(i).getEdition_number() + " ";
            word += listOfEditions.get(i).getMonthOfPublication() + " ";
            word += listOfEditions.get(i).getVolumeId();
            System.out.println(word);
        }
    }
    public static void viewArticlesButton(Integer editionId){
        DataAccessController dataAccessController = new MySqlDataAccessController();
        Reader reader = new Reader(dataAccessController);
        ArrayList<Article> listOfArticles = dataAccessController.getArticles(editionId);
        for(int i =0; i<listOfArticles.size(); i++){
            String word = "";
            word += listOfArticles.get(i).getId() + " ";
            word += listOfArticles.get(i).getTitle() + " ";
            word += listOfArticles.get(i).getMainAuthorId() + " ";
            System.out.println(word);
        }
    }
}
