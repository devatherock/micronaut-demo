package io.github.devatherock.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import io.micronaut.context.env.PropertySource;
import io.micronaut.context.env.yaml.YamlPropertySourceLoader;
import io.micronaut.core.io.ResourceLoader;
import io.micronaut.core.io.file.DefaultFileSystemResourceLoader;
import io.micronaut.runtime.Micronaut;

public class Application {
    private static final String PROP_CONFIG_LOCATION = "demo.config.path";

    public static void main(String[] args) throws IOException {
        if (System.getProperty(PROP_CONFIG_LOCATION) != null) {
            List<PropertySource> propertySources = new ArrayList<>();
            YamlPropertySourceLoader propertySourceLoader = new YamlPropertySourceLoader();
            ResourceLoader resourceLoader = new DefaultFileSystemResourceLoader();

            Files.newDirectoryStream(Paths.get(System.getProperty(PROP_CONFIG_LOCATION))).forEach(file -> {
                String fileName = file.toString();
                String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
                propertySourceLoader.load(fileNameWithoutExtension, resourceLoader).ifPresent(propertySources::add);
            });

            Micronaut.build(args)
                    .classes(Application.class)
                    .propertySources(propertySources.toArray(new PropertySource[1]))
                    .start();
        } else {
            Micronaut.run(Application.class, args);
        }
    }
}
