package com.APISmartFabric.Tests.GUIRest.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public class GUI_By_IdTest40 {

	private String id = "8f719613-979c-0f9d-c0bd-d28621d7d53c";
	private String invalidId = "34564645";
	private String nullId = "null";
	private static final Logger logger = LoggerFactory.getLogger(GUI_By_IdTest40.class);

	@Test
	public void getGUIById() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json")
				.get(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUI") + id)
				.then().assertThat().statusCode(200);
		logger.info("GUI_By_Id" + CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLGUI")
				+ id);
	}

	@Test
	public void getGUIByInvalidId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUI") + invalidId)
				.then().assertThat().statusCode(404);
		logger.info("GUI_By_Id" + CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLGUI")
				+ invalidId);
	}

	@Test
	public void getGUIByNULLId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json")
				.get(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUI") + nullId)
				.then().assertThat().statusCode(404);
		logger.info("GUI_By_Id" + CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLGUI")
				+ nullId);
	}

	@Test
	public void getGUIByInvalidIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType("application/json")
				.get(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUI") + id)
				.then().assertThat().statusCode(403);
		logger.info("GUI_By_Id" + CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLGUI")
				+ id);
	}
}
