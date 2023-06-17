package com.example.docker1;

import com.google.common.hash.Hashing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class Controller {
    @GetMapping("/messages")
    public String getMessage() {
        String sha = Hashing.sha256().hashString("Hello from docker", StandardCharsets.UTF_8).toString();
        return sha + "    " + "Hello from docker" + "    " + Hashing.sha256().hashString("Hello from docker", StandardCharsets.UTF_8).toString();
    }
}
