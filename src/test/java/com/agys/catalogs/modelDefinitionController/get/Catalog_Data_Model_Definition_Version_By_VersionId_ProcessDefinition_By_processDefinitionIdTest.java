package com.agys.catalogs.modelDefinitionController.get;


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
public class Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinitionIdTest {

	public static final String versionId ="7f38a4f9-94d5-4f96-a545-4c43f5c2b097";
	public static final String processDefinitionId ="7f38a4f9-94d5-4f96-a545-4c43f5c2b097";
	public static final String invalidVersionId ="sdf34543-94d5-sfwew2453-a545-sfrew345435";
	public static final String invalidProcessDefinitionId ="ddd333-weer-4f96-wefw423-ewrfete4";
	public static final String nullVersionId ="null";
	public static final String nullProcessDefinitionId ="null";

	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
						+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + versionId
				        + Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + processDefinitionId)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + processDefinitionId);
	}
	
	
	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given()
		.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + processDefinitionId)
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinitionId" + CredentialsUtils.CATALOGS
		 + Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + processDefinitionId);
	}
	@Test
	public void getCatalogDataModelDefinitionVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + invalidProcessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + invalidProcessDefinitionId);
	}


	@Test
	public void getCatalogDataModelDefinitionVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + processDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + processDefinitionId);
	}

	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + invalidProcessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + invalidProcessDefinitionId);
	}


	@Test
	public void getCatalogDataModelDefinitionVersionByNULLVersionIdProcessDefinitionByINULLProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + nullVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + nullProcessDefinitionId)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + nullVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + nullProcessDefinitionId);
	}

	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + nullProcessDefinitionId)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + nullProcessDefinitionId);
	}

	@Test
	public void getCatalogDataModelDefinitionVersionByNULLVersionIdProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + nullVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + processDefinitionId)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinitionId" + CredentialsUtils.CATALOGS
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition + nullVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinition1 + processDefinitionId);
	}
}
