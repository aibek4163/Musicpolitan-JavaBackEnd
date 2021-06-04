package project.musicpolitan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.musicpolitan.entities.Comment;

import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByNewsId(Long id);
    List<Comment> findAllByArticleId(Long id);
    List<Comment> findAllByReleaseId(Long id);
    List<Comment> findAllByReviewId(Long id);
}
