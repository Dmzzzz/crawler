package com.crawler.crawler.examplecontroller.work2;

import com.crawler.crawler.examplecontroller.work.NavigatorRestGroupDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NavigatorParserMain {


    public static void main(String[] args) throws JsonProcessingException {
        String pathOfJson = "src/main/resources/json/groupandlinks.json";
        Path path = Paths.get("src", "main", "resources", "json", "groupandlinks.json");
        String jsonString = "";
 /*       try {
            jsonString = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        List<GroupRestDTO> navigatorRestGroupDTOList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile())))) {
            navigatorRestGroupDTOList.addAll(Arrays.asList(objectMapper.readValue(br, GroupRestDTO[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }

/*        try {
       navigatorRestGroupDTOList.addAll(Arrays.asList(
                    objectMapper.readValue(new FileInputStream(path.toFile()), GroupRestDTO[].class)));

        } catch (IOException e) {
            e.printStackTrace();
        }*/

/*        List<GroupRestDTO> navigatorRestGroupDTOList = Arrays.asList(
                objectMapper.readValue(jsonString, GroupRestDTO[].class));*/


        System.out.println(navigatorRestGroupDTOList);
    }

}
