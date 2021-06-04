package project.musicpolitan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.musicpolitan.entities.Artist;
import project.musicpolitan.services.ArtistService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping(value = "/artist")
    public ResponseEntity<?> getAllArtists(){
        List<Artist> artist = artistService.getAllArtist();
        return ResponseEntity.ok(artist);
    }

    @PostMapping(value = "/artist")
    public ResponseEntity<?> addArtist(@RequestBody Artist artist) {
        Artist a = artistService.addArtist(artist);
        return ResponseEntity.ok(a);
    }

    @GetMapping(value = "/artist/{artist_id}")
    public ResponseEntity<?> getArtist(@PathVariable(name = "artist_id") Long id) {
        System.out.println(id);
        Artist artist = artistService.getArtistById(id);
        System.out.println(artist);
        return ResponseEntity.ok(artist);
    }

    @PutMapping(value = "/artist")
    public ResponseEntity<?> editArtist(@RequestBody Artist artist) {
        artistService.updateArtist(artist);
        return ResponseEntity.ok(artist);
    }

    @DeleteMapping(value = "/artist")
    public ResponseEntity<?> deleteArtist(@RequestBody Artist artist) {
        artistService.deleteArtist(artist);
        return ResponseEntity.ok(artist);
    }

    @DeleteMapping(value = "/artist/{id}")
    public ResponseEntity<?> deleteArtistById(@PathVariable(name = "id") Long id) {
        Artist artist = artistService.getArtistById(id);
        artistService.deleteArtist(artist);
        return ResponseEntity.ok(artist);
    }
}
