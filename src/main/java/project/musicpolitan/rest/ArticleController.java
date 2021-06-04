package project.musicpolitan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.musicpolitan.entities.Article;
import project.musicpolitan.services.ArticleService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/article")
    public ResponseEntity<?> getArticles(){
        List<Article> articles = articleService.getAllArticles();
        for (Article a : articles) {
            a.getUsers().getAuthorities().clear();
        }
        return ResponseEntity.ok(articles);
    }

    @GetMapping(value = "/allarticle")
    public ResponseEntity<?> getAllArticles(){
        List<Article> articles = articleService.getAllArticles();
        for (Article a : articles) {
            a.getUsers().getAuthorities().clear();
        }
        List<Article> new_art = new ArrayList<>();
        for(int i = 0;i<4;i++){
            new_art.add(articles.get(i));
        }
        return ResponseEntity.ok(new_art);
    }

    @PostMapping(value = "/article")
    public ResponseEntity<?> addArticle(@RequestBody Article articles) {
        Article a = articleService.addArticle(articles);
        return ResponseEntity.ok(a);
    }

    @GetMapping(value = "/article/{article_id}")
    public ResponseEntity<?> getArticle(@PathVariable(name = "article_id") Long id) {
        Article articles = articleService.getArticleById(id);
        return ResponseEntity.ok(articles);
    }

    @PutMapping(value = "/article")
    public ResponseEntity<?> editArticle(@RequestBody Article articles) {
        articleService.updateArticle(articles);
        return ResponseEntity.ok(articles);
    }

    @DeleteMapping(value = "/article")
    public ResponseEntity<?> deleteArticle(@RequestBody Article articles) {
        articleService.deleteArticle(articles);
        return ResponseEntity.ok(articles);
    }

    @DeleteMapping(value = "/article/{id}")
    public ResponseEntity<?> deleteArticleById(@PathVariable(name = "id") Long id) {
        Article articles = articleService.getArticleById(id);
        articleService.deleteArticle(articles);
        return ResponseEntity.ok(articles);
    }
}
