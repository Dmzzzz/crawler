package com.crawler.crawler.examplecontroller.work3;

import java.io.Serializable;
import java.util.List;

public class LinkDTO implements Serializable {

    private String name;
    private String typeOfLink;
    private String url;

    private List<String> permissions;

    public LinkDTO(String name, String typeOfLink, String url, List<String> permissions) {
        this.name = name;
        this.typeOfLink = typeOfLink;
        this.url = url;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfLink() {
        return typeOfLink;
    }

    public void setTypeOfLink(String typeOfLink) {
        this.typeOfLink = typeOfLink;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "LinkDTO{" +
                "name='" + name + '\'' +
                ", typeOfLink='" + typeOfLink + '\'' +
                ", url='" + url + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}