package com.company.review;


public class Review {
    private Integer id;
    private String reviewSummary;
    private String typographicallErrors;
    private String initialVerdict;
    private String finalVerdict;
    private Integer submissionId;
    private Integer reviewerId;

    public Review(Integer id, String reviewSummary, String typographicallErrors, String initialVerdict, String finalVerdict, Integer submissionId, Integer reviewerId) {
        this.id = id;
        this.reviewSummary = reviewSummary;
        this.typographicallErrors = typographicallErrors;
        this.initialVerdict = initialVerdict;
        this.finalVerdict = finalVerdict;
        this.submissionId = submissionId;
        this.reviewerId = reviewerId;
    }

    public Integer getId() {
        return id;
    }

    public String getReviewSummary() {
        return reviewSummary;
    }

    public String getTypographicallErrors() {
        return typographicallErrors;
    }

    public String getInitialVerdict() {
        return initialVerdict;
    }

    public String getFinalVerdict() {
        return finalVerdict;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }
}
