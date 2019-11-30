package app.pojo;

public class Author implements Identifiable {
    private Integer id;
    private User user;

    public Author(){
    }

    public Author(Integer userId){
        this.user = new User(userId);
    }

    public Author(Integer id, Integer userId) {
        this(userId);
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
