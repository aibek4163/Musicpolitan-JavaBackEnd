package project.musicpolitan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import project.musicpolitan.entities.News;
import project.musicpolitan.entities.Users;
import project.musicpolitan.models.UserDTO;
import project.musicpolitan.models.UserPassword;
import project.musicpolitan.services.NewsService;
import project.musicpolitan.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class MainRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    //users
    @GetMapping(value = "/profile")
    public ResponseEntity<?> profilePage() {
        Users user = getUser();
        return new ResponseEntity<>(new UserDTO(user.getId(), user.getEmail(), user.getFullName(), user.getAvatar(), user.getRoles()), HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<?> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (Users u : users) {
            userDTOS.add(new UserDTO(u.getId(), u.getEmail(), u.getFullName(), u.getAvatar(), u.getRoles()));
        }
        System.out.println(userDTOS);
        return ResponseEntity.ok(userDTOS);
    }

    @GetMapping(value = "/users/{user_id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "user_id") Long id) {
        Users user = userService.getUserById(id);
        return new ResponseEntity<>(new UserDTO(user.getId(), user.getEmail(), user.getFullName(), user.getAvatar(), user.getRoles()), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody Users users) {
        System.out.println(users);
        Users user = userService.addUser(users);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

    private Users getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            Users user = (Users) authentication.getPrincipal();
            return user;
        }
        return null;
    }

    //News
    @PostMapping(value = "/news")
    public ResponseEntity<?> addNews(@RequestBody News news) {
        News n = newsService.addNews(news);
        return ResponseEntity.ok(n);
    }

    @GetMapping(value = "/news")
    public ResponseEntity<?> getFreshNews() {
        List<News> news = newsService.getFreshNews();
        List<News> new_news = new ArrayList<>();
        for(int i = 0;i<8;i++){
            new_news.add(news.get(i));
        }
        return ResponseEntity.ok(new_news);
    }

    @GetMapping(value = "/allnews")
    public ResponseEntity<?> getAllNews() {
        List<News> news = newsService.getFreshNews();
        return ResponseEntity.ok(news);
    }

    @GetMapping(value = "/news/{news_id}")
    public ResponseEntity<?> getNews(@PathVariable(name = "news_id") Long id) {
        News news = newsService.getNewsById(id);
        return ResponseEntity.ok(news);
    }

    @PutMapping(value = "/news")
    public ResponseEntity<?> editNews(@RequestBody News news) {
        newsService.updateNews(news);
        return ResponseEntity.ok(news);
    }

    @DeleteMapping(value = "/news")
    public ResponseEntity<?> deleteNews(@RequestBody News news) {
        newsService.deleteNews(news);
        return ResponseEntity.ok(news);
    }

    @DeleteMapping(value = "/news/{id}")
    public ResponseEntity<?> deleteNewsById(@PathVariable(name = "id") Long id) {
        News news = newsService.getNewsById(id);
        newsService.deleteNews(news);
        return ResponseEntity.ok(news);
    }

    @PutMapping(value = "/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody Users user) {
        System.out.println(user);
        Users users = userService.getUserByEmail(user.getEmail());
        users.setFullName(user.getFullName());
        userService.updateUser(users);
        return ResponseEntity.ok(user);
    }


    @PutMapping(value = "/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody UserPassword user) {
        System.out.println(user + "  password");
        Users users = userService.getUserByEmail(user.getEmail());
        users = userService.changePassword(users, user.getPassword(), user.getNewPassword(), user.getRePassword());
        if (users != null) {
            userService.updateUser(users);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/searchCard/{name}")
    public ResponseEntity<?> searchCard(@PathVariable String name) {
        List<News> news = newsService.findAllByTitleContaining(name);
        if (news == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(news);
    }
}
