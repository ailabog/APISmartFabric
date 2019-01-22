package com.APISmartFabric.Tests.tenantController.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.CreateUserRequest;
import static com.jayway.restassured.RestAssured.given;

import java.util.UUID;

public class Idenity_Tenants_UsersTest24 {

	private static final Logger logger = LoggerFactory.getLogger(Idenity_Tenants_UsersTest24.class);

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
	public void postUserData() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"code\":\"" + createUser.getCode() + "\",\n" + "\"email\":\"" + createUser.getEmail()
						+ "\", \n" + "\"firstName\":\"" + createUser.getFirstName() + "\", \n" + "\"lastName\":\""
						+ createUser.getLastName() + "\", \n" + "\"gender\":\"" + createUser.getGender() + "\", \n"
						+ "\"language\":\"" + createUser.getLanguage() + "\", \n" + "\"lastName\":\""
						+ createUser.getLastName() + "\", \n" + "\"password\":\"" + createUser.getPassword() + "\", \n"
						+ "\"phone\":\"" + createUser.getPhone() + "\", \n" + "\"phone\":\"" + createUser.getPhone()
						+ "\", \n" + "\"status\":\"" + createUser.getStatus() + "\", \n" + "\"title\":\""
						+ createUser.getTitle() + "\", \n" + "\"token\":\"" + createUser.getToken() + "\", \n"
						+ "\"title\":\"" + createUser.getTitle() + "\", \n" + "\"token\":\"" + createUser.getToken()
						+ "\", \n" + "\"tokenExpiry\":\"" + createUser.getTokenExpiry() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTenantsUsers"))
				.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongUserData() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"code\":\"" + createUser.getCode() + "\",\n" + "\"email\":\"" + createUser.getEmail()
						+ "\", \n" + "\"firstName\":\"" + createUser.getFirstName() + "\", \n" + "\"lastName\":\""
						+ createUser.getLastName() + "\", \n" + "\"gender\":\"" + createUser.getGender() + "\", \n"
						+ "\"language\":\"" + createUser.getLanguage() + "\", \n" + "\"lastName\":\""
						+ createUser.getLastName() + "\", \n" + "\"password\":\"" + createUser.getPassword() + "\", \n"
						+ "\"phone\":\"" + createUser.getPhone() + "\", \n" + "\"phone\":\"" + createUser.getPhone()
						+ "\", \n" + "\"status\":\"" + createUser.getStatus() + "\", \n" + "\"title\":\""
						+ createUser.getTitle() + "\", \n" + "\"token\":\"" + createUser.getToken() + "\", \n"
						+ "\"title\":\"" + createUser.getTitle() + "\", \n" + "\"token\":\"" + createUser.getToken()
						+ "\", \n" + "\"tokenExpiry\":\"" + createUser.getTokenExpiry() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTenantsUsers"))
				.then().statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		logger.info("Response body" + responseR.response());
	}

}
