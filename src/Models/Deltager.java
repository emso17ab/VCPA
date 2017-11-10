package Models;

public class Deltager {

    private String name;
    private String email;
    private String type;
    private String userId;

    public Deltager(String name, String email, String type, String userId){
        this.name = name;
        this.email = email;
        this.type = type;
        this.userId = userId;
    }

    //METHODS

    //GETTER/SETTER


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
