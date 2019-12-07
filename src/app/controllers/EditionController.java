package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Edition;
import app.pojo.Volume;
import app.services.AuthorService;
import app.services.EditionService;

import java.util.ArrayList;

public class EditionController extends GenericController<Edition> {
    private Edition chosenEdition;

    public EditionController(){
        super(new EditionService());
    }
    @Override
    protected boolean validateItem(Edition edition) {
        return false;
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

    public void setChosenEdition(Edition edition){
        this.chosenEdition = edition;
    }
    public Edition getChosenEdition(){
        return this.chosenEdition;
    }
}
