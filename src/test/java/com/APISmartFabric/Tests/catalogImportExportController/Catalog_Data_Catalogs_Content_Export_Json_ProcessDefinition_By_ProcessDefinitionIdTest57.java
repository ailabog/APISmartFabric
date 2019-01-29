package com.APISmartFabric.Tests.catalogImportExportController;


import com.APISmartFabric.JsonBuilder.DataCatalogsContentExportJson;
import com.APISmartFabric.JsonBuilder.DataCatalogsContentVersion;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.DataCatalogsContentExportJsonRequest;
import com.APISmartFabric.controller.Controllers.DataCatalogsContentVersionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_Catalogs_Content_Export_Json_ProcessDefinition_By_ProcessDefinitionIdTest57 {

	private ObjectMapper mapper = new ObjectMapper();

	private String catalogs = "swewrfwe";
    private String processDefinitionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String invalidProcessDefinitionId="50fcgh2cf1-bc2b-4d4e-8dfhgfh1a-567658ugjghj";


	
	@Test
	public void postCatalogDataCatalogsContentExportJsonProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentExportJsonRequest dataExportJsonCatalog = new DataCatalogsContentExportJsonRequest(catalogs, processDefinitionId);

		DataCatalogsContentExportJson catalogContentExportJson = DataCatalogsContentExportJson.builder().catalogs(dataExportJsonCatalog.getCatalogs())
				.processDefinitionId(dataExportJsonCatalog.getProcessDefinitionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
				CredentialsUtils.getProperty("middleURLCatalogsExportJson") + processDefinitionId)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentExportJsonProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentExportJsonRequest dataExportJsonCatalog = new DataCatalogsContentExportJsonRequest(catalogs, processDefinitionId);

		DataCatalogsContentExportJson catalogContentExportJson = DataCatalogsContentExportJson.builder().catalogs(dataExportJsonCatalog.getCatalogs())
				.processDefinitionId(dataExportJsonCatalog.getProcessDefinitionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsExportJson") + invalidProcessDefinitionId)
				.then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentLoadVersionNoAuthentication() throws JsonProcessingException {
		DataCatalogsContentExportJsonRequest dataExportJsonCatalog = new DataCatalogsContentExportJsonRequest(catalogs, processDefinitionId);

		DataCatalogsContentExportJson catalogContentExportJson = DataCatalogsContentExportJson.builder().catalogs(dataExportJsonCatalog.getCatalogs())
				.processDefinitionId(dataExportJsonCatalog.getProcessDefinitionId()).build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsExportJson") + processDefinitionId)
				.then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
