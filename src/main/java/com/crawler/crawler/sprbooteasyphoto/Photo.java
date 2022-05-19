package com.crawler.crawler.sprbooteasyphoto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Photo {

    private Integer id;

    private String fileName;

    private String contentType;

    @JsonIgnore
    private byte[] data;

    public Photo() {
    }

    // raw data


    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}