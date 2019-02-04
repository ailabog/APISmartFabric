package com.agys.catalogs.catalogImportExportController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.DataCatalogsContentImportVersion;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_Catalogs_Content_Import_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionTest58 {

	private ObjectMapper mapper = new ObjectMapper();
	private String overwtiteExisting="false";
    private String inactiveOther="false";
    private String attachment ="35345345";
	private String catalogs = "swewrfwe";
    private String processDefinitionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String versionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String invalidPocessDefinitionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String invalidVersionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder().
			overwtiteExisting(overwtiteExisting)
			.inactiveOther(inactiveOther).attachment(attachment).
					catalogs(catalogs).processDefinitionId(processDefinitionId).
					versionId(versionId).build();

	@Test
	public void postCatalogDataCatalogsContentImportVersionByVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

	given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						Endpoints.middleURLCatalogsContentImportVersion + versionId +
								Endpoints.middleURLDataCatalogsContentSaveVersion2 +
				processDefinitionId)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
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
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
								Endpoints.middleURLCatalogsContentImportVersion + versionId +
								Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						invalidPocessDefinitionId)
				.then()
			.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

	given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
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
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
								Endpoints.middleURLCatalogsContentImportVersion + versionId +
								Endpoints.middleURLDataCatalogsContentSaveVersion2 +
						processDefinitionId)
				.then()
				.statusCode(401);
	}
}
