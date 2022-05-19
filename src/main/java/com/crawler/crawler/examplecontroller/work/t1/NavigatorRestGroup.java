package com.crawler.crawler.examplecontroller.work.t1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum NavigatorRestGroup {

    ACCOUNTING_DOCUMENTS_GROUP(1L, "Бухгалетерские документы", "1icon",
            Stream.of(AllLinksTypes.LINK_VALUES, AllLinksTypes.LINK_DOCUMNETS_MODULES).collect(Collectors.toList())),

    CATALOG_GROUP(2L, "Справочники", "2icon",
            Stream.of(AllLinksTypes.LINK_VALUES, AllLinksTypes.LINK_DOCUMNETS_MODULES).collect(Collectors.toList()));

    private final Long id;
    private final String name;
    private final String iconCode;
    private final List<AllLinksTypes> allLinksTypes;

    NavigatorRestGroup(Long id, String name, String iconCode, List<AllLinksTypes> allLinksTypes) {
        this.id = id;
        this.name = name;
        this.iconCode = iconCode;
        this.allLinksTypes = allLinksTypes;
    }

    public String getName() {
        return name;
    }
}
