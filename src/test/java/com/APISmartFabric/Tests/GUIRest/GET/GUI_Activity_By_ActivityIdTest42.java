package com.APISmartFabric.Tests.GUIRest.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.APISmartFabric.Tests.GUIControlRest.GET.GUI_Control_Revision_SaveTest39;
import com.APISmartFabric.Utils.CredentialsUtils;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public class GUI_Activity_By_ActivityIdTest42 {

	private String activityId = "1242456434";
	private String invalidActivityId = "34564565464645";
	private String nullActivityId = "null";
	private static final Logger logger = LoggerFactory.getLogger(GUI_Activity_By_ActivityIdTest42.class);

	@Test
	public void getGUIActivityByActivityId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIActivity") + activityId)
				.then().assertThat().statusCode(200);
		logger.info("GUI_Activity_By_Activity Id" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + activityId);
	}

	@Test
	public void getGUIActivityByActivityInvalidId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIActivity") + invalidActivityId)
				.then().assertThat().statusCode(404);
		logger.info("GUI_Activity_By_Activity Id" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + invalidActivityId);
	}

	@Test
	public void getGUIActivityByActivityNULLId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIActivity") + nullActivityId)
				.then().assertThat().statusCode(404);
		logger.info("GUI_Activity_By_Activity Id" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + nullActivityId);
	}

	@Test
	public void getGUIActivityByActivityIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType("application/json").get(CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + activityId).then().assertThat()
				.statusCode(403);
		logger.info("GUI_Activity_By_Activity Id" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLGUIActivity") + activityId);
	}
}
