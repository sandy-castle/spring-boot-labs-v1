package com.example.ch2labs.labs01;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalcController {

    @GetMapping("/labs01/calc")
    public String calculate(
            @RequestParam int x,
            @RequestParam int y,
            @RequestParam String op
    ) {
        int result = 0;
        String symbol = "";

        switch (op) {
            case "add":
                result = x + y;
                symbol = "+";
                break;
            case "sub":
                result = x - y;
                symbol = "-";
                break;
            case "mul": // ← 이게 있어야 해!
                result = x * y;
                symbol = "*";
                break;
            case "div":
                if (y == 0) return "0으로 나눌 수 없습니다";
                result = x / y;
                symbol = "/";
                break;
            default:
                return "지원하지 않는 연산입니다";
        }

        return String.format("결과: %d %s %d = %d", x, symbol, y, result);
    }
}
