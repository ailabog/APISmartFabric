package com.APISmartFabric.Tests.gui.GUIRest.GET;


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
public class GUI_Activity_By_ActivityIdTest42 {

	private String activityId = "1242456434";
	private String invalidActivityId = "34564565464645";
	private String nullActivityId = "null";


	@Test
	public void getGUIActivityByActivityId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIActivity") + activityId)
				.then().assertThat().statusCode(200);
		log.info("GUI_Activity_By_Activity Id" + CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + activityId);
	}

	@Test
	public void getGUIActivityByActivityInvalidId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIActivity") + invalidActivityId)
				.then().assertThat().statusCode(404);
		log.info("GUI_Activity_By_Activity Id" + CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + invalidActivityId);
	}

	@Test
	public void getGUIActivityByActivityNULLId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIActivity") + nullActivityId)
				.then().assertThat().statusCode(400);
		log.info("GUI_Activity_By_Activity Id" + CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + nullActivityId);
	}

	@Test
	public void getGUIActivityByActivityIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + activityId).then().assertThat()
				.statusCode(401);
		log.info("GUI_Activity_By_Activity Id" + CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + activityId);
	}
}