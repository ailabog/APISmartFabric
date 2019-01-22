package com.APISmartFabric.Tests.authenticationController.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author aila.bogasieru@agys.ch
 */

import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.LoginRequest;
import static com.jayway.restassured.RestAssured.given;


public class Identity_Auth_TenantUserLoginTest13 {
	
	private static final Logger logger = LoggerFactory.getLogger(Identity_Auth_TenantUserLoginTest13.class);
	
	@Test
	public void postLogin() {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test_user@agys.ch";
		final String userPassword = "passw0rd";

		LoginRequest login = new LoginRequest(tenantId, userEmail, userPassword);
		given().contentType("application/json")
				.body("{\"tenantId\" :\"" + login.getTenantDomain() + "\", \n" + "\"userEmail\":\""
						+ login.getUserEmail() + "\", \n" + "\"userPassword\":\"" + login.getUserPassword() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLLogin"))
				.then().statusCode(200);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongLogin() {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test_user@agys.ch";
		final String userPassword = null;
		LoginRequest login = new LoginRequest(tenantId, userEmail, userPassword);
		given().contentType("application/json")
				.body("{\"tenantId\" :\"" + login.getTenantDomain() + "\", \n" + "\"userEmail\":\""
						+ login.getUserEmail() + "\"}")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLLogin"))
				.then().statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}
}
