package app.pojo;

public class Journal {
    private String issn;
    private String name;
    private Integer chiefEditorId;

    public Journal(){
    }

    public Journal(String issn, String name, Integer chiefEditorId) {
        this.issn = issn;
        this.name = name;
        this.chiefEditorId = chiefEditorId;
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
