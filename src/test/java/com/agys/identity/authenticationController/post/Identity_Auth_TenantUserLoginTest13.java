package com.agys.identity.authenticationController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.SystemLogin;
import com.agys.model.Factory;
import com.agys.utils.JsonHelper;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
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

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

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

		ValidatableResponse vr =
				given().contentType(ContentType.JSON).body(mapper.writeValueAsString(loginJson)).when()
						.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLLogin).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.login)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		Login systemLogin = JsonHelper.readValue(response, Login.class);
		assertEquals(Factory.login.getTenantId(), systemLogin.getTenantId(), "Tenant Ids equals");
		assertEquals(Factory.login.getUserEmail(), systemLogin.getUserEmail(), "User emails are equals");

		Factory.login.setTenantId(systemLogin.getTenantId());
		Factory.login.setUserEmail(systemLogin.getUserEmail());
	}

	@Test
	public void postWrongLogin() throws JsonProcessingException {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test_user@agys.ch";

		Login loginJson = Login.builder().tenantId(tenantId)
				.userEmail(userEmail).build();

		given().contentType(ContentType.JSON).body(mapper.writeValueAsString(loginJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLLogin).then()
				.statusCode(404);
	}
}
