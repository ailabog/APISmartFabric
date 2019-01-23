package com.APISmartFabric.Tests.DocumentTemplateRest.POST;

import com.APISmartFabric.JsonBuilder.DocumentsGenerate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.CreateDocumentsTemplatesGenerateRequest;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import static com.jayway.restassured.RestAssured.given;

/**
 * @author aila.bogasieru@agys.ch
 */

@Slf4j

public class Documents_Templates_GenerateTest50 {

	private ObjectMapper mapper = new ObjectMapper();

	private static final String processInstanceId = "";
	private static final String documentTemplateId = "";
	private static final String fileName = "";
	private static final String savePath = "";
	private static final String invalidProcessInstanceId = "";

	CreateDocumentsTemplatesGenerateRequest templateGenerate = new CreateDocumentsTemplatesGenerateRequest(
			processInstanceId, documentTemplateId, fileName, savePath);

	@Test
	public void postDocumentsTemplatesGenerate() throws JsonProcessingException {

		DocumentsGenerate docGenerateJson = DocumentsGenerate.builder().processInstanceId(templateGenerate.getProcessInstanceId())
				.documentTemplateId(templateGenerate.getDocumentTemplateId()).fileName(templateGenerate.getFileName()).
				savePath(templateGenerate.getSavePath()).build();

		given()
				.header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
	            .contentType(ContentType.JSON).body(mapper.writeValueAsString(docGenerateJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplatesGenerate")).then()
				.statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postDocumentsTemplatesGenerateNoAuthentication() throws JsonProcessingException {

		DocumentsGenerate docGenerateJson = DocumentsGenerate.builder().processInstanceId(templateGenerate.getProcessInstanceId())
				.documentTemplateId(templateGenerate.getDocumentTemplateId()).fileName(templateGenerate.getFileName()).
						savePath(templateGenerate.getSavePath()).build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docGenerateJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplatesGenerate")).then()
				.statusCode(401);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongDocumentsTemplatesGenerate() throws JsonProcessingException {
		DocumentsGenerate docGenerateJson = DocumentsGenerate.builder().invalidProcessInstanceId(invalidProcessInstanceId)
				.documentTemplateId(templateGenerate.getDocumentTemplateId()).fileName(templateGenerate.getFileName()).
						savePath(templateGenerate.getSavePath()).build();

		given()
				.header("principal",
						"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docGenerateJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplatesGenerate")).then()
				.statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
