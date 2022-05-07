package io.github.devatherock.demo.controller;

import java.util.Collections;
import java.util.Map;

import io.github.devatherock.demo.config.DemoAppConfig;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HelloController {
    private final DemoAppConfig config;

    @Get("/hello")
    public Map<String, String> sayHello() {
        return Collections.singletonMap("message", "Hello, " + config.getUsername());
    }
}
