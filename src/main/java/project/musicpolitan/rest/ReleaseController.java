package project.musicpolitan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.musicpolitan.entities.Release;
import project.musicpolitan.services.ReleaseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class ReleaseController {
    @Autowired
    private ReleaseService releaseService;

    @GetMapping(value = "/release")
    public ResponseEntity<?> getAllReleases(){
        List<Release> releases = releaseService.getAllReleases();
        return ResponseEntity.ok(releases);
    }

    @PostMapping(value = "/release")
    public ResponseEntity<?> addRelease(@RequestBody Release release) {
        Release r = releaseService.addRelease(release);
        return ResponseEntity.ok(r);
    }

    @GetMapping(value = "/release/{release_id}")
    public ResponseEntity<?> getRelease(@PathVariable(name = "release_id") Long id) {
        Release release = releaseService.getReleaseById(id);
        return ResponseEntity.ok(release);
    }

    @PutMapping(value = "/release")
    public ResponseEntity<?> editRelease(@RequestBody Release release) {
        System.out.println(release);
        releaseService.updateRelease(release);
        return ResponseEntity.ok(release);
    }

    @DeleteMapping(value = "/release")
    public ResponseEntity<?> deleteRelease(@RequestBody Release release) {
        releaseService.deleteRelease(release);
        return ResponseEntity.ok(release);
    }

    @DeleteMapping(value = "/release/{id}")
    public ResponseEntity<?> deleteReleaseById(@PathVariable(name = "id") Long id) {
        Release release = releaseService.getReleaseById(id);
        releaseService.deleteRelease(release);
        return ResponseEntity.ok(release);
    }
}
