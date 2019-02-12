package com.agys.engine.processDefinitionController.get;


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
 * @author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Engine_Api_ProcessDefinition_By_ProcessDefinitionIdActivateTest83 {

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
	public void getEngineApiProcessDefinitionByProcessDefinitionIdActivate() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineApiProcessDefinition + processDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition1)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineApiProcessDefinition + processDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition1));
	}


	@Test
	public void getEngineApiProcessDefinitionByInvalidProcessDefinitionIdActivate() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineApiProcessDefinition + invalidProcessDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition1)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineApiProcessDefinition + invalidProcessDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition1));
	}


	@Test
	public void getEngineApiProcessDefinitionByNULLProcessDefinitionIdActivate() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineApiProcessDefinition + nullProcessDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition1)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineApiProcessDefinition + nullProcessDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition1));
	}

	@Test
	public void getEngineApiProcessDefinitionByProcessDefinitionIdActivateNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineApiProcessDefinition + processDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition1)
				.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineApiProcessDefinition + processDefinitionId +  Endpoints.middleURLEngineApiProcessDefinition1));
	}
}