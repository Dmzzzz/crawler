package com.crawler.crawler.examplecontroller.work;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/navigate")
public class NavigatorController {

    private final MyNavigatorService myNavigatorService;

    public NavigatorController(MyNavigatorService myNavigatorService) {
        this.myNavigatorService = myNavigatorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NavigatorRestGroupDTO> getNavigator() {

        return myNavigatorService.getNavigate();
    }
}
