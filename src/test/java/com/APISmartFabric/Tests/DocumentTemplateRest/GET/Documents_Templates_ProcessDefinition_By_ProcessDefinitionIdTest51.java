package com.APISmartFabric.Tests.DocumentTemplateRest.GET;


import com.APISmartFabric.Enums.DocumentsIdsEnum;
import com.APISmartFabric.Enums.ProcessDefinitionEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Documents_Templates_ProcessDefinition_By_ProcessDefinitionIdTest51 {

	private ProcessDefinitionEnum PROCESS_DEFINITION;
	
	@Test
	public void getDocumentsProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesProcessDefinition") + PROCESS_DEFINITION.PROCESS_DEFINITION_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Documents_Templates_By_Id" + (CredentialsUtils.getProperty("baseURLDocuments")
				+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesProcessDefinition") + PROCESS_DEFINITION.PROCESS_DEFINITION_OK1.getId()));
	}

	@Test
	public void getDocumentsProcessDefinitionByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesProcessDefinition")
						+ PROCESS_DEFINITION.PROCESS_DEFINITION_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Documents_Templates_By_Id" + (CredentialsUtils.getProperty("baseURLDocuments")
				+ CredentialsUtils.getProperty("middleURLDocumentsTemplatesProcessDefinition") + PROCESS_DEFINITION.PROCESS_DEFINITION_INVALID.getId()));
	}

	@Test
	public void getDocumentsProcessDefinitionByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplates") + PROCESS_DEFINITION.PROCESS_DEFINITION_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Documents_Templates_By_Id" + (CredentialsUtils.getProperty("baseURLDocuments")
				+ CredentialsUtils.getProperty("middleURLDocumentsTemplates") + PROCESS_DEFINITION.PROCESS_DEFINITION_NULL.getId()));
	}

	@Test
	public void getDocumentsProcessDefinitionByProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLDocuments")
						+ CredentialsUtils.getProperty("middleURLDocumentsTemplates") + PROCESS_DEFINITION.PROCESS_DEFINITION_OK4.getId())
				.then().assertThat().statusCode(401);
		log.info("Documents_Templates_By_Id" + (CredentialsUtils.getProperty("baseURLDocuments")
				+ CredentialsUtils.getProperty("middleURLDocumentsTemplates") + PROCESS_DEFINITION.PROCESS_DEFINITION_OK4.getId()));
	}
}
