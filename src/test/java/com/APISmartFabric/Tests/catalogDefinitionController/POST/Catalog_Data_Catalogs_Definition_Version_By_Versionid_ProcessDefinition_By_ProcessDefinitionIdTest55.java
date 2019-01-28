package com.APISmartFabric.Tests.catalogDefinitionController.POST;


import com.APISmartFabric.JsonBuilder.DataCatalogsContentVersion;
import com.APISmartFabric.JsonBuilder.DataCatalogsDefinitionVersion;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.DataCatalogsContentVersionRequest;
import com.APISmartFabric.controller.Controllers.DataCatalogsDerfinitionVersionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_Catalogs_Definition_Version_By_Versionid_ProcessDefinition_By_ProcessDefinitionIdTest55 {

	private ObjectMapper mapper = new ObjectMapper();

	private String description = "this is a field description";
	private String idFields="5666";
	private String nameFields ="nameFileds";
	private String type="dfghf";
	private String idDescription="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String nameDescription="this is a description";
	private String removed="yes";
	private String versionId ="345643456546";
	private String processDefinitionId="364545654^";

	
	@Test
	public void postCatalogDataCatalogsContentLoadVersion() throws JsonProcessingException {

		DataCatalogsDerfinitionVersionRequest dataDefinitionCatalog = new DataCatalogsDerfinitionVersionRequest(description, idFields, nameFields, type, idDescription,nameDescription, removed);

		DataCatalogsDefinitionVersion catalogDefinitionVersion = DataCatalogsDefinitionVersion.builder().description(dataDefinitionCatalog.getDescription())
				.idFields(dataDefinitionCatalog.getIdFields()).nameFields(dataDefinitionCatalog.getNameFields()).
						type(dataDefinitionCatalog.getType()).idDescription(dataDefinitionCatalog.getIdDescription()).
						nameDescription(dataDefinitionCatalog.getNameDescription()).removed(dataDefinitionCatalog.getRemoved()).
						build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDefinitionVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + CredentialsUtils.getProperty("middleURLDataCatalogsDefinitionVersion1") + versionId +
				CredentialsUtils.getProperty("middleURLDataCatalogsDefinitionVersion2") + processDefinitionId)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentLoadVersionNoAuthentication() throws JsonProcessingException {
		DataCatalogsDerfinitionVersionRequest dataDefinitionCatalog = new DataCatalogsDerfinitionVersionRequest(description, idFields, nameFields, type, idDescription,nameDescription, removed);

		DataCatalogsDefinitionVersion catalogDefinitionVersion = DataCatalogsDefinitionVersion.builder().description(dataDefinitionCatalog.getDescription())
				.idFields(dataDefinitionCatalog.getIdFields()).nameFields(dataDefinitionCatalog.getNameFields()).
						type(dataDefinitionCatalog.getType()).idDescription(dataDefinitionCatalog.getIdDescription()).
						nameDescription(dataDefinitionCatalog.getNameDescription()).removed(dataDefinitionCatalog.getRemoved()).
						build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDefinitionVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + CredentialsUtils.getProperty("middleURLDataCatalogsDefinitionVersion1") + versionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsDefinitionVersion2") + processDefinitionId)
				.then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
