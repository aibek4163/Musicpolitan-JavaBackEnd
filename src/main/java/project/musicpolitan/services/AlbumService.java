package project.musicpolitan.services;

import project.musicpolitan.entities.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbums();

    Album addAlbum(Album album);

    Album getAlbumById(Long id);

    void deleteAlbum(Album album);

    void deleteAlbumById(Long id);

    Album updateAlbum(Album album);

}
