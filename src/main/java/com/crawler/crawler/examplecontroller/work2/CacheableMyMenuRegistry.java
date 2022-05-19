package com.crawler.crawler.examplecontroller.work2;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * кэширующая реали зация должны вернуть меню конфигурации
 * если не заргужена грузим 1 раз, елси нет то грузим
 *
 * попроб
 *
 * можно просто хранить внутри поле menuConfiguration - но нужно будет реализовать блокировку
 * если кто-то будет паралельно - то двойная заргузка -
 *
 * coffeinCache использовать её
 *
 * "SpringCache навесить на createMenuConfiguration() - здесь
 * если есть анотация кэширования то выполняться один раз
 *
 *
 *
 *
 *
 */
@Component
public class CacheableMyMenuRegistry implements MyMenuRegistry {

    private MyMenuRegistry baseMyMenuRegistry;
    public CacheableMyMenuRegistry(MyMenuRegistry baseMyMenuRegistry) {
                this.baseMyMenuRegistry = baseMyMenuRegistry;

    }

    @Cacheable(cacheNames = "menuConfigCache")
    @Override
    public MyMenuConfiguration createMenuConfiguration() {
        return baseMyMenuRegistry.createMenuConfiguration();

    }
}
