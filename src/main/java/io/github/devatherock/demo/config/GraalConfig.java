package io.github.devatherock.demo.config;

import com.sun.xml.bind.v2.ContextFactory;
import io.micronaut.context.annotation.Factory;
import io.micronaut.core.annotation.ReflectionConfig;
import io.micronaut.core.annotation.ReflectionConfig.ReflectiveMethodConfig;
import io.micronaut.core.annotation.TypeHint.AccessType;

import java.util.Map;

@Factory
@ReflectionConfig(
        type = ContextFactory.class,
        accessType = AccessType.ALL_DECLARED_METHODS,
        methods = {
                @ReflectiveMethodConfig(name = "createContext", parameterTypes = {Class[].class, Map.class})
        }
)
public class GraalConfig {
}
