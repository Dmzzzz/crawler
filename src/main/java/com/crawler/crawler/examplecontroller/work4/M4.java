package com.crawler.crawler.examplecontroller.work4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M4 {

    public static void main(String[] args) {

/*
        JsonMenuRegistry jsonMenuRegistry = new JsonMenuRegistry();

        MenuConfiguration menuConfiguration = jsonMenuRegistry.createMenuConfiguration();

        System.out.println(menuConfiguration);
*/
        JsonMenuRegistry2 js2 = new JsonMenuRegistry2();
        MenuConfiguration menuConfiguration = js2.createMenuConfiguration();

        System.out.println(menuConfiguration);

        final Map<String, GroupMenu> permissoinsByGroupMenu = new HashMap<>();
        List<GroupMenu> groupMenus = menuConfiguration.getGroupMenu();



        final Map<String, List<LinkIndex>> permByLinkIndexes = new HashMap<>();

        List<GroupMenu> resultListGr = new ArrayList<>();
        List<LinkMenu> resultLink = new ArrayList<>();
        for (final GroupMenu grm : groupMenus) {
            for (LinkMenu lnm : grm.getLinkMenu()) {
                for (String perm : lnm.getPermissions()) {
                    List<LinkIndex> linkIndices = new ArrayList<>();
                    if (permByLinkIndexes.containsKey())
                }
            }
        }



        System.out.println(permByLinkIndexes.size());









    }
}