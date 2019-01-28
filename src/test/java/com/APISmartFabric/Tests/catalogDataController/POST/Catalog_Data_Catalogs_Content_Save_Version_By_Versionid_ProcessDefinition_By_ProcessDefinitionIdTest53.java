package com.APISmartFabric.Tests.catalogDataController.POST;


import com.APISmartFabric.JsonBuilder.DataCatalogsContentSaveVersion;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.DataCatalogsContentSaveVersionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_Catalogs_Content_Save_Version_By_Versionid_ProcessDefinition_By_ProcessDefinitionIdTest53 {

	private ObjectMapper mapper = new ObjectMapper();

	private String active="true";
	private String code= "34566546546";
	private String columns="1";
	private String name="name";
	private String nameTranslations="name";
	private String additionalProp1="prop1";
	private String additionalProp2="prop2";
	private String additionalProp3="prop3";
	private String type="type";
	private String versionId ="2543534534534";
	private String processDefinitionId="343646456";

	
	@Test
	public void postCatalogDataCatalogsContentSaveVersion() throws JsonProcessingException {

		DataCatalogsContentSaveVersionRequest dataSaveCatalog = new DataCatalogsContentSaveVersionRequest(active, code, columns, name, nameTranslations, additionalProp1, additionalProp2, additionalProp3, type);

		DataCatalogsContentSaveVersion catalogContentSaveVersion = DataCatalogsContentSaveVersion.builder().active(dataSaveCatalog.getActive())
				.code(dataSaveCatalog.getCode()).columns(dataSaveCatalog.getColumns()).
						name(dataSaveCatalog.getName()).nameTranslations(dataSaveCatalog.getNameTranslations()).
						additionalProp1(dataSaveCatalog.getAdditionalProp1()).
						additionalProp2(dataSaveCatalog.getAdditionalProp2()).
						additionalProp3(dataSaveCatalog.getAdditionalProp3()).
				type(dataSaveCatalog.getType()).
				build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentSaveVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion1") + versionId +
				CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") + processDefinitionId)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentSaveVersionNoAuthentication() throws JsonProcessingException {
		DataCatalogsContentSaveVersionRequest dataSaveCatalog = new DataCatalogsContentSaveVersionRequest(active, code, columns, name, nameTranslations, additionalProp1, additionalProp2, additionalProp3, type);

		DataCatalogsContentSaveVersion catalogContentSaveVersion = DataCatalogsContentSaveVersion.builder().active(dataSaveCatalog.getActive())
				.code(dataSaveCatalog.getCode()).columns(dataSaveCatalog.getColumns()).
						name(dataSaveCatalog.getName()).nameTranslations(dataSaveCatalog.getNameTranslations()).
						additionalProp1(dataSaveCatalog.getAdditionalProp1()).
						additionalProp2(dataSaveCatalog.getAdditionalProp2()).
						additionalProp3(dataSaveCatalog.getAdditionalProp3()).
						type(dataSaveCatalog.getType()).
						build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentSaveVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion1") + versionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") + processDefinitionId)
				.then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
