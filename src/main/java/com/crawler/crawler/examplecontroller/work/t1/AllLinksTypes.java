package com.crawler.crawler.examplecontroller.work.t1;

import com.crawler.crawler.examplecontroller.work.LinkType;

public enum AllLinksTypes {
    LINK_VALUES(1L, "Ценности", LinkType.INTERNAL, "url1"),
    LINK_DOCUMNETS_MODULES(2L, "Модели Документов", LinkType.INTERNAL, "url2");

    private Long id;
    private String name;
    private LinkType linkType;
    private String url;


    AllLinksTypes(Long id, String name, LinkType linkType, String url) {
        this.id = id;
        this.name = name;
        this.linkType = linkType;
        this.url = url;
    }
}
