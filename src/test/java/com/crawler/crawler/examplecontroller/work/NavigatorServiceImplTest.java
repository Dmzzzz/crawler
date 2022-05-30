package com.crawler.crawler.examplecontroller.work;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class NavigatorServiceImplTest {

    MenuGenerator menuGenerator = new MenuGenerator();
    MenuRegistry menuRegistry = new JsonBasedMenuRegistry();

    @Test
    void when_have_1_perm_then_return_1group() {
        List<String> permissions = new ArrayList<String>() {{
            add("doc:payment:su:recall");
        }};

        MenuConfiguration menuConfiguration = menuRegistry.createMenuConfiguration();
        List<GroupMenu> groupMenuDTOS =
                menuGenerator.generateMenu3(menuConfiguration.getGroupMenu(), permissions);

        System.out.println(groupMenuDTOS);



        Set<GroupMenu> collect1 = groupMenuDTOS.stream()
                .collect(Collectors.toSet());

        System.out.println(collect1.size());


        System.out.println(groupMenuDTOS.size());

    }

}