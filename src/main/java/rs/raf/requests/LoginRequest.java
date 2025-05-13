package rs.raf.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginRequest {

    @NotNull(message = "Username is required")
    @NotEmpty(message = "Username is required")
    private String username;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
