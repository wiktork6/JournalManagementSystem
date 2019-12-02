package app.controllers.tools;


public class ActionSuccess {

    private boolean success;
    private String message;

    public ActionSuccess(boolean success, String message){
        this.setMessage(message);
        this.setSuccess(success);
    }

    public ActionSuccess(){

    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public boolean getSuccess(){
        return this.success;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
