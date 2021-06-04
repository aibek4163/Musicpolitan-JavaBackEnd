package project.musicpolitan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.musicpolitan.entities.Article;

@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
