package app.pojo;


public class Review implements Identifiable {
    private Integer id;
    private String reviewSummary;
    private String typographicalErrors;
    private String initialVerdict;
    private String finalVerdict;
    private Integer submissionId;
    private Integer reviewerId;

    public Review(){
    }

    public Review(Integer id, String reviewSummary, String typographicalErrors, String initialVerdict, String finalVerdict, Integer submissionId, Integer reviewerId) {
        this.id = id;
        this.reviewSummary = reviewSummary;
        this.typographicalErrors = typographicalErrors;
        this.initialVerdict = initialVerdict;
        this.finalVerdict = finalVerdict;
        this.submissionId = submissionId;
        this.reviewerId = reviewerId;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getReviewSummary() {
        return reviewSummary;
    }
    public void setReviewSummary(String reviewSummary) {this.reviewSummary = reviewSummary;}

    public String getTypographicalErrors() {
        return typographicalErrors;
    }
    public void setTypographicalErrors(String typographicalErrors) { this.typographicalErrors = typographicalErrors; }

    public String getInitialVerdict() {
        return initialVerdict;
    }

    public void setInitialVerdict(String initialVerdict) {
        this.initialVerdict = initialVerdict;
    }

    public String getFinalVerdict() {
        return finalVerdict;
    }

    public void setFinalVerdict(String finalVerdict) {
        this.finalVerdict = finalVerdict;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }
}
