package com.agys.catalogs.modelController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Catalog_Data_Model_PrimitiveTypesTest61 {

	private Environments environment;

	@Parameters({"environment"})
	@BeforeTest
	public void setuUp(String environment) {
		this.environment = environment == null ? Environments.CATALOGS : Environments.valueOf(environment);
	}
	

	@Test
	public void getCatalog_Data_Model_PrimitiveTypes() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs") +
				Endpoints.middleURLDataModelPrimitiveTypes)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_PrimitiveTypes" + CredentialsUtils.getProperty("baseURLCatalogs")
		+ Endpoints.middleURLDataModelPrimitiveTypes);
	}
	
	
	@Test
	public void getCatalog_Data_Model_PrimitiveTypesNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelPrimitiveTypes)
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_PrimitiveTypes" + CredentialsUtils.getProperty("baseURLCatalogs")
		+ Endpoints.middleURLDataModelPrimitiveTypes);
	}
}
