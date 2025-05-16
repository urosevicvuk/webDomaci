package rs.raf.repositories.user;

import rs.raf.entities.Post;
import rs.raf.entities.User;
import rs.raf.repositories.DBAbstractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUserRepository extends DBAbstractRepository implements UserRepository {
    @Override
    public User findUser(String username) {
        User user = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM user where user_username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_username"),
                        resultSet.getString("user_hashedPassword"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return user;
    }
}
