package app.pojo;

public class Question {
    private Integer id;
    private Integer question_number;
    private String question;
    private Integer reviewId;
//    private boolean isAnswered;

    public Question(){
    }

    public Question(Integer id, Integer question_number, String question, Integer reviewId) {
        this.id = id;
        this.question_number = question_number;
        this.question = question;
        this.reviewId = reviewId;
    }

    public Integer getId() {
        return id;
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
}
