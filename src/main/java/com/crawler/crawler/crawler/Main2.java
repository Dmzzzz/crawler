package com.crawler.crawler.crawler;

public class Main2 {

    public static void main(String[] args) {

        Node node = new JsoupNodeImpl();

       ParallelCrawler2 crawler2 = new ParallelCrawler2("https://en.wikipedia.org", node);

       /*
       *  краулер - компонент передаёшь стартовый елемент и парсишь
       *  не использую методы интефейса
       *
       * Клиент не должен знать детали реализации
       * Мейн не должен знать о создании Тредов
          должен сделать Старт а
       *
       *
       * Crawler -  интерфейс который видит Клиент, это не зона ответсвтенности Клиента,  вызвать метод страт  или стоп
       *
       * Самому поменеджерить потоки и также использовать ExecutorService
       *
        */

        for (int i = 0; i < 4; i++) {
            new Thread(crawler2::startCrawling).start();
        }
    }
}