package com.crawler.crawler.crawler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CrawlerTest {

    @Test
    void whenHave7NotUniqueUrls_then_4UniqueAdded() {
        //given
        Node node = Mockito.mock(Node.class);
        Crawler crawler = new Crawler("example.com", node);
        List<String> urls = Stream.of("1.com", "2.com", "3.com", "3.com", "3.com", "4.com", "4.com")
                .collect(Collectors.toList());

        //when
        Mockito.when(node.urls("example.com")).thenReturn(urls);
        crawler.startCrawling();

        //then
        Set<String> uniqueLinks = crawler.getUniqueLinks();
        Assertions.assertEquals(4, uniqueLinks.size());
    }

    @Test
    void whenHave1HeadURL_and_No_nestedUrls() {
        Node node = Mockito.mock(Node.class);
        Crawler crawler = new Crawler("example.com", node);
        List<String> urls = Collections.emptyList();

        Mockito.when(node.urls("example.com")).thenReturn(urls);
        crawler.startCrawling();

        Set<String> links = crawler.getUniqueLinks();
        Assertions.assertEquals(0, links.size());
    }

    @Test
    void whenHeadURSL_IS_NULL_ThenEXCEPTION() {
        Node node = Mockito.mock(Node.class);

        assertThrows(NullPointerException.class, () -> {
            new Crawler(null, node);
        });
    }

}