package com.crawler.crawler.examplecontroller.work;

import java.util.*;
import java.io.Serializable;

public class GroupMenu implements Serializable {

    private Integer id;
    private String title;
    private String icon;

    //  @JsonProperty("linkMenu")
    private List<LinkMenu> linkMenu;

    public GroupMenu() {
    }

    public GroupMenu(Integer id, String title, String icon, List<LinkMenu> linkMenu) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.linkMenu = linkMenu;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIcon() {
        return icon;
    }

    public List<LinkMenu> getLinkMenu() {
        return linkMenu;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setIcon(final String icon) {
        this.icon = icon;
    }

    public void setLinkMenu(final List<LinkMenu> linkMenu) {
        this.linkMenu = linkMenu;
    }

    @Override
    public String toString() {
        return "GroupMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", linkMenu=" + linkMenu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupMenu groupMenu = (GroupMenu) o;
        return Objects.equals(id, groupMenu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}