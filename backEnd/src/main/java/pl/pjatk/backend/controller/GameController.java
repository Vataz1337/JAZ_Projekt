package pl.pjatk.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.backend.model.Game;
import pl.pjatk.backend.service.GameService;

import java.util.List;

@RestController
public class GameController {
    GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getGames(){
        List<Game> games = gameService.getGamesFromRepo();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<Game> getGame(@PathVariable long id) {
        Game game = gameService.getGameFromRepo(id);

        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @PostMapping("/game/add")
    public ResponseEntity<Long> createGame(@RequestBody Game game) {
        long createdId = gameService.insertGameIntoRepo(game);

        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }
}
