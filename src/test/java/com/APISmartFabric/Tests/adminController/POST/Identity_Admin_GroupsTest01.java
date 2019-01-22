package com.APISmartFabric.Tests.adminController.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.CreateAdminRequest;
import static com.jayway.restassured.RestAssured.given;

/**
 * @author aila.bogasieru@agys.ch
 * 
 */

public class Identity_Admin_GroupsTest01 {

	final String code = "43587784646";
	final String id = "4654677546";
	final String name = "Popescu1";
	final String tenantId = "33534577777436ff-3534543-345435";
	final String type = "SYSTEM";
	CreateAdminRequest createAdminGroups = new CreateAdminRequest(code, id, name, tenantId, type);
	private static final Logger logger = LoggerFactory.getLogger(Identity_Admin_GroupsTest01.class);

	@Test
	public void postAdminGroup() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"code\":\"" + createAdminGroups.getCode() + "\",\n" + "\"id\":\"" + createAdminGroups.getId()
						+ "\", \n" + "\"name\":\"" + createAdminGroups.getName() + "\", \n" + "\"tenantId\":\""
						+ createAdminGroups.getTenanatId() + "\", \n" + "\"type\":\"" + createAdminGroups.getType()
						+ "\" }")
				.when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroups"))
				.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}

	@Test
	public void postTheSameAdminGroup() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"code\":\"" + createAdminGroups.getCode() + "\",\n" + "\"id\":\"" + createAdminGroups.getId()
						+ "\", \n" + "\"name\":\"" + createAdminGroups.getName() + "\", \n" + "\"tenantId\":\""
						+ createAdminGroups.getTenanatId() + "\", \n" + "\"type\":\"" + createAdminGroups.getType()
						+ "\" }")
				.when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroups"))
				.then().statusCode(400);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongAdminGroup() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"code\":\"" + createAdminGroups.getCode() + "\",\n" + "\"id\":\"" + createAdminGroups.getId()
						+ "\", \n" + "\"name\":\"" + createAdminGroups.getName() + "\", \n" + "\"tenantId\":\""
						+ createAdminGroups.getTenanatId() + "\" }")
				.when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroups"))
				.then().statusCode(422);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}
}
