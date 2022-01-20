package pl.pjatk.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.pjatk.frontend.model.Game;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Controller
public class GameController {
    WebClient webClient = WebClient.create("http://localhost:8081");

    @GetMapping("/games")
    public String displayGames(Model model) {
        Game[] games = webClient
                .get()
                .uri("/games")
                .retrieve()
                .bodyToMono(Game[].class)
                .block();

        assert games != null;
        List<Game> gameList = Arrays.asList(games);
        model.addAttribute("games", gameList);

        return "games";
    }
}
