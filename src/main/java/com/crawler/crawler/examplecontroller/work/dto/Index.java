package com.crawler.crawler.examplecontroller.work.dto;

import java.util.Objects;

public class Index {

    private final Integer groupId;
    private final Integer linkId;

    public Index(Integer groupId, Integer linkId) {
        this.groupId = groupId;
        this.linkId = linkId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return groupId.equals(index.groupId) &&
                linkId.equals(index.linkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, linkId);
    }
}