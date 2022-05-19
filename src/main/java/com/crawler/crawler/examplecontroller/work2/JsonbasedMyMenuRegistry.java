package com.crawler.crawler.examplecontroller.work2;

public class JsonbasedMyMenuRegistry implements MyMenuRegistry {
    @Override
    public MyMenuConfiguration createMenuConfiguration() {
        return new MyMenuConfiguration();
    }
}
