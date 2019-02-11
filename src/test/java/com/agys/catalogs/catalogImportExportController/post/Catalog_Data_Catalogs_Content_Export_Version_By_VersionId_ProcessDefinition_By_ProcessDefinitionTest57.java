package com.agys.catalogs.catalogImportExportController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DataCatalogsContentExportJson;
import com.agys.jsonBuilder.DataCatalogsContentExportVersion;
import com.agys.model.Factory;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Catalog_Data_Catalogs_Content_Export_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionTest57 {

	private ObjectMapper mapper = new ObjectMapper();

	private String catalogs = "swewrfwe";
    private String processDefinitionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String versionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String invalidVersionId="ergertgryrt456546-dsfgdfg3465-34645654ergfd-dfgfdg666";
	private String invalidProcessDefinitionId="5087567fgjhgcf1-bcfgvjhgjb-4d4e-8d1a-d5f85gfyjghjrt8177";
	DataCatalogsContentExportVersion catalogContentExportVersion = DataCatalogsContentExportVersion.builder().catalogs(catalogs)
			.processDefinitionId(processDefinitionId).versionId(versionId).build();

	private Environments environment;

	@Parameters({"environment"})
	@BeforeTest
	public void setuUp(String environment) {
		this.environment = environment == null ? Environments.CATALOGS : Environments.valueOf(environment);
	}

	
	@Test
	public void postCatalogDataCatalogsContentExportVersionByVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentExportVersion catalogContentExportVersion = DataCatalogsContentExportVersion.builder().catalogs(catalogs)
				.processDefinitionId(processDefinitionId).versionId(versionId).build();

		ValidatableResponse vr = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLCatalogsContentExportVersion + versionId +
						Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						processDefinitionId)
				.then()
				.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentExportVersion)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		DataCatalogsContentExportJson createCatalogsExportVersion = JsonHelper.readValue(response, DataCatalogsContentExportJson.class);
		assertEquals(Factory.catalogContentExportVersion.getCatalogs(), createCatalogsExportVersion.getCatalogs(), "The catalogs are equals");
		assertEquals(Factory.catalogContentExportVersion.getProcessDefinitionId(), createCatalogsExportVersion.getProcessDefinitionId(), "The process definition ids are equals");
		assertEquals(Factory.catalogContentExportVersion.getVersionId(), createCatalogsExportVersion.getVersionId(), "The version ids are equals");
		Factory.catalogContentExportVersion.setProcessDefinitionId(createCatalogsExportVersion.getProcessDefinitionId());
		Factory.catalogContentExportVersion.setVersionId(createCatalogsExportVersion.getVersionId());
	}

	@Test
	public void postCatalogDataCatalogsContentExportVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLCatalogsContentExportVersion + invalidVersionId +
						Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						processDefinitionId)
				.then()
				.statusCode(404);
	}

	@Test
	public void postCatalogDataCatalogsContentExportVersionByVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLCatalogsContentExportVersion + versionId +
								Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						invalidProcessDefinitionId)
				.then()
				.statusCode(404);
	}

	@Test
	public void postCatalogDataCatalogsContentExportVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

			given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLCatalogsContentExportVersion + invalidVersionId +
						Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						invalidProcessDefinitionId)
				.then()
					.statusCode(404);
	}

	@Test
	public void postCatalogDataCatalogsContentExportVersionByVersionIdProcessDefinitionByProcessDefinitionIdNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLCatalogsContentExportVersion + versionId +
						Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						processDefinitionId)
				.then()
				.statusCode(401);
	}
}
