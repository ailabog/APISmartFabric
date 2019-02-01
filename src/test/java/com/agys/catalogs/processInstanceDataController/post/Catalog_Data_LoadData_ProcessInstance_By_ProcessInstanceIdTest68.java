package com.agys.catalogs.processInstanceDataController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.CatalogDataLoadDataInternal;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstance;
import com.agys.utils.CredentialsUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_LoadData_ProcessInstance_By_ProcessInstanceIdTest68 {

	private ObjectMapper mapper = new ObjectMapper();

	private String catalogData = "true";
	private String embeddedData="true";
	private String processInstanceId ="730f2a54-b71b-30f3-2bce-1e0e8b0e6f52";

	CatalogDataLoadDataProcessInstance catalogloadDataProcessInstance = CatalogDataLoadDataProcessInstance.builder().catalogData(catalogData)
			.embeddedData(embeddedData).build();

	@Test
	public void postCatalogDataLoadDataProcessInstanceByProcessInstanceId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataProcessInstance) + processInstanceId).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataLoadDataProcessDefinition)
				.then()
				.statusCode(201);
	}

	@Test
	public void postCatalogDataLoadDataInternalNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataProcessInstance)+ processInstanceId).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataLoadDataProcessDefinition)
				.then()
				.statusCode(401);
	}
}
