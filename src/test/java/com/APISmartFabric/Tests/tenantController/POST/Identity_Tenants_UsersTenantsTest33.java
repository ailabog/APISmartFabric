package com.APISmartFabric.Tests.tenantController.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.APISmartFabric.Enums.UserIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import static com.jayway.restassured.RestAssured.given;

public class Identity_Tenants_UsersTenantsTest33 {

	private static final Logger logger = LoggerFactory.getLogger(Identity_Tenants_UsersTenantsTest33.class);

	private UserIdsEnum USER;

	@Test
	public void postTenantsGroupsUsers() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json").body("{\"code\":\"" + USER.USER_OK4.getId() + "\" ]").when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants"))
				.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongTenantsGroupsUsers() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json").body("{\"code\":\"" + USER.USER_OK2.getId() + "\" ]").when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersTenants"))
				.then().statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongTenantsGroupsUsersNoAuthentication() {
		given().contentType("application/json").body("{\"code\":\"" + USER.USER_OK3.getId() + "\" ]").when().post(
				CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTennatsGroupsUsers"))
				.then().statusCode(403);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}
}
