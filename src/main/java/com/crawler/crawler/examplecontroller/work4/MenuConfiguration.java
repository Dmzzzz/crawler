package com.crawler.crawler.examplecontroller.work4;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class MenuConfiguration implements Serializable {

    private static final long serialVersionUID = -3055625369084795208L;

         @JsonProperty("groupMenu")
        private List<GroupMenu> groupMenu;

    public MenuConfiguration() {
    }

    public List<GroupMenu> getGroupMenu() {
        return groupMenu;
    }

    public void setGroupMenus(final List<GroupMenu> groupMenus) {
        this.groupMenu = groupMenus;
    }

    @Override
    public String toString() {
        return "MenuConfiguration{" +
               "groupMenu=" + groupMenu +
               '}';
    }
}