package app.database.dataAccessControllers.generic;

public class Filter {
    private String filterName;
    private Object filterValue;

    public Filter(){}
    public Filter(String filterName, Object filterValue){
        this.setFilterName(filterName);
        this.setFilterValue(filterValue);
    }

    public void setFilterName(String filterName){
        this.filterName = filterName;
    }

    public void setFilterValue(Object filterValue){
        this.filterValue = filterValue;
    }

    public String getFilterName(){
        return this.filterName;
    }

    public Object getFilterValue() {
        return this.filterValue;
    }
}
