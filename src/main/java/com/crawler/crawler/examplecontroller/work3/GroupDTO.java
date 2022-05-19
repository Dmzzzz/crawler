package com.crawler.crawler.examplecontroller.work3;

import java.util.List;

public class GroupDTO {

    private String title;
    private String icon;

    List<LinkDTO> linksRestDTOList;

    public GroupDTO(String title, String icon, List<LinkDTO> linksRestDTOList) {
        this.title = title;
        this.icon = icon;
        this.linksRestDTOList = linksRestDTOList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<LinkDTO> getLinksRestDTOList() {
        return linksRestDTOList;
    }

    public void setLinksRestDTOList(List<LinkDTO> linksRestDTOList) {
        this.linksRestDTOList = linksRestDTOList;
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", linksRestDTOList=" + linksRestDTOList +
                '}';
    }
}