package com.crawler.crawler.examplecontroller.work.dto;

import java.util.Set;

public class LinkMenuDTO {

    private String name;
    private String typeOfLink;
    private String url;

    private Set<String> permissions;

    public LinkMenuDTO(String name, String typeOfLink, String url, Set<String> permissions) {
        this.name = name;
        this.typeOfLink = typeOfLink;
        this.url = url;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfLink() {
        return typeOfLink;
    }

    public String getUrl() {
        return url;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    @Override
    public String toString() {
        return "LinkMenuDTO{" +
                "name='" + name + '\'' +
                ", typeOfLink='" + typeOfLink + '\'' +
                ", url='" + url + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}