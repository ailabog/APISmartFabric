package com.APISmartFabric.Tests.catalogs.modelController.POST;


import com.APISmartFabric.JsonBuilder.DataModelJsonPath;
import com.APISmartFabric.JsonBuilder.SystemLogin;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.DataModelJsonPathRequest;
import com.APISmartFabric.controller.Controllers.SystemLoginRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * @author aila.bogasieru@agys.ch
 */

@Slf4j

public class Catalog_Data_Model_JsonPathTest64 {

	private ObjectMapper mapper = new ObjectMapper();


	@Test
	public void postCatalog_Data_Model_JsonPath() throws JsonProcessingException {
		final String json = "{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }";
		final String path = "//users/downloads/something";
		final String type = "type";
	
		DataModelJsonPathRequest dataModelJsonPath = new DataModelJsonPathRequest(json, path, type);

		DataModelJsonPath dataModelJsonPathBuilder = DataModelJsonPath.builder().json(dataModelJsonPath.getJson())
				.path(dataModelJsonPath.getPath()).type(dataModelJsonPath.getType()).build();


		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
	            .contentType(ContentType.JSON).body(mapper.writeValueAsString(dataModelJsonPathBuilder)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + CredentialsUtils.getProperty("middleURLDataModelJsonPath")).then()
				.statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void posCatalog_Data_Model_JsonPathNoAuthentication() throws JsonProcessingException {
		final String json = "{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }";
		final String path = "//users/downloads/something";
		final String type = "type";

		DataModelJsonPathRequest dataModelJsonPath = new DataModelJsonPathRequest(json, path, type);

		DataModelJsonPath dataModelJsonPathBuilder = DataModelJsonPath.builder().json(dataModelJsonPath.getJson())
				.path(dataModelJsonPath.getPath()).type(dataModelJsonPath.getType()).build();


		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(dataModelJsonPathBuilder)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + CredentialsUtils.getProperty("middleURLDataModelJsonPath")).then()
				.statusCode(401);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
