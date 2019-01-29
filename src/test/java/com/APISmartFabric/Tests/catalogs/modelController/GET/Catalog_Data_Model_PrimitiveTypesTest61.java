package com.APISmartFabric.Tests.catalogs.modelController.GET;


import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.jayway.restassured.RestAssured.given;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Catalog_Data_Model_PrimitiveTypesTest61 {
	

	@Test
	public void getCatalog_Data_Model_PrimitiveTypes() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
						+ CredentialsUtils.getProperty("middleURLDataModelPrimitiveTypes"))
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_PrimitiveTypes" + CredentialsUtils.getProperty("baseURLCatalogs")
		+ CredentialsUtils.getProperty("middleURLDataModelPrimitiveTypes"));
	}
	
	
	@Test
	public void getCatalog_Data_Model_PrimitiveTypesNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ CredentialsUtils.getProperty("middleURLDataModelPrimitiveTypes"))
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_PrimitiveTypes" + CredentialsUtils.getProperty("baseURLCatalogs")
		+ CredentialsUtils.getProperty("middleURLDataModelPrimitiveTypes"));
	}
}
