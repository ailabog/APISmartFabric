package com.APISmartFabric.Tests.authenticationController.POST;

import org.testng.annotations.Test;

/**
 * @author aila.bogasieru@agys.ch
 */

import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.controller.AdminController.LoginRequest;

import static com.jayway.restassured.RestAssured.given;

public class POSTLoginTest13 {

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
	}
}
