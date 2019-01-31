package com.agys.identity.authenticationController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.SystemLogin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;

import lombok.extern.slf4j.Slf4j;

/**
 * @author aila.bogasieru@agys.ch
 */

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
@Slf4j

public class Identity_Auth_SystemUserLoginTest11 {

	private ObjectMapper mapper = new ObjectMapper();


	@Test
	public void postSystemLogin() throws JsonProcessingException {
		final String tenantId = "dacb0d16-6f03-4dff-a485-8d123376cac0";
		final String userEmail = "fabric_user@agys.ch";
		final String userPassword = "dfkhfgh94";

		SystemLogin systemJson = SystemLogin.builder().tenantId(tenantId)
				.userEmail(userEmail).userPassword(userPassword).build();


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
	            .contentType(ContentType.JSON).body(mapper.writeValueAsString(systemJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLSystem).then()
				.statusCode(200);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
		
	}

	@Test
	public void postWrongSystemLogin() throws JsonProcessingException {
		final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
		final String userEmail = "test.user@gmail.com";
		final String userPassword = null;
		SystemLogin systemJson = SystemLogin.builder().tenantId(tenantId)
				.userEmail(userEmail).userPassword(userPassword).build();

		given().contentType(ContentType.JSON).body(mapper.writeValueAsString(systemJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLSystem).then()
				.statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
