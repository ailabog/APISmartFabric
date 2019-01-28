package com.APISmartFabric.Tests.identity.GET.authenticationController.POST;

import com.APISmartFabric.JsonBuilder.Login;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.LoginRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * @author aila.bogasieru@agys.ch
 */

@Slf4j
public class Identity_Auth_TenantUserLoginTest13 {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void postLogin() throws JsonProcessingException {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test_user@agys.ch";
		final String userPassword = "passw0rd";

		LoginRequest login = new LoginRequest(tenantId, userEmail, userPassword);

		Login loginJson = Login.builder().tenantId(login.getTenantDomain())
				.userEmail(login.getUserEmail()).userPassword(login.getUserPassword()).build();

		given().contentType(ContentType.JSON).body(mapper.writeValueAsString(loginJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLLogin")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongLogin() throws JsonProcessingException {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test_user@agys.ch";
		final String userPassword = null;
		LoginRequest login = new LoginRequest(tenantId, userEmail, userPassword);

		Login loginJson = Login.builder().tenantId(login.getTenantDomain())
				.userEmail(login.getUserEmail()).build();

		given().contentType(ContentType.JSON).body(mapper.writeValueAsString(loginJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLLogin")).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());

	}

}
