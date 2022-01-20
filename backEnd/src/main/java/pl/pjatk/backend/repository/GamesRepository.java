package pl.pjatk.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjatk.backend.model.Game;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Game, Long> {
    Game findById(long id);
    List<Game> findAll();
}
