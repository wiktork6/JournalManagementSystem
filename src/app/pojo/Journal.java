package app.pojo;

public class Journal implements Identifiable {
    private Integer id;
    private String issn;
    private String name;
    private Integer chiefEditorId;

    public Journal(){
    }

    public Journal(String issn, String name, Integer chiefEditorId){
        this.issn = issn;
        this.name = name;
        this.chiefEditorId = chiefEditorId;
    }

    public Journal(Integer id, String issn, String name, Integer chiefEditorId) {
        this(issn, name, chiefEditorId);
        this.id = id;
    }

    public Integer getId(){ return id; }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssn() {
        return issn;
    }

    public String getName() {
        return name;
    }

    public Integer getChiefEditorId() {
        return chiefEditorId;
    }
}
