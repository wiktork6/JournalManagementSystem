package app.pojo;

public class Reviewer extends User {
    // If u need some functionallity that does not exist do something like [ClassName].[methodName()]
// and then the person responsible for that class will implement the method later
    private Integer reviewerId;

    public Reviewer(Integer id, String title, String forname, String surname, String university, String email, Integer reviewerId) {
        super(id, title, forname, surname, university, email);
        this.reviewerId = reviewerId;
    }
}
