package app.database.dataAccessControllers.generic;

public class KVPair {
    private String key;
    private Object value;

    public KVPair(){}
    public KVPair(String key){
        this.key = key;
    }
    public KVPair(String key, Object value){
        this.setKey(key);
        this.setValue(value);
    }

    public void setKey(String key){
        this.key = key;
    }

    public void setValue(Object value){
        this.value = value;
    }

    public String getKey(){
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }
}
