package project.musicpolitan.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.musicpolitan.entities.Comment;
import project.musicpolitan.repositories.CommentRepository;
import project.musicpolitan.services.CommentService;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElse(null);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentByNewsId(Long id) {
        return commentRepository.findAllByNewsId(id);
    }

    @Override
    public List<Comment> getCommentByReleaseId(Long id) {
        return commentRepository.findAllByReleaseId(id);
    }

    @Override
    public List<Comment> getCommentByReviewId(Long id) {
        return commentRepository.findAllByReviewId(id);
    }

    @Override
    public List<Comment> getCommentByArticleId(Long id) {
        return commentRepository.findAllByArticleId(id);
    }
}
