package rs.raf.repositories.user;

import rs.raf.entities.User;
import rs.raf.repositories.DBAbstractRepo;

public class DBUserRepo extends DBAbstractRepo implements UserRepo {
    @Override
    public User findUser(String username) {
        return null;
    }
}
