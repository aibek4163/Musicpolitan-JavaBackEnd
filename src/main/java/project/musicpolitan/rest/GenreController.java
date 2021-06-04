package project.musicpolitan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.musicpolitan.entities.Genre;
import project.musicpolitan.services.GenreService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping(value = "/genre")
    public ResponseEntity<?> getAllGenres(){
        List<Genre> genres = genreService.getAllGenres();
        return ResponseEntity.ok(genres);
    }

    @PostMapping(value = "/genre")
    public ResponseEntity<?> addGenre(@RequestBody Genre genres) {
        Genre s = genreService.addGenre(genres);
        return ResponseEntity.ok(s);
    }

    @GetMapping(value = "/genre/{genre_id}")
    public ResponseEntity<?> getGenre(@PathVariable(name = "genre_id") Long id) {
        Genre genres = genreService.getGenreById(id);
        return ResponseEntity.ok(genres);
    }

    @PutMapping(value = "/genre")
    public ResponseEntity<?> editGenre(@RequestBody Genre genres) {
        genreService.updateGenre(genres);
        return ResponseEntity.ok(genres);
    }

    @DeleteMapping(value = "/genre")
    public ResponseEntity<?> deleteGenre(@RequestBody Genre genres) {
        genreService.deleteGenre(genres);
        return ResponseEntity.ok(genres);
    }

    @DeleteMapping(value = "/genre/{id}")
    public ResponseEntity<?> deleteGenreById(@PathVariable(name = "id") Long id) {
        Genre genres = genreService.getGenreById(id);
        genreService.deleteGenre(genres);
        return ResponseEntity.ok(genres);
    }
}
