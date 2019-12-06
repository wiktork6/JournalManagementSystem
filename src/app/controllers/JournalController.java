package app.controllers;


import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Editor;
import app.pojo.Journal;
import app.services.JournalService;

import java.util.ArrayList;

public class JournalController extends GenericController<Journal> {

    private Journal chosenJournal;


    public JournalController() {
        super(new JournalService());
    }

    public ActionResult<Journal> getJournal(Integer journalId){
        return this.getItem(journalId);
    }

    @Override
    protected boolean validateItem(Journal journal) {
        return ((((JournalService)this.service).getJournalByISSN(journal.getIssn()) == null) && (((JournalService)this.service).getJournalByName(journal.getName())==null));

    }

    public ActionResult<Journal> register(Journal journal){

        return this.addItem(journal);
    }

    public ArrayList<Journal> getAllJournals(){
        return service.getItems();
    }

    public boolean addNewEditorToJournal(Integer journalId, Integer editorId){
        return ((JournalService)this.service).insertJournalEditor(journalId,editorId);
    }

    public boolean isExist(String issn, String name){
        return ((((JournalService)this.service).getJournalByISSN(issn) == null) && (((JournalService)this.service).getJournalByName(name)==null));
    }

    public ActionResult<ArrayList<Journal>> getEditorsJournals(Editor editor){
        ActionResult<ArrayList<Journal>> actionResult = new ActionResult<>();
        ArrayList<Journal> listOfJournals = ((JournalService)this.service).getEditorsJournals(editor);
        if(listOfJournals==null){
            actionResult.setSuccess(false);
            actionResult.setResult(listOfJournals);
        }else{
            actionResult.setSuccess(true);
            actionResult.setResult(listOfJournals);
        }
        return actionResult;
    }

    public ActionResult<Journal> getJournalByISSN(String issn){
        ActionResult<Journal> actionResult = new ActionResult<>();
        actionResult.setResult(((JournalService)this.service).getJournalByISSN(issn));
        if(actionResult.getResult() == null){
            actionResult.setSuccess(false);
            actionResult.setMessage(Messages.Error.JOURNAL_DOES_NOT_EXIST);
        }else{
            actionResult.setSuccess(true);
        }
        return actionResult;
    }
    public void setChosenJournal(Journal journal){
        this.chosenJournal = journal;
    }
    public void removeChosenJournal(){
        this.chosenJournal = null;
    }
    public Journal getChosenJournal(){
        return this.chosenJournal;
    }

    public void changeChiefEditor(Editor editor, Journal journal){
        journal.setChiefEditorId(editor.getId());
        this.service.updateItem(journal);
    }

    public boolean retireEditor(Editor editor, Journal journal){
        return ((JournalService)this.service).retireEditorFromJournal(editor,journal);
    }

}
