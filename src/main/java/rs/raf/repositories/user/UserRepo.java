package rs.raf.repositories.user;

import rs.raf.entities.User;

public interface UserRepo {
    User findUser(String username);
}
