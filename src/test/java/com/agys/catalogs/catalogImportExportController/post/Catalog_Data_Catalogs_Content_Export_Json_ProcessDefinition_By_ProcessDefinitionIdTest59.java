package com.agys.catalogs.catalogImportExportController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.DataCatalogsContentExportJson;
import com.agys.model.Factory;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.JsonHelper;
import com.agys.utils.RensposeBodyDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Catalog_Data_Catalogs_Content_Export_Json_ProcessDefinition_By_ProcessDefinitionIdTest59 {

	private ObjectMapper mapper = new ObjectMapper();

	private String catalogs = "swewrfwe";
    private String processDefinitionId="5f8e91e3-cf30-4b21-ad97-dd110816b109";
  	private String invalidProcessDefinitionId="50fcgh2cf1-bc2b-4d4e-8dfhgfh1a-567658ugjghj";
	DataCatalogsContentExportJson catalogContentExportJson = DataCatalogsContentExportJson.builder().catalogs(catalogs)
			.processDefinitionId(processDefinitionId).build();

	
	@Test
	public void postCatalogDataCatalogsContentExportJsonProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentExportJson catalogContentExportJson = DataCatalogsContentExportJson.builder().catalogs(catalogs)
				.processDefinitionId(processDefinitionId).build();

		ValidatableResponse vr = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLCatalogsExportJson + processDefinitionId)
				.then()
				.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportJson)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		DataCatalogsContentExportJson createCatalogsVersion = JsonHelper.readValue(response, DataCatalogsContentExportJson.class);
		assertEquals(Factory.catalogContentExportJson.getCatalogs(), createCatalogsVersion.getCatalogs(), "The catalogs are equals");
		assertEquals(Factory.catalogContentExportJson.getProcessDefinitionId(), createCatalogsVersion.getProcessDefinitionId(), "The process definition ids are equals");


		Factory.catalogContentExportVersion.setProcessDefinitionId(createCatalogsVersion.getProcessDefinitionId());

	}

	@Test
	public void postCatalogDataCatalogsContentExportJsonProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLCatalogsExportJson + invalidProcessDefinitionId)
				.then()
				.statusCode(404);
	}

	@Test
	public void postCatalogDataCatalogsContentLoadVersionNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLCatalogsExportJson + processDefinitionId)
				.then()
				.statusCode(401);
	}
}
