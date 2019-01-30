package com.agys.identity.authenticationController.post;

import org.testng.annotations.Test;

import com.agys.jsonBuilder.Login;

/**
 * @author aila.bogasieru@agys.ch
 */

import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Identity_Auth_TenantUserLoginTest13 {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void postLogin() throws JsonProcessingException {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test_user@agys.ch";
		final String userPassword = "passw0rd";


		Login loginJson = Login.builder().tenantId(tenantId)
				.userEmail(userEmail).userPassword(userPassword).build();

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


		Login loginJson = Login.builder().tenantId(tenantId)
				.userEmail(userEmail).build();

		given().contentType(ContentType.JSON).body(mapper.writeValueAsString(loginJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLLogin")).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());

	}

}
