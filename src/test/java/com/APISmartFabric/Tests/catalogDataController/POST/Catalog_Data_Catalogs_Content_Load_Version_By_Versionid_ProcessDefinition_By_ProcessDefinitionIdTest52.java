package com.APISmartFabric.Tests.catalogDataController.POST;


import com.APISmartFabric.JsonBuilder.DataCatalogsContentVersion;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.DataCatalogsContentVersionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Catalog_Data_Catalogs_Content_Load_Version_By_Versionid_ProcessDefinition_By_ProcessDefinitionIdTest52 {

	private ObjectMapper mapper = new ObjectMapper();

	private String filters = "swewrfwe";
	private String options="wesr";
	private String all_languages="swerw";
	private String ascending ="dgDF";
	private String sort_by="dfghf";
	private String type="FGhg";
	private String versionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String processDefinitionId="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";

	
	@Test
	public void postCatalogDataCatalogsContentLoadVersion() throws JsonProcessingException {

		DataCatalogsContentVersionRequest dataCatalog = new DataCatalogsContentVersionRequest(filters, options, all_languages, ascending, sort_by, type);
		DataCatalogsContentVersion catalogContentVersion = DataCatalogsContentVersion.builder().filters(dataCatalog.getFilters())
				.options(dataCatalog.getOptions()).all_languages(dataCatalog.getAll_languages()).
						ascending(dataCatalog.getAscending()).sort_by(dataCatalog.getSort_by()).
				type(dataCatalog.getType()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + CredentialsUtils.getProperty("middleURLDataCatalogsContentLoadVersion1") + versionId +
				CredentialsUtils.getProperty("middleURLDataCatalogsContentLoadVersion2") + processDefinitionId)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentLoadVersionNoAuthentication() throws JsonProcessingException {
		DataCatalogsContentVersionRequest dataCatalog = new DataCatalogsContentVersionRequest(filters, options, all_languages, ascending, sort_by, type);
		DataCatalogsContentVersion catalogContentVersion = DataCatalogsContentVersion.builder().filters(dataCatalog.getFilters())
				.options(dataCatalog.getOptions()).all_languages(dataCatalog.getAll_languages()).
						ascending(dataCatalog.getAscending()).sort_by(dataCatalog.getSort_by()).
						type(dataCatalog.getType()).build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + CredentialsUtils.getProperty("middleURLDataCatalogsContentLoadVersion1") + versionId +
						CredentialsUtils.getProperty("middleURLDataCatalogsContentLoadVersion2") + processDefinitionId)
				.then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
