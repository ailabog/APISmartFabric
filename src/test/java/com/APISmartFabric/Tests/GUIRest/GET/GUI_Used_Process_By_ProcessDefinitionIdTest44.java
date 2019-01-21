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


public class GUI_Used_Process_By_ProcessDefinitionIdTest44 {
	
	private String processDefinitionId  ="5f8e91e3-cf30-4b21-ad97-dd110816b109";
	private String nullprocessDefinitionId  ="null";
	private String invalidprocessDefinitionId  ="123456";

	

	@Test
	public void getGUIUsedProcessByProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + processDefinitionId)
				.then().assertThat().statusCode(200);
	}
	
	@Test
	public void getGUIUsedProcessByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + invalidprocessDefinitionId)
				.then().assertThat().statusCode(404);
	}
	
	@Test
	public void getGUIUsedProcessByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
		.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + nullprocessDefinitionId)
		.then().assertThat().statusCode(404);
	}


	
	@Test
	public void getGUIUsedProcessByNULLProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + processDefinitionId)
		.then().assertThat().statusCode(403);
	}
}
