package com.crawler.crawler.crawler;

public class Main {

    public static void main(String[] args) {

        Node node = new JsoupNodeImpl();
        SimpleCrawler simpleCrawler = new SimpleCrawler("https://en.wikipedia.org", node);

        Thread thread = new Thread(simpleCrawler::startCrawling);
                thread.start();

    }
}
