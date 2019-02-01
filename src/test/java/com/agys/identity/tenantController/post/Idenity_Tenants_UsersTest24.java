package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.TenantsUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

import java.util.UUID;

@Slf4j
public class Idenity_Tenants_UsersTest24 {

	private ObjectMapper mapper = new ObjectMapper();

	final String code = "35";
	final String email = UUID.randomUUID() + "@testfabric.ch";
	final String firstName = "Aila";
	final String lastName = "Bogasieru";
	final String gender = "FEMALE";
	final String language = "English";
	final String password = "Pawdfg";
	final String phone = "325345436";
	final String status = "ACTIVE";
	final String title = "Admin";
	final String token = "365456";
	final String tokenExpiry = "2019-01-11T13:31:19.825Z";

	TenantsUsers tenantUsersJson = TenantsUsers.builder().code(code)
			.email(email).firstName(firstName).
					lastName(lastName).gender(gender).language(language).
					password(password).phone(phone).status(status).
					title(title).token(token).tokenExpiry(tokenExpiry).
					build();

	@Test
	public void postIdenityTenantsUsers() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLTenantsUsers).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongIdenityTenantsUsers() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") +  Endpoints.middleURLTenantsUsers +3).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postIdenityTenantsUsersNoAuthentication() throws JsonProcessingException {
			given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") +  Endpoints.middleURLTenantsUsers).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
