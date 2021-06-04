package project.musicpolitan.services;

import project.musicpolitan.entities.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();

    Genre addGenre(Genre genre);

    Genre getGenreById(Long id);

    void deleteGenre(Genre genre);

    void deleteGenreById(Long id);

    Genre updateGenre(Genre genre);

}
