package com.agys.catalogs.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.DataCatalogsDefinitionVersion;
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
public class Catalog_Data_Catalogs_Definition_Version_By_Versionid_ProcessDefinition_By_ProcessDefinitionIdTest55 {

	private ObjectMapper mapper = new ObjectMapper();

	private String description = "this is a field description";
	private String idFields="5666";
	private String nameFields ="nameFileds";
	private String type="dfghf";
	private String idDescription="508b2cf1-bc2b-4d4e-8d1a-d5f85c4e8177";
	private String nameDescription="this is a description";
	private String removed="yes";
	private String versionId ="345643456546";
	private String processDefinitionId="364545654";

	DataCatalogsDefinitionVersion catalogDefinitionVersion = DataCatalogsDefinitionVersion.builder().description(description)
			.idFields(idFields).nameFields(nameFields).
					type(type).idDescription(idDescription).
					nameDescription(nameDescription).removed(removed).
					build();
	
	@Test
	public void postCatalogDataCatalogsContentLoadVersion() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDefinitionVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionId +
						Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataCatalogsContentLoadVersionNoAuthentication() throws JsonProcessingException {
			given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogDefinitionVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataCatalogsDefinitionVersion1 + versionId +
						Endpoints.middleURLDataCatalogsDefinitionVersion2 + processDefinitionId)
				.then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}