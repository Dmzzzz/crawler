package com.crawler.crawler.examplecontroller.work2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuBeanConfig {

    @Bean
    public MyMenuRegistry cacheableMenuregistry() {

        return new CacheableMyMenuRegistry(new JsonbasedMyMenuRegistry());
    }
}