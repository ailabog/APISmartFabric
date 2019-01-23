package com.APISmartFabric.Tests.adminController.POST;

import static com.jayway.restassured.RestAssured.given;

import com.APISmartFabric.JsonBuilder.AdminTenants;
import com.APISmartFabric.JsonBuilder.AdminTenantsUsers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.CreateAdminTenantsRequest;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class Identity_Admin_TenantsTest05 {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void postAdminTenants() throws JsonProcessingException {
		final String defaultUserEmail = "smart@yahoo.com";
		final String defaultUserPassword = "pswe777rewr";
		final String domain = "354354354-degf777dgd-34544";
		final String name = "Pop";
		final String status = "ACTIVE";

		CreateAdminTenantsRequest adminTenant = new CreateAdminTenantsRequest(defaultUserEmail, defaultUserPassword,
				domain, name, status);

		AdminTenants adminTenantsJson = AdminTenants.builder().defaultUserEmail(adminTenant.getDefaultUserEmail())
				.defaultUserPassword(adminTenant.getDefaultUserPassword()).domain(adminTenant.getDomain()).name(adminTenant.getName()).status(adminTenant.getStatus()).
						build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenants")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}


	@Test
	public void postWrongAdminTenant() throws JsonProcessingException {
		final String defaultUserEmail = "test@gmail.com";
		final String defaultUserPassword = "sdfsdf4565465";
		final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
		final String name = "AKLJK";
		final String status = "ACTIVE";

		CreateAdminTenantsRequest adminTenant = new CreateAdminTenantsRequest(defaultUserEmail, defaultUserPassword,
				domain, name, status);

		AdminTenants adminTenantsJson = AdminTenants.builder().defaultUserEmail(adminTenant.getDefaultUserEmail())
				.defaultUserPassword(adminTenant.getDefaultUserPassword()).domain(adminTenant.getDomain()).name(adminTenant.getName()).status(adminTenant.getStatus()).
						build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenants")).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void posExistingAdminTenant() throws JsonProcessingException {
		final String defaultUserEmail = "test@gmail.com";
		final String defaultUserPassword = "sdfsdf4565465";
		final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
		final String name = "AKLJK";
		final String status = "ACTIVE";

		CreateAdminTenantsRequest adminTenant = new CreateAdminTenantsRequest(defaultUserEmail, defaultUserPassword,
				domain, name, status);

		AdminTenants adminTenantsJson = AdminTenants.builder().defaultUserEmail(adminTenant.getDefaultUserEmail())
				.defaultUserPassword(adminTenant.getDefaultUserPassword()).domain(adminTenant.getDomain()).name(adminTenant.getName()).status(adminTenant.getStatus()).
						build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenants")).then()
				.statusCode(404);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postNoAuthenticationAdminTenant() throws JsonProcessingException {
		final String defaultUserEmail = "test@gmail.com";
		final String defaultUserPassword = "sdfsdf4565465";
		final String domain = "345646456456-dfgfdgfd-45t43655-34655654";
		final String name = "AKLJK";
		final String status = "ACTIVE";

		CreateAdminTenantsRequest adminTenant = new CreateAdminTenantsRequest(defaultUserEmail, defaultUserPassword,
				domain, name, status);

		AdminTenants adminTenantsJson = AdminTenants.builder().defaultUserEmail(adminTenant.getDefaultUserEmail())
				.defaultUserPassword(adminTenant.getDefaultUserPassword()).domain(adminTenant.getDomain()).name(adminTenant.getName()).status(adminTenant.getStatus()).
						build();

		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(adminTenantsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdminTenants")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
