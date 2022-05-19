package com.crawler.crawler.crawler;

import java.util.List;

public interface Crawler {

    void startCrawling();

    String takeFromQueue();

    void putInQueue(List<String> urls);
}