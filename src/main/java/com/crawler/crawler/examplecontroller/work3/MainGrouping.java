package com.crawler.crawler.examplecontroller.work3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainGrouping {

    public static void main(String[] args) {

        List<MenuConfiguration> menuConfigurationsList = new ArrayList<>();

        /**
         * menuConfiguration состоит из 2х групп
         * Операционная касса                Продуктовый учёт
         * 2 link  extadition reception       1 link  Operation with BR
         * 1      2                                2
         *
         */

        List<LinkConfiguration> linkConfigurationList = new ArrayList<>();

        LinkConfiguration l1 = new LinkConfiguration(
                6L,
                "Контроль выдачи",
                "INTERNAL",
                "url111",
                Stream.of("aaa", "bbb").collect(Collectors.toList()));

        LinkConfiguration l2 = new LinkConfiguration(
                7L,
                "Контроль приёма",
                "INTERNAL",
                "url222",
                Stream.of("aaa2", "ddd").collect(Collectors.toList()));

        linkConfigurationList.add(l1);
        linkConfigurationList.add(l2);

        LinkConfiguration l3 = new LinkConfiguration(
                17L,
                "Операции с Банком Росии",
                "INTERNAL",
                "url33",
                Stream.of("ууу", "def").collect(Collectors.toList()));
        List<LinkConfiguration> linkConfigurationList2 = new ArrayList<>();
        linkConfigurationList2.add(l3);

        MenuConfiguration menu = new MenuConfiguration(3, "Операционная касса",
                "1iconCode", linkConfigurationList);

        MenuConfiguration menu2 = new MenuConfiguration(4, "Продуктовый учёт",
                "2iconCode", linkConfigurationList2);

        menuConfigurationsList.add(menu);
        menuConfigurationsList.add(menu2);

        List<String> permissions = Stream.of("aaa", "def").collect(Collectors.toList());

/*
        menuConfigurationsList.stream()
                .collect(Collectors.groupingBy(menucfg -> menucfg.getLinkConfigurationList().stream()
                .collect(Collectors.toList()).stream().map(LinkConfiguration::getPermissions).));*/

        Map<String, MenuConfiguration> groupingMap = new HashMap<>();

        List<MenuConfiguration> resultList = new ArrayList<>();

        for (MenuConfiguration m : menuConfigurationsList) {
            for (LinkConfiguration l : m.getLinkConfigurationList()) {
                for (String perm : l.getPermissions()) {
                    groupingMap.put(perm, m);
                }
            }
        }

        for (String perm : permissions) {
            for (Map.Entry<String, MenuConfiguration> entry : groupingMap.entrySet()) {

                if (entry.getKey().equals(perm)) {
                    List<LinkConfiguration> resultCfgList = new ArrayList<>();
                    for (LinkConfiguration l : entry.getValue().getLinkConfigurationList()) {
                        for (String p : l.getPermissions()) {
                            if (p.equals(perm)) {
                                resultCfgList.add(l);
                            }
                        }
                    }

                    resultList.add(new MenuConfiguration(entry.getValue().getId(),
                            entry.getValue().getTitle(), entry.getValue().getIcon(),
                            resultCfgList));
                }
            }
        }


        System.out.println(resultList);


/*
        List<MenuConfiguration> reusltList = new ArrayList<>();
        List<LinkConfiguration> listLink = new ArrayList<>();
        for (String str : permissions) {
            for (MenuConfiguration menuCfg : menuConfigurationsList) {
                for (LinkConfiguration link : menuCfg.getLinkConfigurationList()) {
                    for (String perm : link.getPermissions()) {
                        if (str.equals(perm)) {
                            listLink.add(new LinkConfiguration(link));
                            reusltList.add(new MenuConfiguration(menuCfg.getId(),
                                    menuCfg.getTitle(), menuCfg.getIcon(), listLink));

                        }
                    }
                }
            }
        }

        //  reusltList.removeIf(men -> men.getLinkConfigurationList().isEmpty());

        System.out.println(reusltList.size());

        System.out.println(reusltList);*/

    }
}