package com.crawler.crawler.crawler;

public class CrawlerRuntimeException extends RuntimeException {

    public CrawlerRuntimeException(String message) {
        super(message);
    }

    public CrawlerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
