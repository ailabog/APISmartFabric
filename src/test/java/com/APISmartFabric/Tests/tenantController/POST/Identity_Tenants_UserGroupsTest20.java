package com.APISmartFabric.Tests.tenantController.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.APISmartFabric.Enums.GroupIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import static com.jayway.restassured.RestAssured.given;


public class Identity_Tenants_UserGroupsTest20 {
	
	private static final Logger logger = LoggerFactory.getLogger(Identity_Tenants_UserGroupsTest20.class);

	private GroupIdsEnum GROUPS;
	
	@Test
	public void postTenantsGroupsUsers() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json").
				body("[ +, \n" + "{ \"groupId\":\"" + GROUPS.GROUP_OK1.getId() + "}" + "\", \n" + "\"]" ).when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups"))
			.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		responseR.response();
		}

	@Test
	public void postWrongTenantsGroupsUsersNoAuthentication() {
		given().
				contentType("application/json").
				body("[ +, \n" + "{ \"groupId\":\"" + GROUPS.GROUP_OK2.getId() + "}" + "\", \n" + "\"]" ).when()
				.post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups"))
			.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		responseR.response();
	}
}
