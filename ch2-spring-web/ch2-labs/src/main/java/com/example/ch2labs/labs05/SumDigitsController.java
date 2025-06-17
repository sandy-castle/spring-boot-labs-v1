package com.example.ch2labs.labs05;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class SumDigitsController {

    @GetMapping("/sum-digits")
    public ResponseEntity<?> sumDigits(@RequestParam(required = false) String number) {

        // 1. 누락 검사
        if (number == null || number.isBlank()) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "number 파라미터는 필수입니다.")
            );
        }

        // 2. 정수 형식 검사
        if (!number.matches("\\d+")) {
            return ResponseEntity.unprocessableEntity().body(
                    Map.of("error", "정수만 입력 가능합니다. 예: /sum-digits?number=1234")
            );
        }

        // 3. 음수 검사 (위에서 숫자만 받도록 했기 때문에 추가 확인은 생략 가능)
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                return ResponseEntity.badRequest().body(
                        Map.of("error", "음수는 지원하지 않습니다. 양의 정수를 입력해주세요.")
                );
            }

            int sum = 0;
            for (char c : number.toCharArray()) {
                sum += c - '0'; // 문자 숫자를 정수로 변환
            }

            return ResponseEntity.ok(
                    Map.of("message", "각 자리수 합: " + sum)
            );

        } catch (NumberFormatException e) {
            return ResponseEntity.unprocessableEntity().body(
                    Map.of("error", "정수만 입력 가능합니다. 예: /sum-digits?number=1234")
            );
        }
    }
}
