package rs.raf.repositories;

import java.sql.*;
import java.util.Optional;

abstract public class DBAbstractRepository {
    public DBAbstractRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection newConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://" + this.getHost() + ":" + this.getPort() + "/" + this.getDatabaseName(), this.getUsername(), this.getPassword()
        );
    }

    protected String getHost() {
        return "localhost";
    }

    protected int getPort() {
        return 3306;
    }

    protected String getDatabaseName() {
        return "webHomework";
    }

    protected String getUsername() {
        return "webhm_user";
    }

    protected String getPassword() {
        return "2301";
    }

    protected void closeStatement(Statement statement) {
        if (statement == null) {
            return;
        }
        try {
            Optional.of(statement).get().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void closeResultSet(ResultSet resultSet) {
        if (resultSet == null) {
            return;
        }
        try {
            Optional.of(resultSet).get().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            Optional.of(connection).get().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
