package app.pojo;

public class Volume {
    private Integer id;
    private Integer volumeNumber;
    private Integer numberOfEdition;
    private String yearOfPublication;
    private String issn;

    public Volume(Integer id, Integer volumeNumber, Integer numberOfEdition, String yearOfPublication, String issn) {
        this.id = id;
        this.volumeNumber = volumeNumber;
        this.numberOfEdition = numberOfEdition;
        this.yearOfPublication = yearOfPublication;
        this.issn = issn;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVolumeNumber() {
        return volumeNumber;
    }

    public Integer getNumberOfEdition() {
        return numberOfEdition;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public String getIssn() {
        return issn;
    }
}
