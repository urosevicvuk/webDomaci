package rs.raf.repositories.user;

import rs.raf.entities.User;

public interface UserRepository {
    User findUser(String username);
}
