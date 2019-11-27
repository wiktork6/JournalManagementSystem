package app.pojo;

public class Edition {
    private Integer id;
    private Integer edition_number;
    private String monthOfPublication;
    private Integer volumeId;

    public Edition(Integer id, Integer edition_number, String monthOfPublication, Integer volumeId) {
        this.id = id;
        this.edition_number = edition_number;
        this.monthOfPublication = monthOfPublication;
        this.volumeId = volumeId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getEdition_number() {
        return edition_number;
    }

    public String getMonthOfPublication() {
        return monthOfPublication;
    }

    public Integer getVolumeId() {
        return volumeId;
    }
}
