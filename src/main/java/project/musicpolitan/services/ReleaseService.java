package project.musicpolitan.services;

import project.musicpolitan.entities.Release;

import java.util.List;

public interface ReleaseService {
    List<Release> getAllReleases();

    Release addRelease(Release release);

    Release getReleaseById(Long id);

    void deleteRelease(Release release);

    void deleteReleaseById(Long id);

    Release updateRelease(Release release);

}
