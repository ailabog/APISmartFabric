package com.APISmartFabric.Tests.adminController.POST;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.CreateAdminUsersRequest;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Identity_Admin_UsersTest09 {

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
	public void postAdminUser() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"code\":\"" + createAdminUser.getCode() + "\",\n" + "\"department\":\""
						+ createAdminUser.getDepartment() + "\", \n" + "\"email\":\"" + createAdminUser.getEmail()
						+ "\", \n" + "\"firstName\":\"" + createAdminUser.getFirstName() + "\", \n" + "\"gender\":\""
						+ createAdminUser.getGender() + "\", \n" + "\"id\":\"" + createAdminUser.getId() + "\", \n"
						+ "\"language\":\"" + createAdminUser.getLanguage() + "\", \n" + "\"lastName\":\""
						+ createAdminUser.getLastName() + "\", \n" + "\"password\":\"" + createAdminUser.getPassword()
						+ "\", \n" + "\"passwordLastUpdate\":\"" + createAdminUser.getPasswordLastUpdate() + "\", \n"
						+ "\"phone\":\"" + createAdminUser.getPhone() + "\", \n" + "\"position\":\""
						+ createAdminUser.getPosition() + "\", \n" + "\"reportsTo\":\"" + createAdminUser.getReportsTo()
						+ "\", \n" + "\"status\":\"" + createAdminUser.getStatus() + "\", \n" + "\"title\":\""
						+ createAdminUser.getTitle() + "\", \n" + "\"token\":\"" + createAdminUser.getToken() + "\", \n"
						+ "\"tokenExpiry\":\"" + createAdminUser.getTokenExpiry() + "\", \n" + "\"username\":\""
						+ createAdminUser.getUsername() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLUser"))
				.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongAdminUser() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"code\":\"" + createAdminUser.getCode() + "\",\n" + "\"department\":\""
						+ createAdminUser.getDepartment() + "\", \n" + "\"email\":\"" + createAdminUser.getEmail()
						+ "\", \n" + "\"firstName\":\"" + createAdminUser.getFirstName() + "\", \n" + "\"gender\":\""
						+ createAdminUser.getGender() + "\", \n" + "\"id\":\"" + createAdminUser.getId() + "\", \n"
						+ "\"language\":\"" + createAdminUser.getLanguage() + "\", \n" + "\"lastName\":\""
						+ createAdminUser.getLastName() + "\", \n" + "\"password\":\"" + createAdminUser.getPassword()
						+ "\", \n" + "\"passwordLastUpdate\":\"" + createAdminUser.getPasswordLastUpdate() + "\", \n"
						+ "\"phone\":\"" + createAdminUser.getPhone() + "\", \n" + "\"position\":\""
						+ createAdminUser.getPosition() + "\", \n" + "\"reportsTo\":\"" + createAdminUser.getReportsTo()
						+ "\", \n" + "\"status\":\"" + createAdminUser.getStatus() + "\", \n" + "\"title\":\""
						+ createAdminUser.getTitle() + "\", \n" + "\"token\":\"" + createAdminUser.getToken() + "\", \n"
						+ "\"tokenExpiry\":\"" + createAdminUser.getTokenExpiry() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLUser"))
				.then().statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void posAdminUserWithoutAuthentication() {
		given().contentType(ContentType.JSON)
				.body("{\"code\":\"" + createAdminUser.getCode() + "\",\n" + "\"department\":\""
						+ createAdminUser.getDepartment() + "\", \n" + "\"email\":\"" + createAdminUser.getEmail()
						+ "\", \n" + "\"firstName\":\"" + createAdminUser.getFirstName() + "\", \n" + "\"gender\":\""
						+ createAdminUser.getGender() + "\", \n" + "\"id\":\"" + createAdminUser.getId() + "\", \n"
						+ "\"language\":\"" + createAdminUser.getLanguage() + "\", \n" + "\"lastName\":\""
						+ createAdminUser.getLastName() + "\", \n" + "\"password\":\"" + createAdminUser.getPassword()
						+ "\", \n" + "\"passwordLastUpdate\":\"" + createAdminUser.getPasswordLastUpdate() + "\", \n"
						+ "\"phone\":\"" + createAdminUser.getPhone() + "\", \n" + "\"position\":\""
						+ createAdminUser.getPosition() + "\", \n" + "\"reportsTo\":\"" + createAdminUser.getReportsTo()
						+ "\", \n" + "\"status\":\"" + createAdminUser.getStatus() + "\", \n" + "\"title\":\""
						+ createAdminUser.getTitle() + "\", \n" + "\"token\":\"" + createAdminUser.getToken() + "\", \n"
						+ "\"tokenExpiry\":\"" + createAdminUser.getTokenExpiry() + "\", \n" + "\"username\":\""
						+ createAdminUser.getUsername() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLUser"))
				.then().statusCode(403);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
