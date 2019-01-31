package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import org.testng.annotations.Test;
import com.agys.enums.GroupIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Identity_Tenants_UserGroupsTest20 {

	private GroupIdsEnum GROUPS;
	
	@Test
	public void postTenantsGroupsUsers() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).
				body("[ +, \n" + "{ \"groupId\":\"" + GROUPS.GROUP_OK1.getId() + "}" + "\", \n" + "\"]" ).when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUserGroups)
			.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		responseR.response();
		}

	@Test
	public void postWrongTenantsGroupsUsersNoAuthentication() {
		given().
				contentType(ContentType.JSON).
				body("[ +, \n" + "{ \"groupId\":\"" + GROUPS.GROUP_OK2.getId() + "}" + "\", \n" + "\"]" ).when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUserGroups)
			.then().statusCode(401);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		responseR.response();
	}
}