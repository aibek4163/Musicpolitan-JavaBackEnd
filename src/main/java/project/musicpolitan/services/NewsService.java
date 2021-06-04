package project.musicpolitan.services;

import project.musicpolitan.entities.News;

import java.util.List;

public interface NewsService {
    List<News> getFreshNews();

    List<News> getAllNews();

    News addNews(News news);

    News getNewsById(Long id);

    void deleteNews(News news);

    void deleteNewsById(Long id);

    News updateNews(News news);

    List<News> findAllByTitleContaining(String name);

}
