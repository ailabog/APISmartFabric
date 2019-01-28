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
public class GUI_Used_Process_By_ProcessDefinitionIdTest44 {

	private String processDefinitionId = "e53b8c55-76f5-4e55-81f6-306a2dae2017";
	private String nullprocessDefinitionId = "null";
	private String invalidprocessDefinitionId = "123456";

	@Test
	public void getGUIUsedProcessByProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + processDefinitionId)
				.then().assertThat().statusCode(200);
		log.info("GUI_Used_Process_By_ProcessDefinition Id" + CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + processDefinitionId);
	}

	@Test
	public void getGUIUsedProcessByInvalidProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + invalidprocessDefinitionId)
				.then().assertThat().statusCode(404);
		log.info("GUI_Used_Process_By_ProcessDefinition Id" + CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + invalidprocessDefinitionId);
	}

	@Test
	public void getGUIUsedProcessByNULLProcessDefinitionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + nullprocessDefinitionId)
				.then().assertThat().statusCode(400);
		log.info("GUI_Used_Process_By_ProcessDefinition Id" + CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + nullprocessDefinitionId);
	}

	@Test
	public void getGUIUsedProcessByProcessDefinitionIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + processDefinitionId)
				.then().assertThat().statusCode(401);
		log.info("GUI_Used_Process_By_ProcessDefinition Id" + CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIUsedProcess") + processDefinitionId);
	}
}
