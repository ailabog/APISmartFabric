package com.agys.identity.adminController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.AdminUsers;
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

	AdminUsers adminUsersJson = AdminUsers.builder().code(code)
			.department(department).email(email).firstName(firstName).gender(gender).
					id(id).language(language).lastName(lastName).password(password).
					passwordLastUpdate(passwordLastUpdate).phone(phone).position(position).
			reportsTo(reportsTo).status(status).title(title).token(token).tokenExpiry(tokenExpiry).username(username).
					build();

	@Test
	public void postAdminUser() throws JsonProcessingException {


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLUser).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongAdminUser() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
					.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminUsersJson)).when()
					.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLUser).then()
					.statusCode(404);

			RensposeBodyDisplay responseR = new RensposeBodyDisplay();
			log.info("Response body" + responseR.response());
	}

	@Test
	public void posAdminUserWithoutAuthentication() throws JsonProcessingException {
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminUsersJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLUser).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
