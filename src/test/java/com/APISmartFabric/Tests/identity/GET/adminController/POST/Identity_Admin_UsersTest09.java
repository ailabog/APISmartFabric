package com.APISmartFabric.Tests.identity.GET.adminController.POST;

import com.APISmartFabric.JsonBuilder.AdminUsers;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.CreateAdminUsersRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Identity_Admin_UsersTest09 {

	private ObjectMapper mapper = new ObjectMapper();

	private String code;
	private String department;
	private String email;
	private String firstName;
	private String gender;
	private String id;
	private String language;
	private String lastName;
	private String password;
	private String passwordLastUpdate;
	private String phone;
	private String position;
	private String reportsTo;
	private String status;
	private String title;
	private String token;
	private String tokenExpiry;
	private String username;

	CreateAdminUsersRequest createAdminUser = new CreateAdminUsersRequest(code, department, email, firstName, gender,
			id, language, lastName, password, passwordLastUpdate, phone, position, reportsTo, status, title, token,
			tokenExpiry, username);

	@Test
	public void postAdminUser() throws JsonProcessingException {
		AdminUsers adminUsersJson = AdminUsers.builder().code(createAdminUser.getCode())
					.department(createAdminUser.getDepartment()).email(createAdminUser.getEmail()).firstName(createAdminUser.getFirstName()).gender(createAdminUser.getGender()).
					id(createAdminUser.getId()).language(createAdminUser.getLanguage()).lastName(createAdminUser.getLastName()).password(createAdminUser.getPassword()).
					passwordLastUpdate(createAdminUser.getPasswordLastUpdate()).phone(createAdminUser.getPhone()).position(createAdminUser.getPosition()).
		        	build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLUser")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongAdminUser() throws JsonProcessingException {
	AdminUsers adminUsersJson = AdminUsers.builder().code(createAdminUser.getCode())
					.department(createAdminUser.getDepartment()).email(createAdminUser.getEmail()).firstName(createAdminUser.getFirstName()).gender(createAdminUser.getGender()).
							id(createAdminUser.getId()).language(createAdminUser.getLanguage()).lastName(createAdminUser.getLastName()).password(createAdminUser.getPassword()).
							passwordLastUpdate(createAdminUser.getPasswordLastUpdate()).
							build();

			given().header("principal",
					"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
					.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminUsersJson)).when()
					.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLUser")).then()
					.statusCode(404);

			RensposeBodyDisplay responseR = new RensposeBodyDisplay();
			log.info("Response body" + responseR.response());
	}

	@Test
	public void posAdminUserWithoutAuthentication() throws JsonProcessingException {
		AdminUsers adminUsersJson = AdminUsers.builder().code(createAdminUser.getCode())
				.department(createAdminUser.getDepartment()).email(createAdminUser.getEmail()).firstName(createAdminUser.getFirstName()).gender(createAdminUser.getGender()).
						id(createAdminUser.getId()).language(createAdminUser.getLanguage()).lastName(createAdminUser.getLastName()).password(createAdminUser.getPassword()).
						passwordLastUpdate(createAdminUser.getPasswordLastUpdate()).phone(createAdminUser.getPhone()).position(createAdminUser.getPosition()).
						build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLUser")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
