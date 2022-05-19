package com.crawler.crawler.examplecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/example")
    public String getWiki() {
        return "example";
    }

    @GetMapping("/1")
    public String get1Page() {
        return "1";
    }

}
