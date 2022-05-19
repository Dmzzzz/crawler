package com.crawler.crawler.examplecontroller.work3;

import com.crawler.crawler.examplecontroller.work2.GroupRestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonBasedMenuRegistry implements MenuRegistry {

    @Override
    public List<MenuConfiguration> createMenuConfiguration() {
        Path path = Paths.get("src", "main", "resources", "json", "groupandlinks.json");

        List<MenuConfiguration> menuConfigurations = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            menuConfigurations.addAll(Arrays.asList(
                    objectMapper.readValue(new FileInputStream(path.toFile()), MenuConfiguration[].class)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return menuConfigurations;
    }
}