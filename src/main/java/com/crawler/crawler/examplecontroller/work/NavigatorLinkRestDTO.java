package com.crawler.crawler.examplecontroller.work;

import java.io.Serializable;
import java.util.List;

public class NavigatorLinkRestDTO  implements Serializable {

    private Long id;
    private String name;
    private String typeOfLink;
    private String url;

    private List<String> permissions;

    public NavigatorLinkRestDTO() {
    }

    public NavigatorLinkRestDTO(Long id, String name, String typeOfLink, String url, List<String> permissions) {
        this.id = id;
        this.name = name;
        this.typeOfLink = typeOfLink;
        this.url = url;
        this.permissions = permissions;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getPermissions() { return permissions; }

    public void setPermissions(List<String> permissions) { this.permissions = permissions; }
}
