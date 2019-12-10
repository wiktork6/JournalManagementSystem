package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Edition;
import app.pojo.Journal;
import app.pojo.Volume;
import app.services.AuthorService;
import app.services.EditionService;
import app.services.VolumeService;

import java.util.ArrayList;
import java.util.Calendar;

public class EditionController extends GenericController<Edition> {
    private Edition chosenEdition;

    public EditionController(){
        super(new EditionService());
    }
    @Override
    protected boolean validateItem(Edition edition) {
        return true;
    }
    public ActionResult<ArrayList<Edition>> getVolumeEditions(Volume volume){
        ActionResult<ArrayList<Edition>> actionResult = new ActionResult<>();
        ArrayList<Edition> listOfEditions = ((EditionService)service).getVolumeEditions(volume.getId());
        actionResult.setResult(listOfEditions);
        if(listOfEditions.size()==0){
            actionResult.setSuccess(false);
            actionResult.setMessage(Messages.Error.EDITIONS_NOT_FOUND);
        }else{
            actionResult.setSuccess(true);
        }
        return actionResult;
    }

    public ActionResult<Edition> addEdition(Edition edition){
        return super.addItem(edition);
    }

    public void setChosenEdition(Edition edition){
        this.chosenEdition = edition;
    }
    public Edition getChosenEdition(){
        return this.chosenEdition;
    }

    public Edition getLastEdition(Volume volume){
        if(volume==null){
            return null;
        }
        ArrayList<Edition> editions = ((EditionService)service).getVolumeEditions(volume.getId());
        if(editions.size()==1){
            return editions.get(0);
        }else if(editions.size()==0){
            return null;
        }
        int latestVolume = 0;
        Edition edition = null;
        for(int i=0; i<editions.size(); i++){
            if(latestVolume<editions.get(i).getEdition_number()){
                latestVolume=editions.get(i).getEdition_number();
                edition = editions.get(i);
            }
        }
        return edition;
    }

    public Edition createNewEdition(Volume volume){
        int monthNumber = Calendar.MONTH;
        String monthName ="";
        switch(monthNumber) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        if(getLastEdition(volume)==null){
            Edition newEdition = new Edition(1,monthName,volume.getId());
            int newEditionId = this.service.addItem(newEdition);
            return this.service.getItem(newEditionId);
        }
        Edition edition = new Edition(getLastEdition(volume).getEdition_number()+1,monthName,volume.getId());
        int newEditionId = this.service.addItem(edition);
        return this.service.getItem(newEditionId);
    }
}
