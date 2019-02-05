package com.agys.catalogs.processInstanceDataController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.CatalogDataLoadDataInternal;
import com.agys.jsonBuilder.CatalogDataLoadDataProcessInstanceMapping;
import com.agys.model.Factory;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Catalog_Data_LoadData_ProcessInstance_By_ProcessInstanceId_Gui_By_GuiIdTest71 {

	private ObjectMapper mapper = new ObjectMapper();

	private String correctTypes = "true";
	private String mapping="465465";
	private String processInstanceId ="4525f6a0-f5a3-4120-9c20-933260bf37a1";
	private String guiId ="4525f6a0-f5a3-4120-9c20-933260bf37a1";

	CatalogDataLoadDataProcessInstanceMapping catalogloadDataProcessInstanceMapping = CatalogDataLoadDataProcessInstanceMapping.builder().correctTypes(correctTypes)
			.mapping(mapping).build();

	@Test
	public void postCatalogDataLoadDataProcessInstanceByProcessInstanceIdGuiByGuiId() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataProcessInstanceMapping) + processInstanceId).when()
						.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataLoadDataProcessInstanceGUI + processInstanceId +
								Endpoints.middleURLDataLoadDataProcessInstanceGUI1 + guiId)
						.then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.dataModelDefVersion)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		CatalogDataLoadDataProcessInstanceMapping catalogDataLoadDataProcessInstanceMapping= JsonHelper.readValue(response, CatalogDataLoadDataProcessInstanceMapping.class);
		assertEquals(Factory.catalogDataLoadDataProcessInstanceMapp.getMapping(), catalogDataLoadDataProcessInstanceMapping.getMapping(), "Mappings are equals");
	}

	@Test
	public void postCatalogDataLoadDataProcessInstanceByProcessInstanceIdGuiByGuiIdNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogloadDataProcessInstanceMapping)+  processInstanceId).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs")  + Endpoints.middleURLDataLoadDataProcessInstanceGUI + processInstanceId +
						Endpoints.middleURLDataLoadDataProcessInstanceGUI1 + guiId)
				.then()
				.statusCode(401);
	}
}
