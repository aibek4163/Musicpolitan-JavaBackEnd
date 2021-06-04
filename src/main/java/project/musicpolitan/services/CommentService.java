package project.musicpolitan.services;

import project.musicpolitan.entities.Artist;
import project.musicpolitan.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();

    Comment addComment(Comment comment);

    Comment getCommentById(Long id);

    void deleteComment(Comment comment);

    void deleteCommentById(Long id);

    Comment updateComment(Comment comment);

    List<Comment> getCommentByNewsId(Long id);

    List<Comment> getCommentByReleaseId(Long id);

    List<Comment> getCommentByReviewId(Long id);

    List<Comment> getCommentByArticleId(Long id);
}
