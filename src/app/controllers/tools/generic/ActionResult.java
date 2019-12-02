package app.controllers.tools.generic;

import app.controllers.tools.ActionSuccess;

public class ActionResult<Result> extends ActionSuccess {

    private Result result;

    public ActionResult(Result result, boolean success, String message){
        super(success, message);
        setResult(result);
    }

    public ActionResult(){}

    public void setResult(Result result){
        this.result = result;
    }

    public Result getResult(){
        return this.result;
    }
}
