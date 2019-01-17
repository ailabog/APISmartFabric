package com.APISmartFabric.Tests.adminController.POST;

import static com.jayway.restassured.RestAssured.given;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.controller.AdminController.CreateAdminTenantsRequest;

public class POSTAdminTenantsTest05 {
	@Test
	public void postAdminTenants() {
		final String defaultUserEmail = "smart@yahoo.com";
		final String defaultUserPassword = "pswe777rewr";
		final String domain = "354354354-degf777dgd-34544";
		final String name = "Pop";
		final String status = "ACTIVE";

		CreateAdminTenantsRequest adminTenant = new CreateAdminTenantsRequest(defaultUserEmail, defaultUserPassword,
				domain, name, status);

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"defaultUserEmail\":\"" + adminTenant.getDefaultUserEmail() + "\",\n" + "\"defaultUserPassword\":\"" + adminTenant.getDefaultUserPassword() + "\", \n"
								+ "\"domain\":\"" + adminTenant.getDomain() + "\", \n" + "\"name\":\"" + adminTenant.getName()
								+ "\"status\":\"" + adminTenant.getStatus()
								+ "\" }")
						.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenants"))
						.then().statusCode(201);
	}

	@Test
	public void postWrongAdminTenant() {
		final String defaultUserEmail = "test@gmail.com";
		final String defaultUserPassword = "sdfsdf4565465";
		final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
		final String name = "AKLJK";
		final String status = "ACTIVE";

		CreateAdminTenantsRequest adminTenant = new CreateAdminTenantsRequest(defaultUserEmail, defaultUserPassword,
				domain, name, status);

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"defaultUserEmail\":\"" + adminTenant.getDefaultUserEmail() + "\",\n" + "\"defaultUserPassword\":\"" + adminTenant.getDefaultUserPassword() + "\", \n"
								+ "\"domain\":\"" + adminTenant.getDomain() + "\", \n" + "\"name\":\"" + adminTenant.getName()
								+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenants"))
				.then().statusCode(404);
	}

	@Test
	public void posExistingAdminTenant() {
		final String defaultUserEmail = "test@gmail.com";
		final String defaultUserPassword = "sdfsdf4565465";
		final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
		final String name = "AKLJK";
		final String status = "ACTIVE";

		CreateAdminTenantsRequest adminTenant = new CreateAdminTenantsRequest(defaultUserEmail, defaultUserPassword,
				domain, name, status);

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"defaultUserEmail\":\"" + adminTenant.getDefaultUserEmail() + "\",\n" + "\"defaultUserPassword\":\"" + adminTenant.getDefaultUserPassword() + "\", \n"
								+ "\"domain\":\"" + adminTenant.getDomain() + "\", \n" + "\"name\":\"" + adminTenant.getName()
								+ "\"status\":\"" + adminTenant.getStatus()
								+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenants"))
				.then().statusCode(400);
	}

	@Test
	public void postNoAuthenticationAdminTenant() {
		final String defaultUserEmail = "test@gmail.com";
		final String defaultUserPassword = "sdfsdf4565465";
		final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
		final String name = "AKLJK";
		final String status = "ACTIVE";

		CreateAdminTenantsRequest adminTenant = new CreateAdminTenantsRequest(defaultUserEmail, defaultUserPassword,
				domain, name, status);

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"defaultUserEmail\":\"" + adminTenant.getDefaultUserEmail() + "\",\n" + "\"defaultUserPassword\":\"" + adminTenant.getDefaultUserPassword() + "\", \n"
								+ "\"domain\":\"" + adminTenant.getDomain() + "\", \n" + "\"name\":\"" + adminTenant.getName()
								+ "\"status\":\"" + adminTenant.getStatus()
								+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenants"))
				.then().statusCode(403);
	}
}
