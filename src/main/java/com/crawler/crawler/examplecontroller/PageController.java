package com.crawler.crawler.examplecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/example")
    public String getWiki() {
        return "example";
    }

}
