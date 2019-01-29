package com.APISmartFabric.Tests.catalogImportExportController;


import com.APISmartFabric.JsonBuilder.DataCatalogsContentExportJson;
import com.APISmartFabric.JsonBuilder.DataCatalogsContentExportVersion;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.DataCatalogsContentExportJsonRequest;
import com.APISmartFabric.controller.Controllers.DataCatalogsContentExportVersionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_Catalogs_Content_Export_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionTest57 {

	private ObjectMapper mapper = new ObjectMapper();

	private String catalogs = "swewrfwe";
    private String processDefinitionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String versionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String invalidVersionId="ergertgryrt456546-dsfgdfg3465-34645654ergfd-dfgfdg666";
	private String invalidProcessDefinitionId="5087567fgjhgcf1-bcfgvjhgjb-4d4e-8d1a-d5f85gfyjghjrt8177";

	
	@Test
	public void postCatalogDataCatalogsContentExportVersionByVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentExportVersionRequest dataExportVersionCatalog = new DataCatalogsContentExportVersionRequest(catalogs, processDefinitionId, versionId);

		DataCatalogsContentExportVersion catalogContentExportVersion = DataCatalogsContentExportVersion.builder().catalogs(dataExportVersionCatalog.getCatalogs())
				.processDefinitionId(dataExportVersionCatalog.getProcessDefinitionId()).versionId(dataExportVersionCatalog.getVresionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
				CredentialsUtils.getProperty("middleURLCatalogsContentExportVersion") + versionId +
				CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
				processDefinitionId)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentExportVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentExportVersionRequest dataExportVersionCatalog = new DataCatalogsContentExportVersionRequest(catalogs, processDefinitionId, versionId);

		DataCatalogsContentExportVersion catalogContentExportVersion = DataCatalogsContentExportVersion.builder().catalogs(dataExportVersionCatalog.getCatalogs())
				.processDefinitionId(dataExportVersionCatalog.getProcessDefinitionId()).versionId(dataExportVersionCatalog.getVresionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsContentExportVersion") + invalidVersionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
						processDefinitionId)
				.then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentExportVersionByVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentExportVersionRequest dataExportVersionCatalog = new DataCatalogsContentExportVersionRequest(catalogs, processDefinitionId, versionId);

		DataCatalogsContentExportVersion catalogContentExportVersion = DataCatalogsContentExportVersion.builder().catalogs(dataExportVersionCatalog.getCatalogs())
				.processDefinitionId(dataExportVersionCatalog.getProcessDefinitionId()).versionId(dataExportVersionCatalog.getVresionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsContentExportVersion") + versionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
						invalidProcessDefinitionId)
				.then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentExportVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws JsonProcessingException {

		DataCatalogsContentExportVersionRequest dataExportVersionCatalog = new DataCatalogsContentExportVersionRequest(catalogs, processDefinitionId, versionId);

		DataCatalogsContentExportVersion catalogContentExportVersion = DataCatalogsContentExportVersion.builder().catalogs(dataExportVersionCatalog.getCatalogs())
				.processDefinitionId(dataExportVersionCatalog.getProcessDefinitionId()).versionId(dataExportVersionCatalog.getVresionId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsContentExportVersion") + invalidVersionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
						invalidProcessDefinitionId)
				.then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentExportVersionByVersionIdProcessDefinitionByProcessDefinitionIdNoAuthentication() throws JsonProcessingException {
		DataCatalogsContentExportVersionRequest dataExportVersionCatalog = new DataCatalogsContentExportVersionRequest(catalogs, processDefinitionId, versionId);

		DataCatalogsContentExportVersion catalogContentExportVersion = DataCatalogsContentExportVersion.builder().catalogs(dataExportVersionCatalog.getCatalogs())
				.processDefinitionId(dataExportVersionCatalog.getProcessDefinitionId()).versionId(dataExportVersionCatalog.getVresionId()).build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentExportVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") +
						CredentialsUtils.getProperty("middleURLCatalogsContentExportVersion") + versionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentSaveVersion2") +
						processDefinitionId)
				.then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
