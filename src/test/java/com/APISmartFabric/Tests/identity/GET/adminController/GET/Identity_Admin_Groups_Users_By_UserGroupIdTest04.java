package com.APISmartFabric.Tests.identity.GET.adminController.GET;

import com.APISmartFabric.Enums.UsersGroupsIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.jayway.restassured.RestAssured.given;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Identity_Admin_Groups_Users_By_UserGroupIdTest04 {
	

	private UsersGroupsIdsEnum USERGROUP;
	
	final String groupId = "4354646";
	final String id = "46546546";
	final String isManager = "true";
	final String userId = "ab280eec-762c-4f5c-a599-1c949db477b0";

	@Test
	public void getUserById() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers") + USERGROUP.USERSGROUPS_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Admin_Groups_Users_By_UserGroupId"+ CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers") + USERGROUP.USERSGROUPS_OK1.getId());
	}

	@Test
	public void getUserByIdWithoutAuthentication() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers") + USERGROUP.USERSGROUPS_OK2.getId())
				.then().assertThat().statusCode(401);
		log.info("Identity_Admin_Groups_Users_By_UserGroupId"+ CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers") + USERGROUP.USERSGROUPS_OK2.getId());
	}
	
	@Test
	public void getUserByNullId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers") + USERGROUP.USERSGROUPS_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Identity_Admin_Groups_Users_By_UserGroupId"+ CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers") + USERGROUP.USERSGROUPS_NULL.getId());
	}
	

	@Test
	public void getUserByInvalidId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers") + USERGROUP.USERSGROUPS_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Admin_Groups_Users_By_UserGroupId"+ CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers") + USERGROUP.USERSGROUPS_INVALID.getId());
	}
}