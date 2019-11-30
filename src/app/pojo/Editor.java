package app.pojo;

public class Editor implements Identifiable {
    private Integer id;
    private User user;

    public Editor(){
    }

    public Editor(Integer id, Integer userId) {
        this(id);
        this.user = new User(userId);
    }

    public Editor(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }
}
