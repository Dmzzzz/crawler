package com.crawler.crawler.examplecontroller.work;

import java.util.Set;

public class LinkMenu {
    private Integer id;
    private String name;
    private String typeOfLink;
    private String url;

    //  @JsonProperty("permissions")
    private Set<String> permissions;

    public LinkMenu() {
    }


    public LinkMenu(Integer id, String name, String typeOfLink, String url, Set<String> permissions) {
        this.id = id;
        this.name = name;
        this.typeOfLink = typeOfLink;
        this.url = url;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
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

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setTypeOfLink(final String typeOfLink) {
        this.typeOfLink = typeOfLink;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public void setPermissions(final Set<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "LinkMenu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeOfLink='" + typeOfLink + '\'' +
                ", url='" + url + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
