package com.agys.model;

import com.agys.jsonBuilder.*;

import java.util.UUID;

public class Factory {
    public static final AdminTenants adminTenantsJson = AdminTenants.builder()
            .defaultUserEmail(UUID.randomUUID().toString() + "@agys.ch")
            .defaultUserPassword("testPasswd")
            .domain(("d." + UUID.randomUUID().toString()).replaceAll("[^a-zA-Z0-9]", ""))
            .name(UUID.randomUUID().toString())
            .status("ACTIVE").build();

    public static final DataCatalogsContentExportJson catalogContentExportJson = DataCatalogsContentExportJson.builder()
            .catalogs(UUID.randomUUID().toString())
            .processDefinitionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
            .build();

    public static final DataCatalogsContentExportVersion catalogContentExportVersion = DataCatalogsContentExportVersion.builder()
            .catalogs(UUID.randomUUID().toString())
            .processDefinitionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
            .versionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
            .build();


    public static final DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder()
            .overwriteExisting("false")
            .inactiveOther("false")
            .attachment("35345345")
            .catalogs("46456456")
            .processDefinitionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
            .versionId("508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177")
           .build();

    public static final DataModelJsonPath dataModelJsonPath  = DataModelJsonPath.builder()
            .json("{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
            .path("//users/downloads/something")
            .type("type")
            .build();



   public static final DataModelMapping dataModelMapping = DataModelMapping.builder().
           blockchainOnly("true")
            .genericModelTimestamp("0").
                   description("this is something").
                    idField("4565467457567657").
                   nameField("ThisIsAName").
                   typeField("type").
                   id("45654674575676573543").
                   name("ThisIsAName1").
                   removed("yes").
                    idModelClass("45555").
                   isBCReady("true").
                   isEmbeded("true").
                   isIndexable("true").
                    isList("true").
                   nameModelClass("true").
                   typeModelClass("true").
                   id1("345354").
                   isBCReady1("true").
                    name1("true").
                   idModelCoreEntitioes("true").
                   isBCReadyModelCoreEntitioes("true").
                    isEmbededModelCoreEntitioes("true").
                   isIndexableModelCoreEntitioes("true").
                    isListModelCoreEntitioes("true").
                   nameModelCoreEntitioes("true").
                    typeModelCoreEntitioes("true").id2("2353534").
                   isBCReady2("true").
                   name3("Name")
                   .diagramFileId("diagrameFiled")
                   .id4("34534345")
                   .type4("type4").
                   id5("3454345").
                   isBCReady4("true").
                   isEmbeded4("true").
                   isIndexable4("true").
                   isList4("true").
                    name5("name5").
                   type5("type45").id100("24535").
                   isBCReady5("true").name100("name55").
                   type100("type100").
                   pathlist("//users/downloads/something").
                    build();

}