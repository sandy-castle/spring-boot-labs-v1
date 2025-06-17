package com._05_validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validation")
public class UserController {

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user)
    {
        ResponseEntity<String> ResponseEntity = null;
        return null;
    }
}
