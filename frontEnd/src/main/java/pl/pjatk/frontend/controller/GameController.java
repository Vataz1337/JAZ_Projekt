package pl.pjatk.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.frontend.model.Game;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Controller
public class GameController {
    WebClient webClient = WebClient.create("http://localhost:8081");
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/games")
    public String displayGames(Model model) {
        Game[] games = webClient
                .get()
                .uri("/games")
                .retrieve()
                .bodyToMono(Game[].class)
                .block();

//        assert games != null;
        List<Game> gamesList = Arrays.asList(games);
        model.addAttribute("games", gamesList);

        return "/games";
    }

    @GetMapping("/games/rpg")
    public String displayRpgGames(Model model) {
        Game[] games = webClient
                .get()
                .uri("/games/rpg")
                .retrieve()
                .bodyToMono(Game[].class)
                .block();

//        assert games != null;
        List<Game> gamesList = Arrays.asList(games);
        model.addAttribute("games", gamesList);

        return "/rpg";
    }

    @PostMapping("/games/add")
    public String submitAddGameForm(@ModelAttribute Game game) {
        webClient.post()
                .uri("/game/add")
                .body(Mono.just(game), Game.class)
                .retrieve()
                .bodyToMono(Long.class)
                .block();

        return "redirect:/games";
    }

    @GetMapping("/games/add")
    public String displayAddGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "gameAddForm";
    }

    @GetMapping("/games/delete")
    public String displayDeleteGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "gameDeleteForm";
    }

    @PostMapping("/games/delete")
    public String submitDeleteGameForm(@ModelAttribute Game game) {
        restTemplate.delete("http://localhost:8081/game/delete/" + game.getId(), Long.class);
        return "redirect:/games";
    }


//    @GetMapping("/games/edit/{id}")
//    public String displayEditGameForm(Model model, @PathVariable long id) {
//        return "editForm";
//    }
//
//    @PostMapping("/games/edit")
//    public String submitEditGameForm(@ModelAttribute Game game) {
//        return "redirect:/games";
//    }
}
