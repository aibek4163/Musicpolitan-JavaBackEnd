package project.musicpolitan.services;

import project.musicpolitan.entities.Song;

import java.util.List;

public interface SongService {
    List<Song> getAllSongs();

    Song addSong(Song song);

    Song getSongById(Long id);

    void deleteSong(Song song);

    void deleteSongById(Long id);

    Song updateSong(Song song);

}
