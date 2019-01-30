package com.agys.catalogs.modelController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
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
public class Catalog_Data_Model_CoreEntitiesTest60 {
	

	@Test
	public void getGUIControlList() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
						+ Endpoints.middleURLDataModelCoreEntities)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
		+ Endpoints.middleURLDataModelCoreEntities);
	}
	
	
	@Test
	public void getGUIControlListNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelCoreEntities)
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
		+ Endpoints.middleURLDataModelCoreEntities);
	}
}
