package com.crawler.crawler.examplecontroller.work;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MyNavigatorServiceImpl implements MyNavigatorService {

    @Override
    public List<NavigatorRestGroupDTO> getNavigate() {

        boolean flag = false;
        List<NavigatorRestGroupDTO> allGroupsAndLinks = getAllGroupsAndLinks();

        allGroupsAndLinks.stream()
                .map(gr -> {
                            List<NavigatorLinkRestDTO> collect
                                    = gr.getLinkRestDTOList().stream()
                                    .filter(link -> link.getId() > 5).collect(Collectors.toList());
                            return new NavigatorRestGroupDTO(gr, collect);
                        }
                ).collect(Collectors.toList());

        if (flag) {
            return allGroupsAndLinks;
        } else {
            List<NavigatorRestGroupDTO> groupsForPermissions = new ArrayList<>();
            for (NavigatorRestGroupDTO allGroupsAndLink : allGroupsAndLinks) {
                List<NavigatorLinkRestDTO> linkRestDTOList = allGroupsAndLink.getLinkRestDTOList();
                List<NavigatorLinkRestDTO> newLinks = new ArrayList<>();
                for (NavigatorLinkRestDTO navigatorLinkRestDTO : linkRestDTOList) {
                    if (navigatorLinkRestDTO.getId() > 5L) {
                        newLinks.add(navigatorLinkRestDTO);
                    }
                }
                NavigatorRestGroupDTO navigatorRestGroupDTO = allGroupsAndLink;
                groupsForPermissions.add(new NavigatorRestGroupDTO(navigatorRestGroupDTO,
                        newLinks));
            }
            return groupsForPermissions;
        }
    }

    private static List<NavigatorRestGroupDTO> getAllGroupsAndLinks() {
        List<NavigatorRestGroupDTO> groupDTOList = new ArrayList<>();

        NavigatorRestGroupDTO accountingDocumentsGroup = new NavigatorRestGroupDTO(
                1L, "Бухгалетерские документы", "1iconCode");

        NavigatorRestGroupDTO catalogGroup = new NavigatorRestGroupDTO(
                2L, "Справочники", "2iconCode");

        NavigatorRestGroupDTO operationCashRegisterGroup = new NavigatorRestGroupDTO(
                3L, "Операционная касса", "3iconCode");


        NavigatorRestGroupDTO groceryAccountingGroup = new NavigatorRestGroupDTO(
                4L, "Продуктовый учет", "4iconCode");

        NavigatorRestGroupDTO outsourcingCollectionGroup = new NavigatorRestGroupDTO(
                5L, "Аутсорс инкассация", "5iconCode");

        NavigatorRestGroupDTO administrationGroup = new NavigatorRestGroupDTO(
                6L, "Администрирование", "6iconCode");


        NavigatorLinkRestDTO linkValues = new NavigatorLinkRestDTO(1L, "Ценности",
                LinkType.INTERNAL.getDisplayableName(), "url1", Collections.emptyList());

        NavigatorLinkRestDTO documentModelsLink = new NavigatorLinkRestDTO(2L, "Модели Документов",
                LinkType.INTERNAL.getDisplayableName(), "url2", Collections.emptyList());

        NavigatorLinkRestDTO GKCLink = new NavigatorLinkRestDTO(3L, "ГКЦ",
                LinkType.INTERNAL.getDisplayableName(), "url3", Collections.emptyList());

        NavigatorLinkRestDTO valuableLocationsLink = new NavigatorLinkRestDTO(4L, "Места Хранения",
                LinkType.INTERNAL.getDisplayableName(), "", Collections.emptyList());


        NavigatorLinkRestDTO infrastructureOfASCCLink = new NavigatorLinkRestDTO(5L, "Инфракструктура КИЦ",
                LinkType.EXTERNAL.getDisplayableName(), "url5", Collections.emptyList());

        NavigatorLinkRestDTO issueControlLink = new NavigatorLinkRestDTO(6L, "Контроль выдачи",
                LinkType.EXTERNAL.getDisplayableName(), "url6", Collections.emptyList());

        NavigatorLinkRestDTO receptionControlLink = new NavigatorLinkRestDTO(7L, "Контроль приема",
                LinkType.EXTERNAL.getDisplayableName(), "url7", Collections.emptyList());

        NavigatorLinkRestDTO operationWithBRLink = new NavigatorLinkRestDTO(8L, "Операции с БР",
                LinkType.EXTERNAL.getDisplayableName(), "url8", Collections.emptyList());

        NavigatorLinkRestDTO businessServicesLink = new NavigatorLinkRestDTO(9L, "Бизнес Сервисы",
                LinkType.EXTERNAL.name(), "url9", Collections.emptyList());

        NavigatorLinkRestDTO productEventsLink = new NavigatorLinkRestDTO(10L, "Продуктовые События",
                LinkType.EXTERNAL.getDisplayableName(), "url10", Collections.emptyList());

        NavigatorLinkRestDTO registersLink = new NavigatorLinkRestDTO(11L, "Регистры",
                LinkType.EXTERNAL.getDisplayableName(), "url11", Collections.emptyList());

        accountingDocumentsGroup.setLinkRestDTOList(
                Stream.of(linkValues, documentModelsLink, GKCLink).collect(Collectors.toList()));

        catalogGroup.setLinkRestDTOList(Stream.of(linkValues, documentModelsLink, GKCLink, infrastructureOfASCCLink,
                valuableLocationsLink).collect(Collectors.toList()));

        operationCashRegisterGroup.setLinkRestDTOList(
                Stream.of(issueControlLink, receptionControlLink, operationWithBRLink, infrastructureOfASCCLink).collect(Collectors.toList()));

        groceryAccountingGroup.setLinkRestDTOList(Stream.of(GKCLink).collect(Collectors.toList()));

        groupDTOList.add(accountingDocumentsGroup);
        groupDTOList.add(catalogGroup);
        groupDTOList.add(operationCashRegisterGroup);
        groupDTOList.add(groceryAccountingGroup);

        return groupDTOList;
    }


    @Override
    public List<NavigatorRestGroupDTO> getNavigate2() {


        return Collections.emptyList();
    }

    @Override
    public List<NavigatorRestGroupDTO> parseJsonGroupAndLinks() {
        String pathOfJson = "src/main/resources/json/groupandlinks.json";
        Path path = Paths.get(pathOfJson);
        String jsonString = "";
        try {
            jsonString = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();


        return Collections.emptyList();
    }
}