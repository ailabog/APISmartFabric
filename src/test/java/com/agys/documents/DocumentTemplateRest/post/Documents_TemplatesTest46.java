package com.agys.documents.documentTemplateRest.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.DocumentsTemplates;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * @author aila.bogasieru@agys.ch
 */

@Slf4j

public class Documents_TemplatesTest46 {

	private ObjectMapper mapper = new ObjectMapper();

	private String description = "Description";
	private String h = "0";
	private String id = "d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String isActive = "true";
	private String isAdvanced = "yes";
	private String iteration = "yes";
	private String name = "AutomatedDocumentsApi";
	private String ownerId = "d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String processDefinitionId = "d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String template = "346546$";
	private String usedAttributes = "24";
	private String versionId = "d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String w = "0";
	DocumentsTemplates docsTemplates = DocumentsTemplates.builder().description(description)
			.h(h).id(id).isActive(isActive).
					isAdvanced(isAdvanced).iteration(iteration).name(name).
					ownerId(ownerId).processDefinitionId(processDefinitionId).template(template).usedAttributes(usedAttributes).versionId(versionId).
					w(w).build();

	@Test
	public void postDocumentsTemplates() throws JsonProcessingException {


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).
				contentType(ContentType.JSON).body(mapper.writeValueAsString(docsTemplates)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + Endpoints.middleURLDocumentsTemplates).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());

	}

	@Test
	public void postDocumentsTemplatesNoAuthentication() throws JsonProcessingException {

		given().
				contentType(ContentType.JSON).body(mapper.writeValueAsString(docsTemplates)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + Endpoints.middleURLDocumentsTemplates).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());

	}

	@Test
	public void postWrongDocumentsTemplates() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).
				contentType(ContentType.JSON).body(mapper.writeValueAsString(docsTemplates)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + Endpoints.middleURLDocumentsTemplates).then()
				.statusCode(403);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
