package com.APISmartFabric.Tests.identity.GET.tenantController.POST;

import com.APISmartFabric.JsonBuilder.TenantsUsers;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.Controllers.CreateUserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.jayway.restassured.RestAssured.given;

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


	CreateUserRequest createUser = new CreateUserRequest(language, lastName, password, phone, title, token, tokenExpiry,
			code, firstName, gender, email, status);

	@Test
	public void postUserData() throws JsonProcessingException {

		TenantsUsers tenantUsersJson = TenantsUsers.builder().code(createUser.getCode())
				.email(createUser.getEmail()).firstName(createUser.getFirstName()).
						lastName(createUser.getLastName()).gender(createUser.getGender()).language(createUser.getLanguage()).
						password(createUser.getPassword()).phone(createUser.getPhone()).status(createUser.getStatus()).
						title(createUser.getTitle()).token(createUser.getToken()).tokenExpiry(createUser.getTokenExpiry()).
                 build();
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTenantsUsers")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongUserData() throws JsonProcessingException {
		TenantsUsers tenantUsersJson = TenantsUsers.builder().code(createUser.getCode())
				.email(createUser.getEmail()).firstName(createUser.getFirstName()).
						lastName(createUser.getLastName()).gender(createUser.getGender()).language(createUser.getLanguage()).
						password(createUser.getPassword()).phone(createUser.getPhone()).status(createUser.getStatus()).
						title(createUser.getTitle()).token(createUser.getToken()).
						build();
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTenantsUsers")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postUserDataNoAuthentication() throws JsonProcessingException {
		TenantsUsers tenantUsersJson = TenantsUsers.builder().code(createUser.getCode())
				.email(createUser.getEmail()).firstName(createUser.getFirstName()).
						lastName(createUser.getLastName()).gender(createUser.getGender()).language(createUser.getLanguage()).
						password(createUser.getPassword()).phone(createUser.getPhone()).status(createUser.getStatus()).
						title(createUser.getTitle()).token(createUser.getToken()).tokenExpiry(createUser.getTokenExpiry()).
						build();
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTenantsUsers")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

}
