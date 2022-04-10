package com.crawler.crawler.crawler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Crawler {

    private BlockingQueue<String> queue;
    private Set<String> uniqueLinks;
    private String headUrl;
    private Node node;


    public Crawler(final String headUrl, final Node node) {
        this.headUrl = headUrl;
        this.queue = new ArrayBlockingQueue<>(5000);
        this.uniqueLinks = ConcurrentHashMap.newKeySet();
        this.node = node;
        try {
            queue.put(headUrl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startCrawling() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!queue.isEmpty()) {
                String url = "";
                try {
                    url = queue.take();
                    System.out.println("take " + url);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<String> urls = node.urls(url);
                for (String i : urls) {
                    if (uniqueLinks.add(i)) {
                        queue.add(i);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("put " + i);
                    }
                }
            } else {

                System.out.println("Parsing is Finished");
                Thread.currentThread().interrupt();
            }
        }

    }

    public Set<String> getUniqueLinks() {
        return uniqueLinks;
    }
}
