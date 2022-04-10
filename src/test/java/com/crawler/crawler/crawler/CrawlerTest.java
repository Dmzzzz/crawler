package com.crawler.crawler.crawler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

}