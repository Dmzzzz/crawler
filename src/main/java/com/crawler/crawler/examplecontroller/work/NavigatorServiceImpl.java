package com.crawler.crawler.examplecontroller.work;

import com.crawler.crawler.examplecontroller.work.dto.GroupMenuDTO;
import com.crawler.crawler.examplecontroller.work.dto.Index;
import com.crawler.crawler.examplecontroller.work.dto.LinkMenuDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NavigatorServiceImpl implements NavigatorService {
    private final MenuRegistry menuRegistry;
    private final MenuGenerator menuGenerator;

    public NavigatorServiceImpl(MenuRegistry menuRegistry, MenuGenerator menuGenerator) {
        this.menuRegistry = menuRegistry;
        this.menuGenerator = menuGenerator;
    }

    @Override
    public List<GroupMenuDTO> createMenu() {
        MenuConfiguration menuConfiguration = menuRegistry.createMenuConfiguration();
        List<GroupMenu> groupMenus = menuConfiguration.getGroupMenu();

        List<String> permissions = new ArrayList<String>() {{
            add("doc:payment:su:recall");
        }};

        return menuGenerator.generateMenu(groupMenus, permissions);
    }

/*    private List<GroupMenuDTO> generateMenu(List<GroupMenu> groupMenus, List<String> permissions) {

        final Map<String, List<Index>> permByListIndexes = new HashMap<>();

        Map<Integer, List<LinkMenu>> linkIdByLinkMenu = new HashMap<>();
        Map<Integer, List<GroupMenu>> groupIdByLinkMenu = new HashMap<>();

        for (final GroupMenu grm : groupMenus) {
            for (LinkMenu lnm : grm.getLinkMenu()) {
                for (String perm : lnm.getPermissions()) {
                    linkIdByLinkMenu.put(lnm.getId(), grm.getLinkMenu());
                    groupIdByLinkMenu.put(grm.getId(), groupMenus);
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

        List<LinkMenuDTO> resultLink = new ArrayList<>();

        for (int i = 0; i < permissions.size(); i++) {
            String s = permissions.get(i);
            if (permByListIndexes.containsKey(s)) {

                List<Index> indexes = permByListIndexes.get(s);

                for (int j = 0; j < indexes.size(); j++) {
                    Integer groupId = indexes.get(j).getGroupId();
                    Integer linkId = indexes.get(j).getLinkId();

                    List<GroupMenu> gr = groupIdByLinkMenu.get(groupId);
                    List<LinkMenu> linkMenus = linkIdByLinkMenu.get(linkId);

                    for (LinkMenu lm : linkMenus) {
                        resultLink.add(new LinkMenuDTO(lm.getName(),
                                lm.getTypeOfLink(), lm.getUrl(),
                                lm.getPermissions()));
                    }

                    for (GroupMenu g : gr) {
                        result.add(new GroupMenuDTO(g.getTitle(), g.getIcon(), resultLink));
                    }
                }
            }
        }
        return result;
    }*/
}
