package com.agys.catalogs.catalogDefinitionController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.enums.ProcessDefinitionEnum;
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
public class Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionIdTest54 {

	private ProcessDefinitionEnum PROCESS_DEFINITION;
	private String versionId="235443534566";
	private String versionIdOK="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private Environments environment;

	@Parameters({"environment"})
	@BeforeTest
	public void setuUp(String environment) {
		this.environment = environment == null ? Environments.CATALOGS : Environments.valueOf(environment);
	}

	
	@Test
	public void getDataCatalogsDefinitionVersionByVersionIdProcessDefinitionIdByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLCatalogs")
						+ Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionId +
						Endpoints.middleURLDataCatalogsDefinitionVersion2 + PROCESS_DEFINITION.PROCESS_DEFINITION_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + PROCESS_DEFINITION.PROCESS_DEFINITION_INVALID.getId()));
	}

	@Test
	public void getDataCatalogsDefinitionVersionByVersionIdProcessDefinitionIdByProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLCatalogs")
						+ Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionIdOK +
						Endpoints.middleURLDataCatalogsDefinitionVersion2 + PROCESS_DEFINITION.PROCESS_DEFINITION_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionIdOK +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + PROCESS_DEFINITION.PROCESS_DEFINITION_OK1.getId()));
	}

	@Test
	public void getDataCatalogsDefinitionVersionByVersionIdProcessDefinitionIdByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionId +
						Endpoints.middleURLDataCatalogsDefinitionVersion2 + PROCESS_DEFINITION.PROCESS_DEFINITION_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionId +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + PROCESS_DEFINITION.PROCESS_DEFINITION_NULL.getId()));
	}

	@Test
	public void getDataCatalogsDefinitionVersionByVersionIdProcessDefinitionIdByProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionIdOK +
						Endpoints.middleURLDataCatalogsDefinitionVersion2 + PROCESS_DEFINITION.getId())
				.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + (CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionIdOK +
				Endpoints.middleURLDataCatalogsDefinitionVersion2 + PROCESS_DEFINITION.PROCESS_DEFINITION_OK1.getId()));
	}
}
