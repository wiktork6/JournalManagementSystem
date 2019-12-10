package app.controllers;

import app.controllers.generic.GenericController;
import app.controllers.tools.Messages;
import app.controllers.tools.generic.ActionResult;
import app.pojo.Journal;
import app.pojo.Volume;
import app.services.VolumeService;


import java.util.ArrayList;
import java.util.Calendar;

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

    public Volume getLastVolume(Journal journal){
        ArrayList<Volume> volumes = ((VolumeService)service).getJournalVolumes(journal.getId());
        if(volumes.size()==1){
            return volumes.get(0);
        }else if(volumes.size()==0){
            return null;
        }
        int latestVolume = 0;
        Volume volume = null;
        for(int i=0; i<volumes.size(); i++){
            if(latestVolume<volumes.get(i).getVolumeNumber()){
                latestVolume=volumes.get(i).getVolumeNumber();
                volume = volumes.get(i);
            }
        }
        return volume;
    }

    public Volume createNewVolume(Journal journal){
        Integer year = Calendar.getInstance().get(Calendar.YEAR);
        String newVolumeYear= year.toString();
        if(getLastVolume(journal)==null){
            Volume newVolume = new Volume(1,0, newVolumeYear,journal.getId());
            int newVolumeId = this.service.addItem(newVolume);
            return this.service.getItem(newVolumeId);
        }
        Volume newVolume = new Volume(getLastVolume(journal).getVolumeNumber()+1,0,newVolumeYear,journal.getId());
        int newVolumeId = this.service.addItem(newVolume);
        return this.service.getItem(newVolumeId);
    }
}
