package com.APISmartFabric.Tests.catalogImportExportController;


import com.APISmartFabric.JsonBuilder.DataCatalogsContentExportVersion;
import com.APISmartFabric.JsonBuilder.DataCatalogsContentImportVersion;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.DataCatalogsContentExportVersionRequest;
import com.APISmartFabric.controller.Controllers.DataCatalogsContentImportVersionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

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

	
	@Test
	public void postCatalogDataCatalogsContentImportVersionByVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentImportVersionRequest dataImportVersionCatalog = new DataCatalogsContentImportVersionRequest(attachment, catalogs, processDefinitionId, versionId, overwtiteExisting, inactiveOther);

		DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder().overwtiteExisting(dataImportVersionCatalog.getOverwtiteExisting())
				.inactiveOther(dataImportVersionCatalog.getInactiveOther()).attachment(dataImportVersionCatalog.getAttachment()).
						catalogs(dataImportVersionCatalog.getCatalogs()).processDefinitionId(dataImportVersionCatalog.getProcessDefinitionId()).
				versionId(dataImportVersionCatalog.getVersionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
				CredentialsUtils.getProperty("middleURLCatalogsContentImportVersion") + versionId +
				CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
				processDefinitionId)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentImportVersionRequest dataImportVersionCatalog = new DataCatalogsContentImportVersionRequest(attachment, catalogs, processDefinitionId, versionId, overwtiteExisting, inactiveOther);

		DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder().overwtiteExisting(dataImportVersionCatalog.getOverwtiteExisting())
				.inactiveOther(dataImportVersionCatalog.getInactiveOther()).attachment(dataImportVersionCatalog.getAttachment()).
						catalogs(dataImportVersionCatalog.getCatalogs()).processDefinitionId(dataImportVersionCatalog.getProcessDefinitionId()).
						versionId(dataImportVersionCatalog.getVersionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsContentImportVersion") + invalidVersionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
						processDefinitionId)
				.then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentImportVersionRequest dataImportVersionCatalog = new DataCatalogsContentImportVersionRequest(attachment, catalogs, processDefinitionId, versionId, overwtiteExisting, inactiveOther);

		DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder().overwtiteExisting(dataImportVersionCatalog.getOverwtiteExisting())
				.inactiveOther(dataImportVersionCatalog.getInactiveOther()).attachment(dataImportVersionCatalog.getAttachment()).
						catalogs(dataImportVersionCatalog.getCatalogs()).processDefinitionId(dataImportVersionCatalog.getProcessDefinitionId()).
						versionId(dataImportVersionCatalog.getVersionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsContentImportVersion") + versionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
						invalidPocessDefinitionId)
				.then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentImportVersionRequest dataImportVersionCatalog = new DataCatalogsContentImportVersionRequest(attachment, catalogs, processDefinitionId, versionId, overwtiteExisting, inactiveOther);

		DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder().overwtiteExisting(dataImportVersionCatalog.getOverwtiteExisting())
				.inactiveOther(dataImportVersionCatalog.getInactiveOther()).attachment(dataImportVersionCatalog.getAttachment()).
						catalogs(dataImportVersionCatalog.getCatalogs()).processDefinitionId(dataImportVersionCatalog.getProcessDefinitionId()).
						versionId(dataImportVersionCatalog.getVersionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsContentImportVersion") + invalidVersionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
						invalidPocessDefinitionId)
				.then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentImportVersionByVersionIdProcessDefinitionByProcessDefinitionIdNoAuthentication() throws JsonProcessingException {
		DataCatalogsContentImportVersionRequest dataImportVersionCatalog = new DataCatalogsContentImportVersionRequest(attachment, catalogs, processDefinitionId, versionId, overwtiteExisting, inactiveOther);

		DataCatalogsContentImportVersion catalogContentImportVersion = DataCatalogsContentImportVersion.builder().overwtiteExisting(dataImportVersionCatalog.getOverwtiteExisting())
				.inactiveOther(dataImportVersionCatalog.getInactiveOther()).attachment(dataImportVersionCatalog.getAttachment()).
						catalogs(dataImportVersionCatalog.getCatalogs()).processDefinitionId(dataImportVersionCatalog.getProcessDefinitionId()).
						versionId(dataImportVersionCatalog.getVersionId()).build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentImportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsContentImportVersion") + versionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
						processDefinitionId)
				.then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
