package com.APISmartFabric.Tests.catalogs.modelController;


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
public class Catalog_Data_Model_Versions_By_VersionIdTest62 {

	private String versionId="1f8a0de9-a639-428b-9921-641898475a9b";
	private String invalidVersionId="sfsd34654-sdf34654-w35t4356-sdgfdg";
	private String nullVersionId="null";
	

	@Test
	public void getCatalog_Data_Model_Versions_By_VersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
						+ CredentialsUtils.getProperty("middleURLDataModelVersions"))
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_Versions_By_VersionId" + CredentialsUtils.getProperty("baseURLCatalogs")
		+ CredentialsUtils.getProperty("middleURLDataModelVersions") + versionId);
	}

	@Test
	public void getCatalog_Data_Model_Versions_By_InvalidVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ CredentialsUtils.getProperty("middleURLDataModelVersions"))
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_Versions_By_VersionId" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ CredentialsUtils.getProperty("middleURLDataModelVersions") + invalidVersionId);
	}

	@Test
	public void getCatalog_Data_Model_Versions_By_NULLVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ CredentialsUtils.getProperty("middleURLDataModelVersions"))
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Model_Versions_By_VersionId" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ CredentialsUtils.getProperty("middleURLDataModelVersions") + nullVersionId);
	}
	
	
	@Test
	public void Catalog_Data_Model_Versions_By_VersionIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ CredentialsUtils.getProperty("middleURLDataModelVersions"))
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_Versions_By_VersionId" + CredentialsUtils.getProperty("baseURLCatalogs")
		+ CredentialsUtils.getProperty("middleURLDataModelVersions") + versionId);
	}
}
