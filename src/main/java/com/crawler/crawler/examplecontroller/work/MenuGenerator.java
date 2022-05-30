package com.crawler.crawler.examplecontroller.work;

import com.crawler.crawler.examplecontroller.work.dto.GroupMenuDTO;
import com.crawler.crawler.examplecontroller.work.dto.Index;
import com.crawler.crawler.examplecontroller.work.dto.LinkMenuDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuGenerator {

    List<GroupMenuDTO> generateMenu(List<GroupMenu> groupMenus, List<String> permissions) {

        final Map<String, List<Index>> permByListIndexes = new HashMap<>();

        Map<Integer, List<LinkMenu>> linkIdByLinkMenu = new HashMap<>();
        Map<Integer, List<GroupMenu>> groupIdByLinkMenu = new HashMap<>();

        Map<Integer, GroupMenu> groupIdByGroup = new HashMap<>();
        Map<Integer, LinkMenu> linkIdByLink = new HashMap<>();

        for (final GroupMenu grm : groupMenus) {
            for (LinkMenu lnm : grm.getLinkMenu()) {
                for (String perm : lnm.getPermissions()) {
                    linkIdByLinkMenu.put(lnm.getId(), grm.getLinkMenu());
                    groupIdByLinkMenu.put(grm.getId(), groupMenus);
                    groupIdByGroup.put(grm.getId(), grm);
                    if (permByListIndexes.containsKey(perm)) {
                        groupIdByGroup.put(grm.getId(), grm);
                        linkIdByLink.put(lnm.getId(), lnm);
                        permByListIndexes.get(perm).add(new Index(grm.getId(), lnm.getId()));
                    } else {
                        List<Index> listIndexes = new ArrayList<>();
                        listIndexes.add(new Index(grm.getId(), lnm.getId()));
                        permByListIndexes.put(perm, listIndexes);
                    }
                }
            }
        }

        List<GroupMenuDTO> result = new ArrayList<>();

        List<LinkMenuDTO> resultLink = new ArrayList<>();

        for (int i = 0; i < permissions.size(); i++) {
            String s = permissions.get(i);
            Integer groupId = 0;
            if (permByListIndexes.containsKey(s)) {

                List<Index> indexes = permByListIndexes.get(s);
                for (int j = 0; j < indexes.size(); j++) {
                    groupId = indexes.get(j).getGroupId();
                    Integer linkId = indexes.get(j).getLinkId();

                    List<GroupMenu> gr = groupIdByLinkMenu.get(groupId);
                    List<LinkMenu> linkMenus = linkIdByLinkMenu.get(linkId);


                    for (LinkMenu lm : linkMenus) {
                        for (String st : lm.getPermissions()) {
                            if (st.equals(s)) {
                                resultLink.add(new LinkMenuDTO(lm.getName(),
                                        lm.getTypeOfLink(), lm.getUrl(),
                                        lm.getPermissions()));
                            }
                        }
                    }

                }
            }
            result.add(new GroupMenuDTO(groupIdByGroup.get(groupId).getTitle(),
                    groupIdByGroup.get(groupId).getIcon(), resultLink));
        }
        return result;
    }

    List<GroupMenuDTO> generateMenu2(List<GroupMenu> groupMenus, List<String> permissions) {

        final Map<String, List<Index>> permByListIndexes = new HashMap<>();


        Map<Integer, GroupMenu> groupIdByGroup = new HashMap<>();
        Map<Integer, LinkMenu> linkIdByLink = new HashMap<>();

        for (final GroupMenu grm : groupMenus) {
            for (LinkMenu lnm : grm.getLinkMenu()) {
                for (String perm : lnm.getPermissions()) {
                    groupIdByGroup.put(grm.getId(), grm);
                    linkIdByLink.put(lnm.getId(), lnm);
                    if (permByListIndexes.containsKey(perm)) {
                        permByListIndexes.get(perm).add(new Index(grm.getId(), lnm.getId()));
                    } else {
                        List<Index> listIndexes = new ArrayList<>();
                        listIndexes.add(new Index(grm.getId(), lnm.getId()));
                        permByListIndexes.put(perm, listIndexes);
                    }
                }
            }
        }

        List<GroupMenuDTO> result = new ArrayList<>();


        for (int i = 0; i < permissions.size(); i++) {
            String s = permissions.get(i);
            Integer groupId = 0;
            Integer linkId = 0;
            if (permByListIndexes.containsKey(s)) {

                List<Index> indexes = permByListIndexes.get(s);
                for (int j = 0; j < indexes.size(); j++) {
                    groupId = indexes.get(j).getGroupId();
                    linkId = indexes.get(j).getLinkId();


                    GroupMenu groupMenu = groupIdByGroup.get(groupId);
                    LinkMenu linkMenu = linkIdByLink.get(linkId);
                    if (!result.isEmpty() && result.get(j).getTitle().equals(groupMenu.getTitle())) {
                       result.stream().filter(r -> r.getTitle().equals(groupMenu.getTitle()))
                               .peek(r -> r.getLinkMenu().add(new LinkMenuDTO(
                                linkMenu.getName(),
                                linkMenu.getTypeOfLink(),
                                linkMenu.getUrl(),
                                linkMenu.getPermissions()
                        ))).collect(Collectors.toList());
                    }
                    List<LinkMenuDTO> linkMenuDTOList = new ArrayList<>();
                    linkMenuDTOList.add(new LinkMenuDTO(
                            linkMenu.getName(),
                            linkMenu.getTypeOfLink(),
                            linkMenu.getUrl(),
                            linkMenu.getPermissions()));

                    result.add(new GroupMenuDTO(groupMenu.getTitle(),
                            groupMenu.getIcon(), linkMenuDTOList));

                }
            }
        }
        return result;
    }


    List<GroupMenu> generateMenu3(List<GroupMenu> groupMenus, List<String> permissions) {

        final Map<String, List<Index>> permByListIndexes = new HashMap<>();


        Map<Integer, GroupMenu> groupIdByGroup = new HashMap<>();
        Map<Integer, LinkMenu> linkIdByLink = new HashMap<>();

        for (final GroupMenu grm : groupMenus) {
            for (LinkMenu lnm : grm.getLinkMenu()) {
                for (String perm : lnm.getPermissions()) {
                    groupIdByGroup.put(grm.getId(), grm);
                    linkIdByLink.put(lnm.getId(), lnm);
                    if (permByListIndexes.containsKey(perm)) {
                        permByListIndexes.get(perm).add(new Index(grm.getId(), lnm.getId()));
                    } else {
                        List<Index> listIndexes = new ArrayList<>();
                        listIndexes.add(new Index(grm.getId(), lnm.getId()));
                        permByListIndexes.put(perm, listIndexes);
                    }
                }
            }
        }

        List<GroupMenu> result = new ArrayList<>();


        for (int i = 0; i < permissions.size(); i++) {
            String s = permissions.get(i);
            Integer groupId = 0;
            Integer linkId = 0;
            if (permByListIndexes.containsKey(s)) {

                List<Index> indexes = permByListIndexes.get(s);
                for (int j = 0; j < indexes.size(); j++) {
                    groupId = indexes.get(j).getGroupId();
                    linkId = indexes.get(j).getLinkId();


                    GroupMenu groupMenu = groupIdByGroup.get(groupId);
                    LinkMenu linkMenu = linkIdByLink.get(linkId);
                    if (!result.isEmpty() && result.contains(groupMenu)) {
                        result.stream().filter(r -> r.getId().equals(groupMenu.getId()))
                                .peek(r -> r.getLinkMenu().add(
                                        new LinkMenu(linkMenu.getId(), linkMenu.getName(),
                                                linkMenu.getTypeOfLink(), linkMenu.getUrl(),
                                                linkMenu.getPermissions())
                                ))
                                .collect(Collectors.toList());
                    }
                    List<LinkMenu> linkMenuList = new ArrayList<>();
                    linkMenuList.add(new LinkMenu(
                            linkMenu.getId(),
                            linkMenu.getName(),
                            linkMenu.getTypeOfLink(),
                            linkMenu.getUrl(),
                            linkMenu.getPermissions()));

                    result.add(new GroupMenu(groupMenu.getId() ,groupMenu.getTitle(),
                            groupMenu.getIcon(), linkMenuList));

                }
            }
        }

 /*       List<GroupMenu> res = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            GroupMenu groupMenu = result.get(i);
            if (res.)
        }*/

        return result;
    }

}
