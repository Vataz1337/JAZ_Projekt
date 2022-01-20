package pl.pjatk.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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

    //public ResponseEntity<List<Car>> getCars() {
    //    List<Car> cars = carService.getCarsFromRepo();
    //    return new ResponseEntity<>(cars, HttpStatus.OK);
    //}
}
