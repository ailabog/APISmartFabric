package com.APISmartFabric.Tests.DocumentTemplateRest.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 
 */

/**
 * @author aila.bogasieru@agys.ch
 */

import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.CreateDocumentsTemplatesRequest;
import static com.jayway.restassured.RestAssured.given;

public class Documents_TemplatesTest46 {
	
	private static final Logger logger = LoggerFactory.getLogger(Documents_TemplatesTest46.class);

	private String description = "Description";
	private String h = "0";
	private String id ="d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String isActive ="true";
	private String isAdvanced ="yes";
	private String iteration ="yes";
	private String name ="AutomatedDocumentsApi";
	private String ownerId ="d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String processDefinitionId ="d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String template ="346546$";
	private String usedAttributes="24";
	private String versionId ="d7eaf674-d4dd-42bd-bbb4-a9eb2951926f";
	private String w="0";

	@Test
	public void postDocumentsTemplates() {

		CreateDocumentsTemplatesRequest documentsTemplates = new CreateDocumentsTemplatesRequest(description, h, id, isActive, isAdvanced, iteration, name, ownerId, processDefinitionId,
				template, usedAttributes, versionId, w);
		
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"description\" :\"" + documentsTemplates.getDescription() + "\", \n" + "\"h\":\""
						+ documentsTemplates.getH() + "\", \n" + "\"id\":\"" + documentsTemplates.getId()
						+ "\"isActive\":\"" + documentsTemplates.getIsActive() + "\", \n" + "\"isAdvanced\":\"" + documentsTemplates.getIsAdvanced()
						+ "\"iteration\":\"" + documentsTemplates.getIteration() + "\", \n" + "\"name\":\"" + documentsTemplates.getName()
						+ "\"ownerId\":\"" + documentsTemplates.getOwnerId() + "\", \n" + "\"processDefinitionId\":\"" + documentsTemplates.getProcessDefinitionId()
						+ "\", \n" + "\"template\":\"" + documentsTemplates.getTemplate() + "\", \n" + "\"usedAttributes\":\"" + documentsTemplates.getUsedAttributes()
						+ "\", \n" + "\"versionId\":\"" + documentsTemplates.getVersionId() + "\", \n" + "\"w\":\"" + documentsTemplates.getW()
						+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplates"))
				.then().statusCode(200);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}
	
	@Test
	public void postDocumentsTemplatesNoAuthentication() {
	
		CreateDocumentsTemplatesRequest documentsTemplates = new CreateDocumentsTemplatesRequest(description, h, id, isActive, isAdvanced, iteration, name, ownerId, processDefinitionId,
				template, usedAttributes, versionId, w);
		given()
				.contentType("application/json")
				.body("{\"description\" :\"" + documentsTemplates.getDescription() + "\", \n" + "\"h\":\""
						+ documentsTemplates.getH() + "\", \n" + "\"id\":\"" + documentsTemplates.getId()
						+ "\"isActive\":\"" + documentsTemplates.getIsActive() + "\", \n" + "\"isAdvanced\":\"" + documentsTemplates.getIsAdvanced()
						+ "\"iteration\":\"" + documentsTemplates.getIteration() + "\", \n" + "\"name\":\"" + documentsTemplates.getName()
						+ "\"ownerId\":\"" + documentsTemplates.getOwnerId() + "\", \n" + "\"processDefinitionId\":\"" + documentsTemplates.getProcessDefinitionId()
						+ "\", \n" + "\"template\":\"" + documentsTemplates.getTemplate() + "\", \n" + "\"usedAttributes\":\"" + documentsTemplates.getUsedAttributes()
						+ "\", \n" + "\"versionId\":\"" + documentsTemplates.getVersionId() + "\", \n" + "\"w\":\"" + documentsTemplates.getW()
						+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplates"))
				.then().statusCode(403);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongDocumentsTemplates() {

		CreateDocumentsTemplatesRequest documentsTemplates = new CreateDocumentsTemplatesRequest(description, h, id, isActive, isAdvanced, iteration, name, ownerId, processDefinitionId,
				template, usedAttributes, versionId, w);
		
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"description\" :\"" + documentsTemplates.getDescription() + "\", \n" + "\"h\":\""
						+ documentsTemplates.getH() + "\", \n" + "\"id\":\"" + documentsTemplates.getId()
						+ "\"isActive\":\"" + documentsTemplates.getIsActive() + "\", \n" + "\"isAdvanced\":\"" + documentsTemplates.getIsAdvanced()
						+ "\"iteration\":\"" + documentsTemplates.getIteration() + "\", \n" + "\"name\":\"" + documentsTemplates.getName()
						+ "\"ownerId\":\"" + documentsTemplates.getOwnerId() + "\", \n" + "\"processDefinitionId\":\"" + documentsTemplates.getProcessDefinitionId()
						+ "\", \n" + "\"template\":\"" + documentsTemplates.getTemplate() + "\", \n" + "\"usedAttributes\":\"" + documentsTemplates.getUsedAttributes()
						+ "\", \n" + "\"versionId\":\"" + documentsTemplates.getVersionId()
						+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURLDocuments") + CredentialsUtils.getProperty("middleURLDocumentsTemplates"))
				.then().statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}
}
