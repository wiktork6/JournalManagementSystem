package app.pojo;

public class Reviewer implements Identifiable {

    private Integer id;
    private User user;

    public Reviewer(){
    }

    public Reviewer(Integer id){
        this.id = id;
    }

    public Reviewer(Integer id, Integer userId) {
        this(id);
        this.user = new User(userId);
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
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
