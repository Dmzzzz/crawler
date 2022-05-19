package com.crawler.crawler.examplecontroller.work;


import java.util.List;

/**
 * Сервис для навигации по Тонкому Клиенту
 */
public interface MyNavigatorService {

        List<NavigatorRestGroupDTO> getNavigate();


        List<NavigatorRestGroupDTO> getNavigate2();


        List<NavigatorRestGroupDTO> parseJsonGroupAndLinks();
}
