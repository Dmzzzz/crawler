package com.crawler.crawler.examplecontroller.work3;

import java.util.Objects;

public class LinkIndex {

    private Integer groupId;
    private Integer linkId;

    public LinkIndex(Integer groupId, Integer linkId) {
        this.groupId = groupId;
        this.linkId = linkId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkIndex linkIndex = (LinkIndex) o;
        return groupId.equals(linkIndex.groupId) &&
                linkId.equals(linkIndex.linkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, linkId);
    }
}