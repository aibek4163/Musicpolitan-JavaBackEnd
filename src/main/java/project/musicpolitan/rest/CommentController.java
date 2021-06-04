package project.musicpolitan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.musicpolitan.entities.Comment;
import project.musicpolitan.services.CommentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/comment")
    public ResponseEntity<?> getAllComments(){
        List<Comment> comment = commentService.getAllComment();
        return ResponseEntity.ok(comment);
    }

    @GetMapping(value = "/news_comment/{news_id}")
    public ResponseEntity<?> getAllCommentsByNews(@PathVariable(name = "news_id") Long id){
        List<Comment> comment = commentService.getCommentByNewsId(id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping(value = "/release_comment/{release_id}")
    public ResponseEntity<?> getAllCommentsByRelease(@PathVariable(name = "release_id") Long id){
        List<Comment> comment = commentService.getCommentByReleaseId(id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping(value = "/review_comment/{review_id}")
    public ResponseEntity<?> getAllCommentsByReview(@PathVariable(name = "review_id") Long id){
        List<Comment> comment = commentService.getCommentByReviewId(id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping(value = "/article_comment/{article_id}")
    public ResponseEntity<?> getAllCommentsByArticle(@PathVariable(name = "article_id") Long id){
        List<Comment> comment = commentService.getCommentByArticleId(id);
        return ResponseEntity.ok(comment);
    }

    @PostMapping(value = "/comment")
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        Comment a = commentService.addComment(comment);
        return ResponseEntity.ok(a);
    }

    @GetMapping(value = "/comment/{comment_id}")
    public ResponseEntity<?> getComment(@PathVariable(name = "comment_id") Long id) {
        System.out.println(id);
        Comment comment = commentService.getCommentById(id);
        System.out.println(comment);
        return ResponseEntity.ok(comment);
    }

    @PutMapping(value = "/comment")
    public ResponseEntity<?> editComment(@RequestBody Comment comment) {
        commentService.updateComment(comment);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping(value = "/comment")
    public ResponseEntity<?> deleteComment(@RequestBody Comment comment) {
        commentService.deleteComment(comment);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping(value = "/comment/{id}")
    public ResponseEntity<?> deleteCommentById(@PathVariable(name = "id") Long id) {
        Comment comment = commentService.getCommentById(id);
        commentService.deleteComment(comment);
        return ResponseEntity.ok(comment);
    }
}
