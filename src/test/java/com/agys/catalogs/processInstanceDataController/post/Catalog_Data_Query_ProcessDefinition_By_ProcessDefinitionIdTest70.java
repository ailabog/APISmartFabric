package com.agys.catalogs.processInstanceDataController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstanceGUI;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstanceMapping;
import com.agys.jsonBuilder.CatalogDataQueryProcessDefinition;
import com.agys.utils.CredentialsUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_Query_ProcessDefinition_By_ProcessDefinitionIdTest70 {

	private ObjectMapper mapper = new ObjectMapper();

	private String string = "true";
	private String processInstanceId ="4525f6a0-f5a3-4120-9c20-933260bf37a1";


	CatalogDataQueryProcessDefinition catalogDataQueryProcessDefinition = CatalogDataQueryProcessDefinition.builder().string(string)
	.build();

	@Test
	public void postCatalogDataQueryProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDataQueryProcessDefinition) + processInstanceId).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataQueryProcessDefinition + processInstanceId)
				.then()
				.statusCode(201);
	}

	@Test
	public void postCatalogDataQueryProcessDefinitionByProcessDefinitionIdNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDataQueryProcessDefinition)+  processInstanceId).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataQueryProcessDefinition + processInstanceId)
				.then()
				.statusCode(401);
	}
}
