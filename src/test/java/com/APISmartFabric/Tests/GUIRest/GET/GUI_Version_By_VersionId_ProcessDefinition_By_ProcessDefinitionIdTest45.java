package com.APISmartFabric.Tests.GUIRest.GET;

import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */


public class GUI_Version_By_VersionId_ProcessDefinition_By_ProcessDefinitionIdTest45 {
	
	private String versionId  ="1111";
	private String processDefinitionId  ="222";
	private String invalidversionId  ="0";
	private String invalidProcessDefinition="0";
	private String nullVersionId="null";
	private String nullprocessDefinitionId="null";
	


	@Test
	public void getGUIVersionByVersionIdProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + versionId +  CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + processDefinitionId)
				.then().assertThat().statusCode(200);
	}

	@Test
	public void getGUIVersionByNULLVersionIdProcessDefinitionByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + nullVersionId +  CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + nullprocessDefinitionId)
				.then().assertThat().statusCode(404);
	}
	
	@Test
	public void getGUIVersionByInvalidVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
						"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
						.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
								+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + invalidversionId +  CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + invalidProcessDefinition)
						.then().assertThat().statusCode(404);
	}


	
	@Test
	public void getGUIUsedProcessByNULLProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + versionId +  CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + processDefinitionId)
		.then().assertThat().statusCode(403);
	}
	
	
	@Test
	public void getGUIVersionByInvalidVersionIdProcessDefinitionByProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
						"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
						.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
								+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + invalidversionId +  CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + invalidProcessDefinition)
						.then().assertThat().statusCode(404);
	}
	
	@Test
	public void getGUIVersionByVersionIdProcessDefinitionByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
						"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
						.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
								+ CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition") + invalidversionId +  CredentialsUtils.getProperty("middleURLGUIVersionProcessDefinition1") + processDefinitionId)
						.then().assertThat().statusCode(404);
	}
}
