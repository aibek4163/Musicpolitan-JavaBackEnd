package project.musicpolitan.services;

import project.musicpolitan.entities.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> getAllArtist();

    Artist addArtist(Artist artist);

    Artist getArtistById(Long id);

    void deleteArtist(Artist artist);

    void deleteArtistById(Long id);

    Artist updateArtist(Artist artist);

}
