package com.agys.documents.documentTemplateRest.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.DocumentsExport;
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

public class Documents_Templates_ExportSimpleTest49 {
	private ObjectMapper mapper = new ObjectMapper();

	public String html = "<!DOCTYPE html> <html> <head> <style id=\"page-size\">@page { size: A4 }</style></head> <body class=\"A4\" size=\"A4\" > <p>some text&nbsp;${CurrentTime}</p> </body> </html>";
	public String invalidHtml = "sedfsdfdsFSd75934534";

	@Test
	public void postDocumentsTemplatesExportSimple() throws JsonProcessingException {

		DocumentsExport docExportJson = DocumentsExport.builder().html(html)
				.build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + Endpoints.middleURLDocumentsTemplatesExportSimple).then()
				.statusCode(200);
	}


	@Test
	public void postDocumentsTemplatesExportSimpleNoAuthentication() throws JsonProcessingException {
		DocumentsExport docExportJson = DocumentsExport.builder().html(html)
				.build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + Endpoints.middleURLDocumentsTemplatesExportSimple).then()
				.statusCode(401);
	}

	@Test
	public void postWrongDocumentsTemplatesExportSimple() throws JsonProcessingException {
		DocumentsExport docExportJson = DocumentsExport.builder().invalidHtml(invalidHtml)
				.build();

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + Endpoints.middleURLDocumentsTemplatesExportSimple).then()
				.statusCode(404);

	}
}
