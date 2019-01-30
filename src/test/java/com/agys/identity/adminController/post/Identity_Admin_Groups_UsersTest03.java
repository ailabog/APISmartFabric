package com.agys.identity.adminController.post;

import com.agys.Constants;
import com.agys.jsonBuilder.AdminGroupsUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
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
    AdminGroupsUsers adminGroupsUsersJson = AdminGroupsUsers.builder().groupId(groupId)
            .id(id).isManager(isManager).userId(userId).build();

	@Test
	public void postAdminGroupsUsers() throws JsonProcessingException {

	       given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
		}

	@Test
	public void postWrongAdminGroupsUsers() throws JsonProcessingException {


        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postAdminGroupsUsersNoAuthentication() throws JsonProcessingException {

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

}
