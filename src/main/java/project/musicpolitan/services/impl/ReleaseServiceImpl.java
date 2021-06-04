package project.musicpolitan.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.musicpolitan.entities.Release;
import project.musicpolitan.repositories.ReleaseRepository;
import project.musicpolitan.services.ReleaseService;

import java.util.List;
import java.util.Optional;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    public List<Release> getAllReleases() {
        return releaseRepository.findAll();
    }

    @Override
    public Release addRelease(Release release) {
        return releaseRepository.save(release);
    }

    @Override
    public Release getReleaseById(Long id) {
        Optional<Release> release = releaseRepository.findById(id);
        return release.orElse(null);
    }

    @Override
    public void deleteRelease(Release release) {
        releaseRepository.delete(release);
    }

    @Override
    public void deleteReleaseById(Long id) {
        releaseRepository.deleteById(id);
    }

    @Override
    public Release updateRelease(Release release) {
        return releaseRepository.save(release);
    }
}
