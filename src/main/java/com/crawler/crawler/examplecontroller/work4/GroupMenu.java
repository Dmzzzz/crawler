package com.crawler.crawler.examplecontroller.work4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class GroupMenu implements Serializable {

    private Integer id;
    private String title;
    private String icon;

    //  @JsonProperty("linkMenu")
    private List<LinkMenu> linkMenu;

    public GroupMenu() {
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
}