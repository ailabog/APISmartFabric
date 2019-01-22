package com.APISmartFabric.Tests.GUIRest.GET;


import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionIdTest45 {

	private String versionId = "e0216c9a-6f81-4d12-93f2-8b5f9bd2c2a6";
	private String processDefinitionId = "19d9b35f-7541-4861-85dd-3388331f1d5e";
	private String invalidversionId = "0";
	private String invalidProcessDefinition = "0";
	private String nullVersionId = "null";
	private String nullprocessDefinitionId = "null";
	

	@Test
	public void getGUIVersionByVersionIdProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + versionId
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + processDefinitionId)
				.then().assertThat().statusCode(200);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + versionId
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + processDefinitionId);
	}

	@Test
	public void getGUIVersionByNULLVersionIdProcessDefinitionByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + nullVersionId
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1")
						+ nullprocessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + nullVersionId
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + nullprocessDefinitionId);
	}

	@Test
	public void getGUIVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionId()
			throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + invalidversionId
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1")
						+ invalidProcessDefinition)
				.then().assertThat().statusCode(404);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + invalidversionId
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + invalidProcessDefinition);
	}

	@Test
	public void getGUIUsedProcessByNULLProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + versionId
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + processDefinitionId)
				.then().assertThat().statusCode(403);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + versionId
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + processDefinitionId);
	}

	@Test
	public void getGUIVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + invalidversionId
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1")
						+ invalidProcessDefinition)
				.then().assertThat().statusCode(404);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + invalidversionId
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + invalidProcessDefinition);
	}

	@Test
	public void getGUIVersionByVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + invalidversionId
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + processDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionId"
				+ CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + invalidversionId
				+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + processDefinitionId);
	}
}
