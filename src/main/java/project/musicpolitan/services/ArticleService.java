package project.musicpolitan.services;

import project.musicpolitan.entities.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();

    Article addArticle(Article article);

    Article getArticleById(Long id);

    void deleteArticle(Article article);

    void deleteArticleById(Long id);

    Article updateArticle(Article article);

}
