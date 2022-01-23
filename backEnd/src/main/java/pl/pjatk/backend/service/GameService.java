package pl.pjatk.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pjatk.backend.exeptions.GameAlreadyExistsException;
import pl.pjatk.backend.exeptions.GameNotFoundException;
import pl.pjatk.backend.model.Game;
import pl.pjatk.backend.repository.GamesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<Game> getRPGGamesFromRepo(){
        List<Game> rpgGames = new ArrayList<>();
        for(Game game: gamesRepository.findAll()){
            if(Objects.equals(game.getGenre(), "RPG")){
                rpgGames.add(game);
            }
        }
        return rpgGames;
    }

    public Game getGameFromRepo(long id) {
        Game game = gamesRepository.findById(id);

        if (game == null) {
            throw new GameNotFoundException();
        }

        return game;
    }

    public long insertGameIntoRepo(Game game) {
        if (gamesRepository.existsById(game.getId())){
            throw new GameAlreadyExistsException();
        }
      return gamesRepository.save(game).getId();
    }

    public long removeGameFromRepo(long id) {
        if (gamesRepository.existsById(id)) {
            gamesRepository.deleteById(id);

            return id;
        } else {
            throw new GameNotFoundException();
        }
    }

//    public long updateGameInRepo(Game game) {
//        Game repGame = gamesRepository.findById(game.getId());
//
//        if (repGame != null) {
//            repGame.setName(game.getName());
//            repGame.setGenre(game.getGenre());
//            repGame.setPrice(game.getPrice());
//            repGame.setDescription(game.getDescription());
//            return gamesRepository.save(repGame).getId();
//        } else {
//            throw new GameNotFoundException();
//        }
//    }
}
