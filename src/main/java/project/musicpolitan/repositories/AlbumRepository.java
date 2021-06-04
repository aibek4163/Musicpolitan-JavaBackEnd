package project.musicpolitan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.musicpolitan.entities.Album;

@Repository
@Transactional
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
