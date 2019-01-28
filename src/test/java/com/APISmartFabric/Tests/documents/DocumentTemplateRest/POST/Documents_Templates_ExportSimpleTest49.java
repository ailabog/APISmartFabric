package com.APISmartFabric.Tests.documents.DocumentTemplateRest.POST;

import com.APISmartFabric.JsonBuilder.DocumentsExport;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
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

public class Documents_Templates_ExportSimpleTest49 {
	private ObjectMapper mapper = new ObjectMapper();

	public String html = "<!DOCTYPE html> <html> <head> <style id=\"page-size\">@page { size: A4 }</style></head> <body class=\"A4\" size=\"A4\" > <p>some text&nbsp;${CurrentTime}</p> </body> </html>";
	public String invalidHtml = "sedfsdfdsFSd75934534";

	@Test
	public void postDocumentsTemplatesExportSimple() throws JsonProcessingException {

		DocumentsExport docExportJson = DocumentsExport.builder().html(html)
				.build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple")).then()
				.statusCode(200);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}


	@Test
	public void postDocumentsTemplatesExportSimpleNoAuthentication() throws JsonProcessingException {
		DocumentsExport docExportJson = DocumentsExport.builder().html(html)
				.build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongDocumentsTemplatesExportSimple() throws JsonProcessingException {
		DocumentsExport docExportJson = DocumentsExport.builder().invalidHtml(invalidHtml)
				.build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(docExportJson)).when()
				.post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplatesExportSimple")).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
