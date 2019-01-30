package com.agys.catalogs.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.DataCatalogsContentVersion;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
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

	DataCatalogsContentVersion catalogContentVersion = DataCatalogsContentVersion.builder().filters(filters)
			.options(options).all_languages(all_languages).
					ascending(ascending).sort_by(sort_by).
					type(type).build();

	@Test
	public void postCatalogDataCatalogsContentLoadVersion() throws JsonProcessingException {


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataCatalogsContentLoadVersion1 + versionId +
						Endpoints.middleURLDataCatalogsContentLoadVersion2 + processDefinitionId)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentLoadVersionNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogContentVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataCatalogsContentLoadVersion1 + versionId +
						Endpoints.middleURLDataCatalogsContentLoadVersion2 + processDefinitionId)
				.then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
