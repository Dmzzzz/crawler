package com.crawler.crawler.examplecontroller.work3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NavigatorServiceImpl implements NavigatorService {

    private final MenuRegistry menuRegistry;

    @Autowired
    public NavigatorServiceImpl(MenuRegistry menuRegistry) {
        this.menuRegistry = menuRegistry;
    }

    @Override
    public List<GroupDTO> createMenu() {
        List<MenuConfiguration> menuConfiguration = menuRegistry.createMenuConfiguration();
        List<String> permissionsForUser = Stream.of("permission").collect(Collectors.toList());

        return null;
    }


  /*  List<GroupDTO> generateMenu(List<MenuConfiguration> menuConfiguration, List<String> permissionsForUser) {
        for (String str : permissionsForUser) {
            menuConfiguration.stream()
                    .filter(menuCfg -> {
                                return menuCfg.getLinkConfigurationList().stream()
                                        .filter(link -> link.getPermissions().equals(str));
                            }
                    ).collect(Collectors.toList());

            }
        }



      *//*  menuConfiguration.stream()
              .map(menuCfg -> {
                  menuCfg.getLinkConfigurationList().stream()
                          .

              })*//*


        return Collections.emptyList();
    }*/

}
