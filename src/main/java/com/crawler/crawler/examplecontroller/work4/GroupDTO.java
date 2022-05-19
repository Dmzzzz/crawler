package com.crawler.crawler.examplecontroller.work4;

import java.io.Serializable;
import java.util.List;

public class GroupDTO implements Serializable {
    private static final long serialVersionUID = 2869450353560047560L;

    private String title;
    private String icon;

    List<LinkDTO> linksRestDTOList;
}
