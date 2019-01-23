package com.APISmartFabric.Tests.authenticationController.POST;


import com.APISmartFabric.JsonBuilder.SystemLogin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.SystemLoginRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author aila.bogasieru@agys.ch
 */

import static com.jayway.restassured.RestAssured.given;
@Slf4j

public class Identity_Auth_SystemUserLoginTest11 {

	private ObjectMapper mapper = new ObjectMapper();


	@Test
	public void postSystemLogin() throws JsonProcessingException {
		final String tenantId = "dacb0d16-6f03-4dff-a485-8d123376cac0";
		final String userEmail = "fabric_user@agys.ch";
		final String userPassword = "dfkhfgh94";
	
		SystemLoginRequest systemLogin = new SystemLoginRequest(tenantId, userEmail, userPassword);

		SystemLogin systemJson = SystemLogin.builder().tenantId(systemLogin.getTenantDomain())
				.userEmail(systemLogin.getUserEmail()).userPassword(systemLogin.getUserPassword()).build();


		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
	            .contentType(ContentType.JSON).body(mapper.writeValueAsString(systemJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLSystem")).then()
				.statusCode(200);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
		
	}

	@Test
	public void postWrongSystemLogin() {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test.user@gmail.com";
		final String userPassword = null;

		SystemLoginRequest systemLogin = new SystemLoginRequest(tenantId, userEmail, userPassword);

		SystemLogin systemJson = SystemLogin.builder().tenantId(systemLogin.getTenantDomain())
				.userEmail(systemLogin.getUserEmail()).build();
		given()
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLSystem"))
				.then().statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
