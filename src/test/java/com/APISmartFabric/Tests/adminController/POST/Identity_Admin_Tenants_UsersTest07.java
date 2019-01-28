package com.APISmartFabric.Tests.adminController.POST;


import com.APISmartFabric.JsonBuilder.AdminTenantsUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.CreateAdminTenantsUsersRequest;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.jayway.restassured.RestAssured.given;
@Slf4j
public class Identity_Admin_Tenants_UsersTest07 {

	private ObjectMapper mapper = new ObjectMapper();

	final String id = "3566";
	final String status = "ACTIVE";
	final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
	final String userId = "cddef63d-5065-4b85-b685-0811c67b3b8a";


	CreateAdminTenantsUsersRequest createAdmninTenantUsers = new CreateAdminTenantsUsersRequest(id, status, tenantId,
			userId);

	@Test
	public void postAdminTenantUser() throws JsonProcessingException {
		AdminTenantsUsers adminTenantsUsersJson = AdminTenantsUsers.builder().id(createAdmninTenantUsers.getId())
				.status(createAdmninTenantUsers.getStatus()).tenantId(createAdmninTenantUsers.getTenantId()).userId(createAdmninTenantUsers.getUserId()).
			build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenantsUsers")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postAdminTenantUserWrong() throws JsonProcessingException {
		AdminTenantsUsers adminTenantsUsersJson = AdminTenantsUsers.builder().id(createAdmninTenantUsers.getId())
				.status(createAdmninTenantUsers.getStatus()).tenantId(createAdmninTenantUsers.getTenantId()).
						build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenantsUsers")).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postAdminTenantUserWithoutAuthentication() throws JsonProcessingException {
		AdminTenantsUsers adminTenantsUsersJson = AdminTenantsUsers.builder().id(createAdmninTenantUsers.getId())
				.status(createAdmninTenantUsers.getStatus()).tenantId(createAdmninTenantUsers.getTenantId()).userId(createAdmninTenantUsers.getUserId()).
						build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenantsUsers")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

}
