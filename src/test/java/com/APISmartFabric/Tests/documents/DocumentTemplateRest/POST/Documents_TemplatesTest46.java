package com.APISmartFabric.Tests.documents.DocumentTemplateRest.POST;

import com.APISmartFabric.JsonBuilder.DocumentsTemplates;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.CreateDocumentsTemplatesRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

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

	@Test
	public void postDocumentsTemplates() throws JsonProcessingException {

		CreateDocumentsTemplatesRequest documentsTemplates = new CreateDocumentsTemplatesRequest(description, h, id,
				isActive, isAdvanced, iteration, name, ownerId, processDefinitionId, template, usedAttributes,
				versionId, w);


		DocumentsTemplates docsTemplates = DocumentsTemplates.builder().description(documentsTemplates.getDescription())
				.h(documentsTemplates.getH()).id(documentsTemplates.getId()).isActive(documentsTemplates.getIsActive()).
				isAdvanced(documentsTemplates.getIsAdvanced()).iteration(documentsTemplates.getIteration()).name(documentsTemplates.getName()).
				ownerId(documentsTemplates.getOwnerId()).processDefinitionId(documentsTemplates.getProcessDefinitionId()).template(documentsTemplates.getTemplate()).usedAttributes(documentsTemplates.getUsedAttributes()).versionId(documentsTemplates.getVersionId()).
				w(documentsTemplates.getW()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }").
				contentType(ContentType.JSON).body(mapper.writeValueAsString(docsTemplates)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplates")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());

	}

	@Test
	public void postDocumentsTemplatesNoAuthentication() throws JsonProcessingException {

		CreateDocumentsTemplatesRequest documentsTemplates = new CreateDocumentsTemplatesRequest(description, h, id,
				isActive, isAdvanced, iteration, name, ownerId, processDefinitionId, template, usedAttributes,
				versionId, w);


		DocumentsTemplates docsTemplates = DocumentsTemplates.builder().description(documentsTemplates.getDescription())
				.h(documentsTemplates.getH()).id(documentsTemplates.getId()).isActive(documentsTemplates.getIsActive()).
						isAdvanced(documentsTemplates.getIsAdvanced()).iteration(documentsTemplates.getIteration()).name(documentsTemplates.getName()).
						ownerId(documentsTemplates.getOwnerId()).processDefinitionId(documentsTemplates.getProcessDefinitionId()).template(documentsTemplates.getTemplate()).usedAttributes(documentsTemplates.getUsedAttributes()).versionId(documentsTemplates.getVersionId()).
						w(documentsTemplates.getW()).build();

		given().
				contentType(ContentType.JSON).body(mapper.writeValueAsString(docsTemplates)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplates")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());

	}

	@Test
	public void postWrongDocumentsTemplates() throws JsonProcessingException {

		CreateDocumentsTemplatesRequest documentsTemplates = new CreateDocumentsTemplatesRequest(description, h, id,
				isActive, isAdvanced, iteration, name, ownerId, processDefinitionId, template, usedAttributes,
				versionId, w);


		DocumentsTemplates docsTemplates = DocumentsTemplates.builder().description(documentsTemplates.getDescription())
				.h(documentsTemplates.getH()).id(documentsTemplates.getId()).isActive(documentsTemplates.getIsActive()).
						isAdvanced(documentsTemplates.getIsAdvanced()).iteration(documentsTemplates.getIteration()).name(documentsTemplates.getName()).
						ownerId(documentsTemplates.getOwnerId()).processDefinitionId(documentsTemplates.getProcessDefinitionId()).template(documentsTemplates.getTemplate()).usedAttributes(documentsTemplates.getUsedAttributes()).versionId(documentsTemplates.getVersionId()).
						build();

		given().
				contentType(ContentType.JSON).body(mapper.writeValueAsString(docsTemplates)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplates")).then()
				.statusCode(403);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
