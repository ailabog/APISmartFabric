package com.APISmartFabric.Tests.adminController.POST;

import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.controller.AdminController.CreateAdminTenantsUsersRequest;
import static com.jayway.restassured.RestAssured.given;

public class Identity_Admin_Tenants_UsersTest07 {

	final String id = "3566";
	final String status = "ACTIVE";
	final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
	final String userId = "cddef63d-5065-4b85-b685-0811c67b3b8a";

	CreateAdminTenantsUsersRequest createAdmninTenantUsers = new CreateAdminTenantsUsersRequest(id, status, tenantId,
			userId);

	@Test
	public void postAdminTenantUser() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"id\":\"" + createAdmninTenantUsers.getId() + "\",\n" + "\"status\":\""
						+ createAdmninTenantUsers.getStatus() + "\", \n" + "\"tenantId\":\""
						+ createAdmninTenantUsers.getTenantId() + "\", \n" + "\"userId\":\""
						+ createAdmninTenantUsers.getUserId() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers"))
				.then().statusCode(201);
		// assertFalse(location.isEmpty());
	}

	@Test
	public void postAdminTenantUserWrong() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"id\":\"" + createAdmninTenantUsers.getId() + "\",\n" + "\"status\":\""
						+ createAdmninTenantUsers.getStatus() + "\", \n" + "\"tenantId\":\""
						+ createAdmninTenantUsers.getTenantId() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers"))
				.then().statusCode(404);
	}

	@Test
	public void postAdminTenantUserWithoutAuthentication() {
		given().contentType("application/json")
				.body("{\"id\":\"" + createAdmninTenantUsers.getId() + "\",\n" + "\"status\":\""
						+ createAdmninTenantUsers.getStatus() + "\", \n" + "\"tenantId\":\""
						+ createAdmninTenantUsers.getTenantId() + "\", \n" + "\"userId\":\""
						+ createAdmninTenantUsers.getUserId() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsUsers"))
				.then().statusCode(201);
		// assertFalse(location.isEmpty());
	}

}
