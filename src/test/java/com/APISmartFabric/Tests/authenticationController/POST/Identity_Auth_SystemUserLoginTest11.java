package com.APISmartFabric.Tests.authenticationController.POST;

import org.testng.annotations.Test;

/**
 * @author aila.bogasieru@agys.ch
 */

import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.controller.AdminController.LoginRequest;
import com.APISmartFabric.controller.AdminController.SystemLoginRequest;

import static com.jayway.restassured.RestAssured.given;

public class Identity_Auth_SystemUserLoginTest11 {

	@Test
	public void postSystemLogin() {
		final String tenantId = "dacb0d16-6f03-4dff-a485-8d123376cac0";
		final String userEmail = "fabric_user@agys.ch";
		final String userPassword = "dfkhfgh94";

		SystemLoginRequest systemLogin = new SystemLoginRequest(tenantId, userEmail, userPassword);
		given().contentType("application/json")
				.body("{\"tenantId\" :\"" + systemLogin.getTenantDomain() + "\", \n" + "\"userEmail\":\""
						+ systemLogin.getUserEmail() + "\", \n" + "\"userPassword\":\"" + systemLogin.getUserPassword() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLSystem"))
				.then().statusCode(200);
	}

	@Test
	public void postWrongSystemLogin() {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test.user@gmail.com";
		final String userPassword = null;
		LoginRequest systemLogin = new LoginRequest(tenantId, userEmail, userPassword);
		given().contentType("application/json")
		.body("{\"tenantId\" :\"" + systemLogin.getTenantDomain() + "\", \n" + "\"userEmail\":\""
				+ systemLogin.getUserEmail() + "\", \n" + "\"userPassword\":\"" + systemLogin.getUserPassword() + "\" }")
		.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLSystem"))
				.then().statusCode(404);
	}
}
