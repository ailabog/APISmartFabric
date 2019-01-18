package com.APISmartFabric.Tests.tenantController.POST;

import org.testng.annotations.Test;

import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.controller.AdminController.CreateTenantsGroupsPermissionsRequest;
import static com.jayway.restassured.RestAssured.given;


public class Identity_Tenants_Groups_PermissionsTest18 {

	final String groupId = "da26c865-4ef0-4e33-87fe-54fdec501ec5";
	final String id = "45656786784";
	final String permission = "";
	final String permissionType = "DOCUMENT_TEMPLATE";
	final String targetId = "TYPE";

	CreateTenantsGroupsPermissionsRequest createTenantPermisionsGroup = new CreateTenantsGroupsPermissionsRequest(groupId, id, permission, permissionType, targetId);

	@Test
	public void postTenantsGroupsPermissions() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"groupId\":\"" + createTenantPermisionsGroup.getGroupId() + "\",\n" + "\"id\":\"" + createTenantPermisionsGroup.getId() + "\", \n"
						+ "\"permission\":\"" + createTenantPermisionsGroup.getPermission() + "\", \n" + "\"permissionType\":\"" + createTenantPermisionsGroup.getPermissionType()
				+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middlerURLTenantsGroupsPermissions"))
				.then().statusCode(201);
		// assertFalse(location.isEmpty());
	}

	@Test
	public void postWrongTenantsGroupsPermissions() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"groupId\":\"" + createTenantPermisionsGroup.getGroupId() + "\",\n" + "\"id\":\"" + createTenantPermisionsGroup.getId() + "\", \n"
						+ "\"permission\":\"" + createTenantPermisionsGroup.getPermission()
				+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middlerURLTenantsGroupsPermissions"))
				.then().statusCode(404);
	}
	
	@Test
	public void postTenantsGroupsPermissionsNoAuthentication() {
		given().
				contentType("application/json")
				.body("{\"groupId\":\"" + createTenantPermisionsGroup.getGroupId() + "\",\n" + "\"id\":\"" + createTenantPermisionsGroup.getId() + "\", \n"
						+ "\"permission\":\"" + createTenantPermisionsGroup.getPermission() + "\", \n" + "\"permissionType\":\"" + createTenantPermisionsGroup.getPermissionType()
				+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middlerURLTenantsGroupsPermissions"))
				.then().statusCode(403);
   }

}
