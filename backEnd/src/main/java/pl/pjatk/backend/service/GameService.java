package pl.pjatk.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pjatk.backend.exeptions.GameAlreadyExistsException;
import pl.pjatk.backend.exeptions.GameNotFoundException;
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

    public Game getGameFromRepo(long id) {
        Game game = gamesRepository.findById(id);

        if (game == null) {
            throw new GameNotFoundException();
        }

        return game;
    }

    public long insertGameIntoRepo(Game game) {
        if (gamesRepository.existsById(game.getId())) {
            throw new GameAlreadyExistsException();
        }
        return gamesRepository.save(game).getId();
    }
}
