package com.APISmartFabric.Tests.adminController.POST;


import com.APISmartFabric.JsonBuilder.AdminGroups;
import com.APISmartFabric.JsonBuilder.AdminGroupsUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.CreateAdminRequest;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.jayway.restassured.RestAssured.given;

/**
 * @author aila.bogasieru@agys.ch
 * 
 */
@Slf4j
public class Identity_Admin_GroupsTest01 {

	private ObjectMapper mapper = new ObjectMapper();

	final String code = "43587784646";
	final String id = "4654677546";
	final String name = "Popescu1";
	final String tenantId = "33534577777436ff-3534543-345435";
	final String type = "SYSTEM";
	CreateAdminRequest createAdminGroups = new CreateAdminRequest(code, id, name, tenantId, type);

	@Test
	public void postAdminGroup() throws JsonProcessingException {
		AdminGroups adminGroupsJson = AdminGroups.builder().code(createAdminGroups.getCode())
				.id(createAdminGroups.getId()).name(createAdminGroups.getName()).tenantId(createAdminGroups.getTenanatId()).
				type(createAdminGroups.getType()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postTheSameAdminGroup() throws JsonProcessingException {
		AdminGroups adminGroupsJson = AdminGroups.builder().code(createAdminGroups.getCode())
				.id(createAdminGroups.getId()).name(createAdminGroups.getName()).tenantId(createAdminGroups.getTenanatId()).
						type(createAdminGroups.getType()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongAdminGroup() throws JsonProcessingException {
		AdminGroups adminGroupsJson = AdminGroups.builder().code(createAdminGroups.getCode())
				.id(createAdminGroups.getId()).name(createAdminGroups.getName()).
						type(createAdminGroups.getType()).build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(422);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postAdminGroupNoAuthentication() throws JsonProcessingException {
		AdminGroups adminGroupsJson = AdminGroups.builder().code(createAdminGroups.getCode())
				.id(createAdminGroups.getId()).name(createAdminGroups.getName()).tenantId(createAdminGroups.getTenanatId()).
						type(createAdminGroups.getType()).build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
