package com.agys.identity.adminController.post;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.AdminTenants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class Identity_Admin_TenantsTest05 {

	private ObjectMapper mapper = new ObjectMapper();
	final String defaultUserEmail = "smart@yahoo.com";
	final String defaultUserPassword = "pswe777rewr";
	final String domain = "354354354-degf777dgd-34544";
	final String name = "Pop";
	final String status = "ACTIVE";

	AdminTenants adminTenantsJson = AdminTenants.builder().defaultUserEmail(defaultUserEmail)
			.defaultUserPassword(defaultUserPassword).domain(domain).name(name).status(status).
					build();

	@Test
	public void postAdminTenants() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLAdminTenants).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}


	@Test
	public void postWrongAdminTenant() throws JsonProcessingException {
		final String defaultUserEmail = "test@gmail.com";
		final String defaultUserPassword = "sdfsdf4565465";
		final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
		final String name = "AKLJK";
		final String status = "ACTIVE";

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLAdminTenants).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void posExistingAdminTenant() throws JsonProcessingException {
		final String defaultUserEmail = "test@gmail.com";
		final String defaultUserPassword = "sdfsdf4565465";
		final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
		final String name = "AKLJK";
		final String status = "ACTIVE";

	given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLAdminTenants).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postNoAuthenticationAdminTenant() throws JsonProcessingException {
		final String defaultUserEmail = "test@gmail.com";
		final String defaultUserPassword = "sdfsdf4565465";
		final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
		final String name = "AKLJK";
		final String status = "ACTIVE";
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLAdminTenants).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
