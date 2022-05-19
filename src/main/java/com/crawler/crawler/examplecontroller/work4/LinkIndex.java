package com.crawler.crawler.examplecontroller.work4;

public class LinkIndex {

    private Integer groupId;
    private Integer linkId;

    public LinkIndex() {
    }

    public LinkIndex(final Integer groupId, final Integer linkId) {
        this.groupId = groupId;
        this.linkId = linkId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(final Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(final Integer linkId) {
        this.linkId = linkId;
    }
}
