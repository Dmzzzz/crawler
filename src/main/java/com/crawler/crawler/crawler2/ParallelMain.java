package com.crawler.crawler.crawler2;

import com.crawler.crawler.crawler.JsoupNodeImpl;
import com.crawler.crawler.crawler.Node;

public class ParallelMain {

    public static void main(String[] args) {
        Node node = new JsoupNodeImpl();
        Crawler2 crawler2 = new Parallel2("https://en.wikipedia.org", node);
        crawler2.startCrawler();
    }
}
