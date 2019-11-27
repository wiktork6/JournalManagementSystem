package app;

import app.database.MySqlDataAccessController;
import app.database.MySqlDataInsertController;
import app.database.databaseInterfaces.DataAccessController;
import app.database.databaseInterfaces.DataInsertController;
import app.pojo.*;
import app.ui.RegisterJournal;
import app.ui.RegisterSubmission;
import app.ui.RegisterUser;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//       registerNewEditorAndJournal("Mr", "Wiktor", "Koprowski", "University of Sheffield", "1234@gmail.com", "1234","1234","A1234567", "Journal Of Computer Science");
//       registerNewAuthorAndSubmission("Mrs", "Emma", "Norling", "The University of Sheffield", "Norling@Sheffield.ac.uk","abcd", "abcd","A1234567", "AI modern way", "This is article text ver sophisticated article", "abstract article sophisticated");
//       registerNewAuthorAndSubmission("Mr", "Dawid", "Bogut", "Politechnika Gdanska", "DawidB@gmail.com","Brylant", "Brylant","A1234567", "Koszykowka najpiekniejszy sport", "Koszywkoa jest to niesamowity sport. zakochalem sie w nim od 3 klasy podstawiwki i do dzisiaj gram w kosza, super gra polecam", "O moim zyciu i koszykowce");
        viewJournalsButton();
    }
    public static void registerNewAuthorAndSubmission(String title, String forname, String surname, String university, String email, String password, String repeatPassword, String issn, String articleTitle, String text, String abstractText){
        DataAccessController dataAccessController = new MySqlDataAccessController();
        DataInsertController dataInsertController = new MySqlDataInsertController();
        RegisterUser registerUser = new RegisterUser(dataInsertController,dataAccessController);
        Author author = registerUser.registerNewAuthor(title, forname, surname, university, email, password, repeatPassword);
        RegisterSubmission registerSubmission = new RegisterSubmission(dataInsertController,dataAccessController);
        registerSubmission.registerNewSubmission(author,articleTitle,abstractText, text, issn);
    }



    public static void registerNewEditorAndJournal(String title, String forname, String surname, String university, String email, String password, String repeatPassword, String issn, String name){
        DataAccessController dataAccessController = new MySqlDataAccessController();
        DataInsertController dataInsertController = new MySqlDataInsertController();
        RegisterUser registerUser = new RegisterUser(dataInsertController,dataAccessController);
        Editor editor = registerUser.registerNewEditor(title,forname,surname,university,email,password,repeatPassword);
        RegisterJournal registerJournal = new RegisterJournal(dataInsertController, dataAccessController);
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
}
