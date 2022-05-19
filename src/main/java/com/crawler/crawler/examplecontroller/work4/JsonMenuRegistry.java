package com.crawler.crawler.examplecontroller.work4;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonMenuRegistry implements MenuRegistry{
    @Override
    public MenuConfiguration createMenuConfiguration() {

        final Path path = Paths.get("json","work4.json");
        final MenuConfiguration menuConfigurations;
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        JavaType type = objectMapper.getTypeFactory().constructParametrizedType(MenuConfiguration.class, List.class, GroupMenu.class);

        try (final InputStream inputStream = JsonMenuRegistry.class.getClassLoader()
                                                                        .getResourceAsStream(path.toString())) {

            menuConfigurations = objectMapper.readValue(inputStream, type);
        } catch (final Exception e) {
            throw new RuntimeException(String.format("Не смогли прочитать Menu из Json'a %s", path.toFile()), e);
        }

        return menuConfigurations;


    }
}
