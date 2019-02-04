package com.agys.catalogs.catalogImportExportController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.DataCatalogsContentExportJson;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_Catalogs_Content_Export_Json_ProcessDefinition_By_ProcessDefinitionIdTest59 {

	private ObjectMapper mapper = new ObjectMapper();

	private String catalogs = "swewrfwe";
    private String processDefinitionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String invalidProcessDefinitionId="50fcgh2cf1-bc2b-4d4e-8dfhgfh1a-567658ugjghj";
	DataCatalogsContentExportJson catalogContentExportJson = DataCatalogsContentExportJson.builder().catalogs(catalogs)
			.processDefinitionId(processDefinitionId).build();

	
	@Test(description = "ceva")
	public void postCatalogDataCatalogsContentExportJsonProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
				Endpoints.middleURLCatalogsExportJson + processDefinitionId)
				.then()
				.statusCode(201);
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
