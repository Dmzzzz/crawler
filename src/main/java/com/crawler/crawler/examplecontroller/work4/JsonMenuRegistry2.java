package com.crawler.crawler.examplecontroller.work4;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonMenuRegistry2 implements MenuRegistry{
    @Override
    public MenuConfiguration createMenuConfiguration() {
        MenuConfiguration menuConfiguration = new MenuConfiguration();
        final Path path = Paths.get("json","work4.json");
        final ObjectMapper objectMapper = new ObjectMapper();
        List<GroupMenu> groupMenuList = new ArrayList<>();

        try(InputStream is = JsonMenuRegistry2.class.getClassLoader().getResourceAsStream(path.toString())) {
                    groupMenuList.addAll(Arrays.asList(objectMapper.readValue(is, GroupMenu[].class)));
        } catch (IOException e) {
            throw new RuntimeException(String.format("Не смогли прочитать Menu из Json'a %s", path.toFile()), e);
        }
         menuConfiguration.setGroupMenus(groupMenuList);

        return menuConfiguration;
    }
}