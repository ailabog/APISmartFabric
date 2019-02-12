package com.agys.engine.processDefinitionController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Engine_Api_ProcessDefinition_Details_By_ProcessDefinitionIdTest91 {

	private String processDefinitionId="730fff63-6ffe-42ba-b645-aa97b978be6f";
	private String invalidProcessDefinitionId="3c3567853-10be-ghj-6765757-56765";
   	private String nullProcessDefinitionId="null";

    private Environments environment;

 //   @Parameters({"environment"})
  //  @BeforeTest
 //   public void setuUp(String environment) {
     //   this.environment = environment == null ? Environments.ENGINE : Environments.valueOf(environment);
  //  }

	
	@Test
	public void getEngineApiProcessDefinitionAppURLByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineApiProcessDefinitionDetails + processDefinitionId)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineApiProcessDefinitionDetails + processDefinitionId));
	}


	@Test
	public void getEngineApiProcessDefinitionAppURLByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineApiProcessDefinitionDetails + invalidProcessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineApiProcessDefinitionDetails + invalidProcessDefinitionId));
	}


	@Test
	public void getEngineApiProcessDefinitionAppURLByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineApiProcessDefinitionDetails + nullProcessDefinitionId)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineApiProcessDefinitionDetails + nullProcessDefinitionId));
	}

	@Test
	public void getEngineApiProcessDefinitionAppURLByProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineApiProcessDefinitionDetails + processDefinitionId)
				.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineApiProcessDefinitionDetails + processDefinitionId));
	}
}
