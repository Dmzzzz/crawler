package com.crawler.crawler.examplecontroller.work2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class NavigatorParser {

    private static final String NAVIGATION = "src/main/resources/json/groupandlinks.json";

    /**
     * как частов обновлять конфигурацию, сервер должен обновлять конфигурацию во время работы
     * только при Старте - считывать при старте и кэшировать - лейзи объект считывать при старте и кэшировать
     * считываем в память
     *
     * сделать эффективную реализацию API
     *
     * по списку конфигурации
     *
     * 1. Считать конфигурацию из файла
     *   MenuConfiguration  - это данные как DTO
     *   parserFromJson()  это реализация,
     *
     *
     *   interface MenuRegistry
     *   MenuConfiguration  createMenuConfiguration() - загружаем из JSON
     *
     *
     *
     *   class JsonBasedMenuRegistry implelemts MenuRegistry {
     *
     *   }
     *
     *
     *  когда приходит запрос, то проверяем если в памяти есть MenuRegistry - если нет то Грузим
     *  lazy - загрузка   Lazy in Kotlin потокоБезопасно реализует
     *
     *
     *   class CacheableMenuRegistry  implements MenuRegistry{
     *
     *   CacheableMenuRegistry (MenuRegistry baseRegistry)    baseRegistry-
     *
     *
     *   }
     *
     *
     *
     *
     *
     *   class MenuGenerator {
     *
     *       DTO  createMenu(List<String> permissions, MenuConfiguration configuration) {
     *
     *        }
     *
     *        компанент оркестратор
     *
     *        Controller получает запрос от Клиента
     *
     *
     *
     *
     *   }
     *
     *
     *   class NavigatorService {
     *
     *
     *      GroupDTO getMenu(){
     *      MenuConfiguration  mc =  createMenuConfiguration();
     *
     *      List<String> permissions = userservice.getPermissonsForCurrentUser();
     *
     *      return  MenuGenerator.createMenu(permissions, mc);
     *
     *      }
      *
     *   }
     *
     *
     *
     *   контракт - создай меню
     *
     *      MenuDTO
     *   [{
     *          "name": "Группа1",
     *          "links": [{
     *              "title" : "Контроль выдачи",
     *              "url" : "url1"
     *          }]
     *   }]
     *
     *
     *
     *    Input - List<String> permissions;
     *
     *      Menu{
     *      *        List<Group> groups;
     *      *    }
     *      *    Group{
     *      *          name,
     *      *         List<Link> links;
     *      *    }
     *      *
     *      *    Link{
     *      *      title,
     *      *      url,
     *      *      List<String> permissions;
     *      *    }
     *
     *    Output - MenuDTO
     *
     *      *      MenuDTO
     *      *   [{
     *      *          "name": "Группа1",
     *      *          "links": [{
     *      *              "title" : "Контроль выдачи",
     *      *              "url" : "url1"
     *      *          }]
     *      *   } ,
     *       {
     *           "name: "Группа2",
     *           "links": [{
     *             "title" : "Контроль приёма",
     *             "url" : "url2"
     *           }]
     *       }
     *
     *    Menu{
     *        List<Group> groups;
     *    }
     *    Group{
     *          name,
     *         List<Link> links;
     *    }
     *
     *    Link{
     *      title,
     *      url,
     *      List<String> permissions;
     *    }
     *
     *1 - O(P * G * L_g_i)
     *
     * 2 - O (G * L_g_i + P)
     *      Алгоритм
     *      Обработать Menu  - получить Индекс
     *
     *      пороходим по пермишен обращаемся к индексу и получаем данные которые можем составить menu
     *      Map<Permission, List<LinkIndex>>
     *          LinkIndex{
     *              Integer Id; - linkID;
     *              Integer gopudId; - groupId;
     *          }
     *          Map<GroupId, List<Link>>
     *
     *
     *
     *
     *        Индекс
     *        есть список пермишенов - нужно линейно пройтись,
     *        ждя каждого пирмешена - список линков благодаря которому должны попасть в группу
     *
     *        Map<Permission, List<LinkIndex>>
     *            для каджого LinksIndexa для какой группы он относиться
     *
     *
     *            пермишен А - link L1 он относится к Группе G1
     *            пермишен B - link L2 к Группе G1
     *
     *            в Линкиндексе держать Группу -чтоб понять какую группу добавлять
     *             в ЛинИндексе должна быть группа - её ID
     *
     *             из ЛинкИндекса взять группу и проверить в MenuDTO - если есть то добавляем к Группе,
     *             если нет то создаём группу
     *             смысл индекса либо лёгкий либо избыточный,
     *             если он облегчённый и там только id и получается инфа о линках отдельно
     *
     *             чтобы не дублировать
     *
     *
     *                  Map<Permission, List<LinkIndex>>
     *
     *             LinkIndex{
     *                 Integer grouID;
     *                 Integer linkID;
     *             }
     *
     *             Map<GrouID, Group>
     *                 Group{
     *                     Map<LinkId, Link>
     *                         title;
     *                         icon;
     *                 }
     *                 Link{
     *               name;
     *               typeOfLink;
     *                String url
     *                 }
     *
     *
     *      *      MenuDTO
     *      *   [{
     *      *          "name": "Группа1",
     *      *          "links": [{
     *      *              "title" : "Контроль выдачи",
     *      *              "url" : "url1"
     *      *          }]
     *      *   }]
     *
     *
     *
     *
     */
    List<GroupRestDTO> parseFromJson() {
        // как прочитать файл из ресурсов
        System.lineSeparator();
        // для переноса путей


        // передавать InputStream - Jackson'у
        Path path = Paths.get(NAVIGATION);
        String jsonString = "";
        try {
            jsonString = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<GroupRestDTO> navigatorRestGroupDTOList = new ArrayList<>();

        try {
            navigatorRestGroupDTOList.addAll(Arrays.asList(objectMapper.readValue(jsonString, GroupRestDTO[].class)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return navigatorRestGroupDTOList;
    }
}