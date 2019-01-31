package com.agys.identity.tenantController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import org.testng.annotations.Test;
import com.agys.enums.UserIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import java.util.*;

@Slf4j
public class Identity_Tenants_Groups_UsersTest19 {


	private List<UserIdsEnum> userList = Arrays.asList(UserIdsEnum.USER_OK1, UserIdsEnum.USER_OK2, UserIdsEnum.USER_OK3,
			UserIdsEnum.USER_OK4, UserIdsEnum.USER_OK5);

	@Test
	public void postTenantsGroupsUsers() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body("[ \"usersIds\":\"" + userList + "\" ]").when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTennatsGroupsUsers)
			.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		responseR.response();
	}

	@Test
	public void postWrongTenantsGroupsUsers() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body("[ \"usersIds\":\"" + userList + "\" ]").when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTennatsGroupsUsers)
				.then().statusCode(404);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongTenantsGroupsUsersNoAuthentication() {
		given().
				contentType(ContentType.JSON).body("[ \"usersIds\":\"" + userList + "\" ]").when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTennatsGroupsUsers)
				.then().statusCode(401);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
