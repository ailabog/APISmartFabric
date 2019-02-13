package com.agys.catalogs.catalogImportExportController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.DataCatalogsContentImportVersion;
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
public class Catalog_Data_Catalogs_Content_Import_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionTest58 {

	private ObjectMapper mapper = new ObjectMapper();
	private String overwriteExisting="false";
    private String inactiveOther="false";
    private String attachment ="35345345";
	private String catalogs = "swewrfwe";
    private String processDefinitionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String versionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String invalidPocessDefinitionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String invalidVersionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder().
			overwriteExisting(overwriteExisting)
			.inactiveOther(inactiveOther).attachment(attachment).
					catalogs(catalogs).processDefinitionId(processDefinitionId).
					versionId(versionId).build();

	@Test
	public void postCatalogDataCatalogsContentImportVersionByVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder().
				overwriteExisting(overwriteExisting)
				.inactiveOther(inactiveOther).attachment(attachment).
						catalogs(catalogs).processDefinitionId(processDefinitionId).
						versionId(versionId).build();

		ValidatableResponse vr = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.CATALOGS +
						Endpoints.middleURLCatalogsContentImportVersion + versionId +
						Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						processDefinitionId)
				.then()
				.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.catalogContentImportVersion)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		DataCatalogsContentImportVersion createCatalogsContentImportVersion= JsonHelper.readValue(response, DataCatalogsContentImportVersion.class);
		assertEquals(Factory.catalogContentImportVersion.getCatalogs(), createCatalogsContentImportVersion.getCatalogs(), "The catalogs are equals");
		assertEquals(Factory.catalogContentImportVersion.getProcessDefinitionId(), createCatalogsContentImportVersion.getProcessDefinitionId(), "The process definition ids are equals");
		assertEquals(Factory.catalogContentImportVersion.getVersionId(), createCatalogsContentImportVersion.getVersionId(), "The version ids are equals");
		assertEquals(Factory.catalogContentImportVersion.getOverwriteExisting(), createCatalogsContentImportVersion.getOverwriteExisting(), "The overwriting are equals");
		assertEquals(Factory.catalogContentImportVersion.getInactiveOther(), createCatalogsContentImportVersion.getInactiveOther(), "The inactive others are equals");
		Factory.catalogContentImportVersion.setProcessDefinitionId(createCatalogsContentImportVersion.getProcessDefinitionId());
		Factory.catalogContentImportVersion.setVersionId(createCatalogsContentImportVersion.getVersionId());
	}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.CATALOGS +
								Endpoints.middleURLCatalogsContentImportVersion + invalidVersionId +
								Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						processDefinitionId)
				.then()
				.statusCode(404);
		}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

	given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.CATALOGS +
								Endpoints.middleURLCatalogsContentImportVersion + versionId +
								Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						invalidPocessDefinitionId)
				.then()
			.statusCode(404);

	}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

	given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.CATALOGS +
								Endpoints.middleURLCatalogsContentImportVersion + invalidVersionId +
								Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						invalidPocessDefinitionId)
				.then()
			.statusCode(404);
	}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByVersionIdProcessDefinitionByProcessDefinitionIdNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.CATALOGS +
								Endpoints.middleURLCatalogsContentImportVersion + versionId +
								Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						processDefinitionId)
				.then()
				.statusCode(401);
	}
}
