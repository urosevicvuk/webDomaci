package rs.raf.entities;

public class User {
    private Integer id;
    private String username;
    private String name;
    private String hashedPassword;

    public User(String user_username, String user_name, String user_hashedPassword) {
        this.username = user_username;
        this.name = user_name;
        this.hashedPassword = user_hashedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
