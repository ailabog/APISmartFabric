package com.agys.identity.adminController.post;


import com.agys.Constants;
import com.agys.jsonBuilder.AdminTenantsUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
@Slf4j
public class Identity_Admin_Tenants_UsersTest07 {

	private ObjectMapper mapper = new ObjectMapper();

	final String id = "3566";
	final String status = "ACTIVE";
	final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
	final String userId = "cddef63d-5065-4b85-b685-0811c67b3b8a";
	AdminTenantsUsers adminTenantsUsersJson = AdminTenantsUsers.builder().id(id)
			.status(status).tenantId(tenantId).userId(userId).
					build();
	@Test
	public void postAdminTenantUser() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenantsUsers")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postAdminTenantUserWrong() throws JsonProcessingException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenantsUsers") +1).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postAdminTenantUserWithoutAuthentication() throws JsonProcessingException {
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenantsUsers")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

}
