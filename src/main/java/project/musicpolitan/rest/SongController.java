package project.musicpolitan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.musicpolitan.entities.Song;
import project.musicpolitan.services.SongService;

import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping(value = "/song")
    public ResponseEntity<?> getAllSongs(){
        List<Song> songs = songService.getAllSongs();
        songs.sort(Comparator.comparing(Song::getRating));
        return ResponseEntity.ok(songs);
    }

    @PostMapping(value = "/song")
    public ResponseEntity<?> addSong(@RequestBody Song songs) {
        Song s = songService.addSong(songs);
        return ResponseEntity.ok(s);
    }

    @GetMapping(value = "/song/{song_id}")
    public ResponseEntity<?> getSong(@PathVariable(name = "song_id") Long id) {
        Song songs = songService.getSongById(id);
        return ResponseEntity.ok(songs);
    }

    @PutMapping(value = "/song")
    public ResponseEntity<?> editSong(@RequestBody Song songs) {
        songService.updateSong(songs);
        return ResponseEntity.ok(songs);
    }

    @DeleteMapping(value = "/song")
    public ResponseEntity<?> deleteSong(@RequestBody Song songs) {
        songService.deleteSong(songs);
        return ResponseEntity.ok(songs);
    }

    @DeleteMapping(value = "/song/{id}")
    public ResponseEntity<?> deleteSongById(@PathVariable(name = "id") Long id) {
        Song songs = songService.getSongById(id);
        songService.deleteSong(songs);
        return ResponseEntity.ok(songs);
    }
}
