package com.crawler.crawler.crawler2;

import com.crawler.crawler.crawler.CrawlerRuntimeException;
import com.crawler.crawler.crawler.Node;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Parallel2 implements Crawler2 {
    private final BlockingQueue<String> queue;
    private final Set<String> uniqueLinks;
    private final String headUrl;
    private final Node node;

    Thread t1;
    Thread t2;

    public Parallel2(String headUrl, Node node) {
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
    public void startCrawler() {
        t1 = new Thread(this::startCrawling);
        t2 = new Thread(this::startCrawling);
        t1.start();
        t2.start();
    }

    @Override
    public void stopCrawler() {
        t1.interrupt();
        t2.interrupt();
    }

    public void firstPutInQueue() {
        String url = takeFromQueue();
        List<String> urls = node.urls(url);
        putInQueue(urls);
    }

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

    public String takeFromQueue() {
        try {
            String url = queue.take();
            System.out.println("take " + url);
            return url;
        } catch (InterruptedException e) {
            throw new CrawlerRuntimeException("links was ended ", e.getCause());
        }
    }

    public void startCrawling() {
        firstPutInQueue();
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


}