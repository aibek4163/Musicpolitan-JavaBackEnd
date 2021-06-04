package project.musicpolitan.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.musicpolitan.entities.Artist;
import project.musicpolitan.repositories.ArtistRepository;
import project.musicpolitan.services.ArtistService;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;


    @Override
    public List<Artist> getAllArtist() {
        return artistRepository.findAll();
    }

    @Override
    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtistById(Long id) {
//        Optional<Artist> album = artistRepository.findById(id);
//        return album.orElse(null);
        return artistRepository.findById(id).get();
    }

    @Override
    public void deleteArtist(Artist artist) {
        artistRepository.delete(artist);
    }

    @Override
    public void deleteArtistById(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Artist updateArtist(Artist artist) {
        return artistRepository.save(artist);
    }
}
