package com.crawler.crawler.examplecontroller.work;

import java.util.Arrays;

public enum  LinkType {

    INTERNAL(1, "Внутреняя"),
    EXTERNAL(2,"Внешняя");

    private final int id;
    private final String displayableName;

    LinkType(int id, String displayableName) {
        this.id = id;
        this.displayableName = displayableName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayableName() {
        return displayableName;
    }

    public static LinkType findById(final int id) {
        return Arrays.stream(values())
                .filter(type -> type.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not valid TYPE"));
    }
}
