package com.crawler.crawler.crawler;

public class Main {

    public static void main(String[] args) {

        Node node = new JsoupNodeImpl();
        Crawler crawler = new Crawler("https://en.wikipedia.org", node);

        Thread thread = new Thread(crawler::startCrawling);
                thread.start();

    }
}
