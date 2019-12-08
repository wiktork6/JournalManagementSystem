package app.pojo;

public class Question implements Identifiable {
    private Integer id;
    private Integer question_number;
    private String question;
    private Integer reviewId;
    private boolean isAnswered;
    private String response;

    public Question(){
    }

    public Question(Integer id, Integer question_number, String question, String response, boolean isAnswered, Integer reviewId) {
        this.id = id;
        this.question_number = question_number;
        this.question = question;
        this.response = response;
        this.reviewId = reviewId;
        this.isAnswered = isAnswered;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(Integer question_number) {
        this.question_number = question_number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered){
        this.isAnswered = answered;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
