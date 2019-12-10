package app.pojo;

public class Volume implements Identifiable {
    private Integer id;
    private Integer volumeNumber;
    private Integer numberOfEditions;
    private String yearOfPublication;
    private Integer journalId;

    public Volume() {
    }
    public Volume(Integer volumeNumber, Integer numberOfEditions, String yearOfPublication, Integer journalId){
        this.volumeNumber = volumeNumber;
        this.numberOfEditions = numberOfEditions;
        this.yearOfPublication = yearOfPublication;
        this.journalId = journalId;
    }

    public Volume(Integer id, Integer volumeNumber, Integer numberOfEditions, String yearOfPublication, Integer journalId) {
        this.id = id;
        this.volumeNumber = volumeNumber;
        this.numberOfEditions = numberOfEditions;
        this.yearOfPublication = yearOfPublication;
        this.journalId = journalId;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolumeNumber() {
        return volumeNumber;
    }

    public void setVolumeNumber(Integer volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    public Integer getNumberOfEditions() {
        return numberOfEditions;
    }

    public void setNumberOfEditions(Integer numberOfEditions) {
        this.numberOfEditions = numberOfEditions;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }
}
