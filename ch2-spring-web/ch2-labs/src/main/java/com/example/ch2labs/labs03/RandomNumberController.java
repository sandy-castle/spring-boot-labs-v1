package com.example.ch2labs.labs03;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class RandomNumberController {

    @GetMapping("/random")
    public Map<String, Integer> getRandomNumber(
            @RequestParam int min,
            @RequestParam int max
    ) {
        Random random = new Random();
        int number = random.nextInt(max - min + 1) + min;

        Map<String, Integer> result = new HashMap<>();
        result.put("number", number);
        return result;
    }
}
