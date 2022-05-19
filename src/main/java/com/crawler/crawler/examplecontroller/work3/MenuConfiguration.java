package com.crawler.crawler.examplecontroller.work3;


import java.util.List;

public class MenuConfiguration {

    private Integer Id;
    private String title;
    private String icon;
    private List<LinkConfiguration> linkConfigurationList;

    public MenuConfiguration(Integer id, String title, String icon, List<LinkConfiguration> linkConfigurationList) {
        Id = id;
        this.title = title;
        this.icon = icon;
        this.linkConfigurationList = linkConfigurationList;
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

    public List<LinkConfiguration> getLinkConfigurationList() {
        return linkConfigurationList;
    }

    public void setLinkConfigurationList(List<LinkConfiguration> linkConfigurationList) {
        this.linkConfigurationList = linkConfigurationList;
    }

    @Override
    public String toString() {
        return "MenuConfiguration{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", linkConfigurationList=" + linkConfigurationList +
                '}';
    }
}