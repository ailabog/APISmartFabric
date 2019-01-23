package com.APISmartFabric.Tests.adminController.POST;

import com.APISmartFabric.JsonBuilder.AdminGroupsUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.CreateAdminGroupsUsersRequest;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class Identity_Admin_Groups_UsersTest03 {

	private ObjectMapper mapper = new ObjectMapper();

	final String groupId = "437754646";
	final String id = "46546546";
	final String isManager = "true";
	final String userId = "a6t670eec-762c-4f5c77-a599-17777kk477b0";

	CreateAdminGroupsUsersRequest createAdminGroupUsers = new CreateAdminGroupsUsersRequest(groupId, id, isManager,
			userId);

	@Test
	public void postAdminGroupsUsers() throws JsonProcessingException {

		AdminGroupsUsers adminGroupsUsersJson = AdminGroupsUsers.builder().groupId(createAdminGroupUsers.getGroupId())
				.id(createAdminGroupUsers.getId()).isManager(createAdminGroupUsers.getIsManager()).userId(createAdminGroupUsers.getUserId()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(200);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
		}

	@Test
	public void postWrongAdminGroupsUsers() throws JsonProcessingException {

		AdminGroupsUsers adminGroupsUsersJson = AdminGroupsUsers.builder().groupId(createAdminGroupUsers.getGroupId())
				.id(createAdminGroupUsers.getId()).isManager(createAdminGroupUsers.getIsManager()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postAdminGroupsUsersNoAuthentication() throws JsonProcessingException {

		AdminGroupsUsers adminGroupsUsersJson = AdminGroupsUsers.builder().groupId(createAdminGroupUsers.getGroupId())
				.id(createAdminGroupUsers.getId()).isManager(createAdminGroupUsers.getIsManager()).userId(createAdminGroupUsers.getUserId()).build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

}
