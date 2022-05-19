package com.crawler.crawler.examplecontroller.work4;

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
