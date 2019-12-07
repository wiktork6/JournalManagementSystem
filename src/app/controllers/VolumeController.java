package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Journal;
import app.pojo.Volume;
import app.services.VolumeService;

import java.util.ArrayList;

public class VolumeController extends GenericController<Volume> {
    private Volume chosenVolume;
    public VolumeController(){
        super(new VolumeService());
    }

    @Override
    protected boolean validateItem(Volume volume) {
        return false;
    }

    public ActionResult<ArrayList<Volume>> getJournalVolumes(Journal journal){
        ActionResult<ArrayList<Volume>> actionResult = new ActionResult<>();
        actionResult.setResult(((VolumeService)this.service).getJournalVolumes(journal.getId()));

        if(actionResult.getResult().size()==0){
            actionResult.setSuccess(false);
            actionResult.setMessage(Messages.Error.VOLUMES_NOT_FOUND);
            return actionResult;
        }
        actionResult.setSuccess(true);
        return actionResult;

    }

    public void setChosenVolume(Volume volume){
        this.chosenVolume = volume;
    }
    public Volume getChosenVolume(){
        return this.chosenVolume;
    }
}
