package com.APISmartFabric.Tests.DocumentTemplateRest.POST;

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

	private static final String processInstanceId = "";
	private static final String documentTemplateId = "";
	private static final String fileName = "";
	private static final String savePath = "";

	CreateDocumentsTemplatesGenerateRequest templateGenerate = new CreateDocumentsTemplatesGenerateRequest(
			processInstanceId, documentTemplateId, fileName, savePath);

	@Test
	public void postDocumentsTemplatesGenerate() {

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processInstanceId\":\"" + templateGenerate.getProcessInstanceId() + "\",\n"
						+ "\"documentTemplateId\":\"" + templateGenerate.getDocumentTemplateId() + "\", \n"
						+ "\"fileName\":\"" + templateGenerate.getFileName() + "\", \n" + "\"savePath\":\""
						+ templateGenerate.getSavePath() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers"))
				.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postDocumentsTemplatesGenerateNoAuthentication() {
		given().contentType(ContentType.JSON)
				.body("{\"processInstanceId\":\"" + templateGenerate.getProcessInstanceId() + "\",\n"
						+ "\"documentTemplateId\":\"" + templateGenerate.getDocumentTemplateId() + "\", \n"
						+ "\"fileName\":\"" + templateGenerate.getFileName() + "\", \n" + "\"savePath\":\""
						+ templateGenerate.getSavePath() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers"))
				.then().statusCode(403);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongDocumentsTemplatesGenerate() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"processInstanceId\":\"" + templateGenerate.getProcessInstanceId() + "\",\n"
						+ "\"documentTemplateId\":\"" + templateGenerate.getDocumentTemplateId() + "\", \n"
						+ "\"fileName\":\"" + templateGenerate.getFileName() + "\", \n" + "\"savePath\":\""
						+ templateGenerate.getSavePath() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers"))
				.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
