package com.crawler.crawler.examplecontroller.work2;

import java.io.Serializable;
import java.util.List;

public class GroupRestDTO implements Serializable {

    private Integer Id;
    private String title;
    private String icon;

    List<LinkRestDTO> linksRestDTOList;

    public GroupRestDTO() {
    }

    public GroupRestDTO(Integer id, String title, String icon, List<LinkRestDTO> linksRestDTOList) {
        Id = id;
        this.title = title;
        this.icon = icon;
        this.linksRestDTOList = linksRestDTOList;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public List<LinkRestDTO> getLinksRestDTOList() {
        return linksRestDTOList;
    }

    public void setLinksRestDTOList(List<LinkRestDTO> linksRestDTOList) {
        this.linksRestDTOList = linksRestDTOList;
    }

    @Override
    public String toString() {
        return "GroupRestDTO{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", linksRestDTO=" + linksRestDTOList +
                '}';
    }
}