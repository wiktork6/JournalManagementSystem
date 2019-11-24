package com.company.journal;

public class Journal {
    private String issn;
    private Integer numberOfVolumes;
    private Integer chiefEditorId;

    public Journal(String issn, Integer numberOfVolumes, Integer chiefEditorId) {
        this.issn = issn;
        this.numberOfVolumes = numberOfVolumes;
        this.chiefEditorId = chiefEditorId;
    }
}
