package app.pojo;

public class Response implements Identifiable {
    private Integer id;
    private String response;
    private Integer authorId;
    private Integer questionId;

    public Response(){
    }

    public Response(Integer id, String response, Integer authorId, Integer questionId) {
        this.id = id;
        this.response = response;
        this.authorId = authorId;
        this.questionId = questionId;
    }


    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
