package com.crawler.crawler.examplecontroller.work.dto;

import com.crawler.crawler.examplecontroller.work.dto.LinkMenuDTO;

import java.util.List;

public class GroupMenuDTO {

    private String title;
    private String icon;

    //  @JsonProperty("linkMenu")
    private List<LinkMenuDTO> linkMenu;

    public GroupMenuDTO() {
    }

    public GroupMenuDTO(String title, String icon, List<LinkMenuDTO> linkMenu) {
        this.title = title;
        this.icon = icon;
        this.linkMenu = linkMenu;
    }

    public String getTitle() {
        return title;
    }

    public String getIcon() {
        return icon;
    }

    public List<LinkMenuDTO> getLinkMenu() {
        return linkMenu;
    }

    @Override
    public String toString() {
        return "GroupMenuDTO{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", linkMenu=" + linkMenu +
                '}';
    }
}
