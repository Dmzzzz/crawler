package com.crawler.crawler.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupNodeImpl implements Node {

    @Override
    public List<String> urls(String headUrl) {
        List<String> urls = new ArrayList<>();
        Document document = getDocument(headUrl);
        for (Element e : document.select("a[href]")) {
            // Инкапсулировать в отдельные методы
            String href = e.absUrl("href");
            urls.add(href);
        }
        return urls;
    }

    public Document getDocument(String url) {
        try {
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();
            if (connection.response().statusCode() == 200) {
                System.out.println("thread " + Thread.currentThread().getId()+";" + " download webpage: " + url);
                return document;
            }
            // TODO выбрасывать своё исключение не предавать null
            // Обернуть все Свои исключения и пробросить дальше
            throw new CrawlerRuntimeException(String.format("This page %s has other status 200", url));
        } catch (IOException e) {
            throw new CrawlerRuntimeException(String.format("This %s page could not download", url));
        }
    }

}
