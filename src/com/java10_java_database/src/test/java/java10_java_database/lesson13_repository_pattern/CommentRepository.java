package java10_java_database.lesson13_repository_pattern;

import java.util.List;

public interface CommentRepository {
    void insert(Comment comment);
    Comment findById(Integer id);
    List<Comment> findAll();
}
