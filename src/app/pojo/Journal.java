package app.pojo;

public class Journal {
    private String issn;
    private String name;
    private Integer numberOfVolumes;
    private Integer chiefEditorId;

    public Journal(String issn, String name, Integer numberOfVolumes, Integer chiefEditorId) {
        this.issn = issn;
        this.name = name;
        this.numberOfVolumes = numberOfVolumes;
        this.chiefEditorId = chiefEditorId;
    }
}
