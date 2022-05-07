package io.github.devatherock.demo.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import jakarta.inject.Singleton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Singleton
@ConfigurationProperties("demo")
public class DemoAppConfig {
    private String username;
}
