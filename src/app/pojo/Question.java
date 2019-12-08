package app.pojo;

public class Question implements Identifiable {
    private Integer id;
    private Integer question_number;
    private String question;
    private Integer reviewId;
    private String response;
//    private boolean isAnswered;

    public Question(){
    }

    public Question(Integer id, Integer question_number, String question, String response, Integer reviewId) {
        this.id = id;
        this.question_number = question_number;
        this.question = question;
        this.response = response;
        this.reviewId = reviewId;
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

    public String getQuestion() {
        return question;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
