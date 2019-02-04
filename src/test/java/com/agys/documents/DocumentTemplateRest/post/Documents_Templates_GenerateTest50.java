package com.agys.documents.documentTemplateRest.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.DocumentsGenerate;
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

public class Documents_Templates_GenerateTest50 {

	private ObjectMapper mapper = new ObjectMapper();

	private static final String processInstanceId = "";
	private static final String documentTemplateId = "";
	private static final String fileName = "";
	private static final String savePath = "";
	private static final String invalidProcessInstanceId = "";
	DocumentsGenerate docGenerateJson = DocumentsGenerate.builder().processInstanceId(processInstanceId)
			.documentTemplateId(documentTemplateId).fileName(fileName).
					savePath(savePath).build();

	@Test
	public void postDocumentsTemplatesGenerate() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
	            .contentType(ContentType.JSON).body(mapper.writeValueAsString(docGenerateJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + Endpoints.middleURLDocumentsTemplatesGenerate).then()
				.statusCode(201);
	}

	@Test
	public void postDocumentsTemplatesGenerateNoAuthentication() throws JsonProcessingException {

	given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docGenerateJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + Endpoints.middleURLDocumentsTemplatesGenerate).then()
				.statusCode(401);
	}

	@Test
	public void postWrongDocumentsTemplatesGenerate() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docGenerateJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments")+ Endpoints.middleURLDocumentsTemplatesGenerate).then()
				.statusCode(404);
	}
}
