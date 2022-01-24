package java10_java_database.lesson13_repository_pattern;

import java10_java_database.lesson03_data_source.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    @Override
    public void insert(Comment comment) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "INSERT INTO comments(email, comment) VALUES(?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, comment.getEmail());
                preparedStatement.setString(2, comment.getComment());
                preparedStatement.executeUpdate();

                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        comment.setId(resultSet.getInt(1));
                    }
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Comment findById(Integer id) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Comment(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        );
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Comment> findAll() {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    List<Comment> comments = new ArrayList<>();

                    while (resultSet.next()) {
                        comments.add(new Comment(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        ));
                    }

                    return comments;
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
