package com.APISmartFabric.Tests.tenantController.DELETE;

import org.testng.annotations.Test;

import com.APISmartFabric.Enums.GroupIdsEnum;
import com.APISmartFabric.Enums.UserIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch Removes User Group Links
 */

public class Identity_Tenants_UserGroups_By_GroupsId_And_By_UserIdTest21 {
	
	private GroupIdsEnum GROUP;
	private UserIdsEnum USER;

	@Test
	public void deleteGroupIdInvalid() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups") +GROUP.GROUP_INVALID.getId() + "/" + USER.USER_INVALID.getId())
				.then().statusCode(404);
	}

	@Test
	public void deleteGroupIdValid() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups") +GROUP.GROUP_OK1.getId() + "/" + USER.USER_OK1.getId())
				.then().statusCode(200);
			
	}
	
	@Test
	public void deleteGroupIdValidNoAuthentication() {
		given().
		when().contentType(ContentType.JSON)
		.delete(CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUserGroups")
				+GROUP.GROUP_OK1.getId() + "/" + USER.USER_OK1.getId())
				.then().statusCode(401);
	}
}
