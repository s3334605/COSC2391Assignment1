import utilities.Date;

abstract class User {
    private String session;
    private String id;
    
    public User(String session, String id) {
        this.session = session;
        this.id = id;
    }
}

class Member extends User {
    private String firstName;
    private String lastName;
    private String addressFull;
    private Date dateJoined;
    private Cart<T> cart;

}