package com.example.ch2labs.labs02;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class DiceController {

    @GetMapping("/dice")
    public Map<String, Integer> rollDice() {
        Random random = new Random();
        int dice = random.nextInt(6) + 1;

        Map<String, Integer> result = new HashMap<>();
        result.put("dice", dice);
        return result;
    }
}
