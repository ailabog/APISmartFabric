package com.agys.catalogs.modelDefinitionController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.DataCatalogsContentVersion;
import com.agys.jsonBuilder.DataModelDefinitionVersion;
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
public class Catalog_Data_Model_Definition_Version_By_VersionId_ProcessDefinition_By_ProcessDefinition_Type_By_TypeTest70 {

	private ObjectMapper mapper = new ObjectMapper();

	private String diagram = "swewrfwe";
	private String fieldsId="wesr";
	private String fieldsBCReady="swerw";
	private String fieldsEmbeded ="dgDF";
	private String fieldsIndexable="dfghf";
	private String fieldsList="FGhg";
	private String fieldName="field";
	private String fieldType="type";
	private String id="508b2cf1-as2b-4d4e-8d1a-h7f85c4e8177";
	private String isBCReady="true";
	private String name="ThisIsAName";
	private String type="type1";
	public static final String versionId ="1f8a0de9-a639-428b-9921-641898475a9b";
	public static final String processDefinitionId ="1f8a0de9-a639-428b-9921-641898475a9b";


	DataModelDefinitionVersion catalogModelDefinitionVersion = DataModelDefinitionVersion.builder().diagram(diagram)
			.fieldsId(fieldsId).fieldisBCReady(fieldsBCReady).
					fieldisEmbeded(fieldsEmbeded).fieldisIndexable(fieldsIndexable).fieldisList(fieldsList).
			fieldName(fieldName).fieldType(fieldType).id(id).isBCReady(isBCReady).name(name).
					type(type).build();

	@Test
	public void postCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByProcessDefinitionTypeByType() throws JsonProcessingException {


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogModelDefinitionVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataModelDefinitionVersion1 + versionId +
						Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
				+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 +type)
				.then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postCatalogDataModelDefinitionVersionByVersionIdProcessDefinitionByProcessDefinitionTypeByTypeNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(catalogModelDefinitionVersion)).when()
				.post(CredentialsUtils.getProperty("baseURLCatalogs") + Endpoints.middleURLDataModelDefinitionVersion1 + versionId +
						Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType2 + processDefinitionId
						+ Endpoints.middleURLDataModelDefinitionVersionProcessDefinitionType3 +type)
				.then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
