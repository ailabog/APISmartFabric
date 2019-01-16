package com.APISmartFabric.Tests;

import org.testng.annotations.Test;

import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.controller.CreateUserRequest;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import static com.jayway.restassured.RestAssured.given;

import java.util.UUID;

public class POSTUserTest {

	final String code = "35";
	final String id = "45654";
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

	private String baseURL = "http://dev01.hq.smartfabric.ch:7000";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.post(baseURL + "/identity/admin/users");
	String location = response.header("location");
	CreateUserRequest create = new CreateUserRequest(language, lastName, password, phone, title, token, tokenExpiry,
			code, firstName, gender, email, status);

	@Test
	public void postUserData() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"code\":\"" + create.getCode() + "\",\n" + "\"email\":\"" + create.getEmail() + "\", \n"
						+ "\"firstName\":\"" + create.getFirstName() + "\", \n" + "\"gender\":\"" + create.getGender()
						+ "\", \n" + "\"id\":\"" + id + "\", \n" + "\"language\":\"" + create.getLanguage() + "\", \n"
						+ "\"password\":\"" + create.getPassword() + "\", \n" + "\"phone\":\"" + create.getPhone()
						+ "\", \n" + "\"status\":\"" + create.getStatus() + "\", \n" + "\"title\":\""
						+ create.getTitle() + "\", \n" + "\"token\":\"" + create.getToken() + "\", \n"
						+ "\"tokenExpiry\":\"" + create.getTokenExpiry() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLUser"))
				.then().statusCode(201);
		// assertFalse(location.isEmpty());
	}

	@Test
	public void postWrongUserData() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"code\":\"" + create.getCode() + "\",\n" + "\", \n" + "\"firstName\":\""
						+ create.getFirstName() + "\", \n" + "\"gender\":\"" + create.getGender() + "\", \n"
						+ "\"id\":\"" + id + "\", \n" + "\"language\":\"" + create.getLanguage() + "\", \n"
						+ "\"password\":\"" + create.getPassword() + "\", \n" + "\"phone\":\"" + create.getPhone()
						+ "\", \n" + "\"status\":\"" + create.getStatus() + "\", \n" + "\"title\":\""
						+ create.getTitle() + "\", \n" + "\"token\":\"" + create.getToken() + "\", \n"
						+ "\"tokenExpiry\":\"" + create.getTokenExpiry() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLUser"))
				.then().statusCode(404);
	}

}
