package com.crawler.crawler.examplecontroller.work;

import java.io.Serializable;
import java.util.List;

/**
 * Навигационное меню, DTO для тонкого клиента
 */
public class NavigatorRestGroupDTO implements Serializable {

    private Long id;
    private String name;
    private String iconCode;

    private List<NavigatorLinkRestDTO> linkRestDTOList;

    public NavigatorRestGroupDTO(Long id, String name, String iconCode, List<NavigatorLinkRestDTO> linkRestDTOList) {
        this.id = id;
        this.name = name;
        this.iconCode = iconCode;
        this.linkRestDTOList = linkRestDTOList;
    }

    public NavigatorRestGroupDTO() {
    }

    public NavigatorRestGroupDTO(NavigatorRestGroupDTO navigatorRestGroupDTO,
                                 List<NavigatorLinkRestDTO> linkRestDTOList) {
        this.id = navigatorRestGroupDTO.getId();
        this.name = navigatorRestGroupDTO.getName();
        this.linkRestDTOList = linkRestDTOList;
    }

    public NavigatorRestGroupDTO(Long id, String name, String iconCode) {
        this.id = id;
        this.name = name;
        this.iconCode = iconCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    public List<NavigatorLinkRestDTO> getLinkRestDTOList() {
        return linkRestDTOList;
    }

    public void setLinkRestDTOList(List<NavigatorLinkRestDTO> linkRestDTOList) {
        this.linkRestDTOList = linkRestDTOList;
    }
}
