package rs.raf.entities;

public class User {
    private Integer user_id;
    private String user_username;
    private String user_name;
    private String user_hashedPassword;

    public User(String user_username, String user_name, String user_hashedPassword) {
        this.user_username = user_username;
        this.user_name = user_name;
        this.user_hashedPassword = user_hashedPassword;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_hashedPassword() {
        return user_hashedPassword;
    }

    public void setUser_hashedPassword(String user_hashedPassword) {
        this.user_hashedPassword = user_hashedPassword;
    }
}
