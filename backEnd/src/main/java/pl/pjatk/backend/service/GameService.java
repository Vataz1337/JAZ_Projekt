package pl.pjatk.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pjatk.backend.model.Game;
import pl.pjatk.backend.repository.GamesRepository;

import java.util.List;

@Component
public class GameService {
    GamesRepository gamesRepository;

    @Autowired
    public GameService(GamesRepository gamesRepository){
        this.gamesRepository = gamesRepository;
    }

    public List<Game> getGamesFromRepo(){
        return gamesRepository.findAll();
    }
}
