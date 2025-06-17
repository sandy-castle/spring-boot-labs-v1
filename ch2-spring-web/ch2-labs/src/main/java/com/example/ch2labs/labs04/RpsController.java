package com.example.ch2labs.labs04;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class RpsController {

    private static final List<String> choices = Arrays.asList("rock", "paper", "scissors");

    @GetMapping("/rps")
    public Map<String, String> playRps(@RequestParam String user) {
        Random random = new Random();
        String server = choices.get(random.nextInt(3));

        String result;
        if (user.equals(server)) {
            result = "Draw!";
        } else if (
                (user.equals("rock") && server.equals("scissors")) ||
                        (user.equals("scissors") && server.equals("paper")) ||
                        (user.equals("paper") && server.equals("rock"))
        ) {
            result = "You Win!";
        } else {
            result = "You Lose!";
        }

        Map<String, String> response = new HashMap<>();
        response.put("user", user);
        response.put("server", server);
        response.put("result", result);

        return response;
    }
}
