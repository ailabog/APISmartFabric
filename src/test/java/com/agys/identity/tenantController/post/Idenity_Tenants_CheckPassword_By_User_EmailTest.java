package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.utils.CredentialsUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;


@Slf4j
public class Idenity_Tenants_CheckPassword_By_User_EmailTest {

	private ObjectMapper mapper = new ObjectMapper();

	final String userEmail = "test_user@agys.ch";
	final String invalidUserEmail="aaa@yahoo.com";
	final String oldPassword="passw0rd";


	@Test
	public void postIdenityTenantsCheckPasswordByUserEmail() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON)
				.body("[ +, \n" + "{ \"oldPasword\":\"" + oldPassword +  "\"]" )
				.when().post(CredentialsUtils.IDENTITY
				+ Endpoints.middleURLIdentityTenantsCheckPassword + userEmail)
				.then().assertThat().statusCode(201);
	}

	@Test
	public void postWrongIdenityTenantsCheckPasswordByUserEmail() throws JsonProcessingException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON)
				.body("[ +, \n" + "{ \"oldPasword\":\"" + oldPassword +  "\"]" )
				.when().post(CredentialsUtils.IDENTITY
				+ Endpoints.middleURLIdentityTenantsCheckPassword + invalidUserEmail)
				.then().assertThat().statusCode(404);
	}

	@Test
	public void postIdenityTenantsCheckPasswordByUserEmailNoAuthentication() throws JsonProcessingException {
		given()
				.contentType(ContentType.JSON)
				.body("[ +, \n" + "{ \"oldPasword\":\"" + oldPassword +  "\"]" )
				.when().post(CredentialsUtils.IDENTITY
				+ Endpoints.middleURLIdentityTenantsCheckPassword + userEmail)
				.then().assertThat().statusCode(401);
	}
}
