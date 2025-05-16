package rs.raf.repositories.comment;

import rs.raf.entities.Comment;
import rs.raf.entities.Post;
import rs.raf.repositories.DBAbstractRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCommentRepository extends DBAbstractRepository implements CommentRepository {
    @Override
    public Comment addComment(Comment comment, Integer postId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("INSERT INTO comment (comment_author, comment_text, comment_post, comment_user) VALUES (?, ?, ?, ?)", generatedColumns);
            preparedStatement.setString(1, comment.getAuthor());
            preparedStatement.setString(2, comment.getText());
            preparedStatement.setInt(3, postId);
            preparedStatement.setInt(4, 1);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                comment.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return comment;
    }

    @Override
    public List<Comment> getAllComments(Integer postId) {
        List<Comment> comments = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM comment WHERE comment_post = ?");
            preparedStatement.setInt(1, postId);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                comments.add(new Comment(
                        resultSet.getInt("comment_id"),
                        resultSet.getString("comment_author"),
                        resultSet.getString("comment_text"),
                        resultSet.getInt("comment_post"),
                        resultSet.getInt("comment_user")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return comments;
    }
}
