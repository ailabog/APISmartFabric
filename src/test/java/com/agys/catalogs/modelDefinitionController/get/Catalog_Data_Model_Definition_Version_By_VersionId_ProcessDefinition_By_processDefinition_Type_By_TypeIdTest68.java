package com.agys.catalogs.modelDefinitionController.get;


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
public class Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_processDefinition_Type_By_TypeIdTest68 {

	public static final String versionId ="7f38a4f9-94d5-4f96-a545-4c43f5c2b097";
	public static final String processDefinitionId ="7f38a4f9-94d5-4f96-a545-4c43f5c2b097";
	public static final String invalidVersionId ="sdf34543-94d5-sfwew2453-a545-sfrew345435";
	public static final String invalidProcessDefinitionId ="ddd333-weer-4f96-wefw423-ewrfete4";
	public static final String nullVersionId ="null";
	public static final String nullPocessDefinitionId ="null";
	public static final String type="type";

	

	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByProcessDefinitionTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
						+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + versionId
				        + Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}
	
	
	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByProcessDefinitionTypeByTypeIdNoAuthentication() throws FileNotFoundException {
		given()
		.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
		.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}
	@Test
	public void getCatalogDataModelDefinitionVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}


	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByInvalidProcessDefinitionTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + invalidProcessDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + invalidProcessDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}

	@Test
	public void getCatalogDataModelDefinitionVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + invalidProcessDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
				.then().assertThat().statusCode(404);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + invalidVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}


	@Test
	public void getCatalogDataModelDefinitionVersionByNULLVersionIdProcessDefinitionByProcessDefinitionTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + nullVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}

	@Test
	public void getCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByNULLProcessDefinitionTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + nullPocessDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + versionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + nullPocessDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}

	@Test
	public void getCatalogDataModelDefinitionVersionByNULLVersionIdProcessDefinitionByNULLProcessDefinitionTypeByTypeId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + nullVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + nullPocessDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type)
				.then().assertThat().statusCode(400);
		log.info("Catalog_Data_Model_CoreEntities" + CredentialsUtils.getProperty("baseURLCatalogs")
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType1 + nullVersionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + nullPocessDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 + type);
	}
}
