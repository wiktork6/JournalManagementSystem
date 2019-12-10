package app.pojo;

public class Edition implements Identifiable {
    private Integer id;
    private Integer edition_number;
    private String monthOfPublication;
    private Integer volumeId;

    public Edition(){
    }

    public Edition(Integer id, Integer edition_number, String monthOfPublication, Integer volumeId) {
        this.id = id;
        this.edition_number = edition_number;
        this.monthOfPublication = monthOfPublication;
        this.volumeId = volumeId;
    }

    public Edition(Integer edition_number, String monthOfPublication, Integer volumeId) {
        this.edition_number = edition_number;
        this.monthOfPublication = monthOfPublication;
        this.volumeId = volumeId;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEdition_number() {
        return edition_number;
    }

    public void setEdition_number(Integer edition_number) {
        this.edition_number = edition_number;
    }

    public String getMonthOfPublication() {
        return monthOfPublication;
    }

    public void setMonthOfPublication(String monthOfPublication) {
        this.monthOfPublication = monthOfPublication;
    }

    public Integer getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(Integer volumeId) {
        this.volumeId = volumeId;
    }
}
