package com.crawler.crawler.crawler;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCrawler implements Crawler {

    private final BlockingQueue<String> queue;
    private final Set<String> uniqueLinks;
    private final String headUrl;
    private final Node node;


    public SimpleCrawler(final String headUrl, final Node node) {
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

    @Override
    public void startCrawling() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!queue.isEmpty()) {
                String url = takeFromQueue();
                List<String> urls = node.urls(url);
                putInQueue(urls);
            } else {
                System.out.println("Parsing is Finished");
                Thread.currentThread().interrupt();
            }
        }

    }

    @Override
    public String takeFromQueue() {
        try {
           String url = queue.take();
            System.out.println("take " + url);
            return url;
        } catch (InterruptedException e) {
            throw new CrawlerRuntimeException("links was ended ", e.getCause());
        }
    }

    @Override
    public void putInQueue(List<String> urls) {
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
    }

    public Set<String> getUniqueLinks() {
        return uniqueLinks;
    }
}
