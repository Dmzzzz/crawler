package com.crawler.crawler.examplecontroller;

import com.crawler.crawler.examplecontroller.work.LinkType;
import com.crawler.crawler.examplecontroller.work.NavigatorLinkRestDTO;
import com.crawler.crawler.examplecontroller.work.NavigatorRestGroupDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {

    static {
        List<NavigatorRestGroupDTO> groupDTOList = new ArrayList<>();

        NavigatorRestGroupDTO accountingDocuments = new NavigatorRestGroupDTO();
        accountingDocuments.setName("Бухгалетерские документы");
        accountingDocuments.setId(1L);
        accountingDocuments.setIconCode("1");

        NavigatorRestGroupDTO catalog = new NavigatorRestGroupDTO();
        catalog.setName("Справочники");
        catalog.setId(2L);
        catalog.setIconCode("2");

        NavigatorRestGroupDTO operationCashRegister = new NavigatorRestGroupDTO();
        operationCashRegister.setName("Операционная касса");
        operationCashRegister.setId(3L);
        operationCashRegister.setIconCode("3");

        NavigatorRestGroupDTO groceryAccounting = new NavigatorRestGroupDTO();
        groceryAccounting.setName("Продуктовый учет");
        groceryAccounting.setId(4L);
        groceryAccounting.setIconCode("4");

        List<NavigatorLinkRestDTO> links = new ArrayList<>();

        NavigatorLinkRestDTO linkValues = new NavigatorLinkRestDTO();
        linkValues.setId(1L);
        linkValues.setName("Ценности");
        linkValues.setTypeOfLink(LinkType.INTERNAL.getDisplayableName());

        NavigatorLinkRestDTO linkDocumentModels = new NavigatorLinkRestDTO();
        linkDocumentModels.setId(2L);
        linkDocumentModels.setName("Модели Документов");
        linkDocumentModels.setTypeOfLink(LinkType.INTERNAL.getDisplayableName());

        NavigatorLinkRestDTO linkGKC = new NavigatorLinkRestDTO();
        linkGKC.setId(3L);
        linkGKC.setName("ГКЦ");
        linkGKC.setTypeOfLink(LinkType.INTERNAL.getDisplayableName());


        NavigatorLinkRestDTO linkValuableLocations = new NavigatorLinkRestDTO();
        linkValuableLocations.setId(4L);
        linkValuableLocations.setName("Места Хранения");
        linkValuableLocations.setTypeOfLink(LinkType.INTERNAL.getDisplayableName());

        NavigatorLinkRestDTO linkInfrastructureOfASCC = new NavigatorLinkRestDTO();
        linkInfrastructureOfASCC.setId(5L);
        linkInfrastructureOfASCC.setName("Инфракструктура КИЦ");
        linkInfrastructureOfASCC.setTypeOfLink(LinkType.EXTERNAL.getDisplayableName());

        NavigatorLinkRestDTO linkIssueControl = new NavigatorLinkRestDTO();
        linkIssueControl.setId(6L);
        linkIssueControl.setName("Контроль выдачи");
        linkIssueControl.setTypeOfLink(LinkType.EXTERNAL.getDisplayableName());

        NavigatorLinkRestDTO linkReceptionControl = new NavigatorLinkRestDTO();
        linkReceptionControl.setId(7L);
        linkReceptionControl.setName("Контроль приема");
        linkReceptionControl.setTypeOfLink(LinkType.EXTERNAL.getDisplayableName());

        accountingDocuments.setLinkRestDTOList(
                Stream.of(linkValues, linkDocumentModels, linkGKC).collect(Collectors.toList()));

        catalog.setLinkRestDTOList(Stream.of(linkValues, linkDocumentModels, linkGKC, linkInfrastructureOfASCC,
                linkValuableLocations).collect(Collectors.toList()));

        operationCashRegister.setLinkRestDTOList(
                Stream.of(linkIssueControl, linkReceptionControl).collect(Collectors.toList()));

        groceryAccounting.setLinkRestDTOList(
                Stream.of(linkGKC).collect(Collectors.toList())
        );

        groupDTOList.add(accountingDocuments);
        groupDTOList.add(catalog);
        groupDTOList.add(operationCashRegister);
        groupDTOList.add(groceryAccounting);
    }
}
