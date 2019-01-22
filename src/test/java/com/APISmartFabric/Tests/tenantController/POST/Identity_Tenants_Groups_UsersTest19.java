package com.APISmartFabric.Tests.tenantController.POST;


import org.testng.annotations.Test;
import com.APISmartFabric.Enums.UserIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import static com.jayway.restassured.RestAssured.given;
import java.util.*;

@Slf4j
public class Identity_Tenants_Groups_UsersTest19 {
	
		

	private List<UserIdsEnum> userList = Arrays.asList(UserIdsEnum.USER_OK1, UserIdsEnum.USER_OK2, UserIdsEnum.USER_OK3,
			UserIdsEnum.USER_OK4, UserIdsEnum.USER_OK5);

	@Test
	public void postTenantsGroupsUsers() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body("[ \"usersIds\":\"" + userList + "\" ]").when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTennatsGroupsUsers"))
			.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		responseR.response();
	}

	@Test
	public void postWrongTenantsGroupsUsers() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body("[ \"usersIds\":\"" + userList + "\" ]").when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTennatsGroupsUsers"))
				.then().statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongTenantsGroupsUsersNoAuthentication() {
		given().
				contentType(ContentType.JSON).body("[ \"usersIds\":\"" + userList + "\" ]").when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTennatsGroupsUsers"))
				.then().statusCode(403);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
