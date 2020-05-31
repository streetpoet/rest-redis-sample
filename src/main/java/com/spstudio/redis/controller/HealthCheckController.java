package com.spstudio.redis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class HealthCheckController {

    @GetMapping("/health-check.html")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("service is running");
    }
}
