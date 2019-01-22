package com.APISmartFabric.Tests.adminController.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.controller.AdminController.CreateAdminGroupsUsersRequest;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public class Identity_Admin_Groups_UsersTest03 {

	final String groupId = "437754646";
	final String id = "46546546";
	final String isManager = "true";
	final String userId = "a6t670eec-762c-4f5c77-a599-17777kk477b0";
	private static final Logger logger = LoggerFactory.getLogger(Identity_Admin_Groups_UsersTest03.class);
	
	CreateAdminGroupsUsersRequest createAdminGroupUsers = new CreateAdminGroupsUsersRequest(groupId, id, isManager, userId);

	@Test
	public void postAdminGroupsUsers() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"groupId\":\"" + createAdminGroupUsers.getGroupId() + "\",\n" + "\"id\":\"" + createAdminGroupUsers.getId() + "\", \n"
						+ "\"isManager\":\"" + createAdminGroupUsers.getIsManager() + "\", \n" + "\"userId\":\"" + createAdminGroupUsers.getUserId()
					   + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers"))
				.then().statusCode(201);
		logger.info("Identity_Admin_Tenants_By_TenantId" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers"));
	}

	@Test
	public void postWrongAdminGroupsUsers() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"groupId\":\"" + createAdminGroupUsers.getGroupId() + "\",\n" + "\"id\":\"" + createAdminGroupUsers.getId() + "\", \n"
						+ "\"isManager\":\"" + createAdminGroupUsers.getIsManager()
					   + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminGroupsUsers"))
				.then().statusCode(404);
		logger.info("Identity_Admin_Tenants_By_TenantId" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminGroupsUsers"));
	}

}
