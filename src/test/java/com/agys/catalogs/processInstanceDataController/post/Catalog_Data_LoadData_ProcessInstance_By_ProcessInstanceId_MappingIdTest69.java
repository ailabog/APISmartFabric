package com.agys.catalogs.processInstanceDataController;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstance;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstanceGUI;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstanceMapping;
import com.agys.utils.CredentialsUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_LoadData_ProcessInstance_By_ProcessInstanceId_MappingIdTest69 {

	private ObjectMapper mapper = new ObjectMapper();

	private String correctTypes = "true";
	private String mapping="465465";
	private String processInstanceId ="4525f6a0-f5a3-4120-9c20-933260bf37a1";


	CatalogDataLoadDataProcessInstanceMapping catalogloadDataProcessInstanceMapping = CatalogDataLoadDataProcessInstanceMapping.builder().correctTypes(correctTypes)
			.mapping(mapping).build();

	@Test
	public void postCatalogDataLoadDataProcessInstanceByProcessInstanceIdMappingId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataProcessInstanceMapping) + processInstanceId).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataLoadDataProcessInstanceMapping + processInstanceId +
						Endpoints.middleURLDataLoadDataProcessInstanceMapping1)
				.then()
				.statusCode(201);
	}

	@Test
	public void postCatalogDataLoadDataProcessInstanceByProcessInstanceIdMappingIdNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataProcessInstanceMapping)+  processInstanceId).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataLoadDataProcessInstanceMapping + processInstanceId +
						Endpoints.middleURLDataLoadDataProcessInstanceMapping1)
				.then()
				.statusCode(401);
	}
}
