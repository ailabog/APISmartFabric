package com.APISmartFabric.Tests.adminController.GET;


import org.testng.annotations.Test;
import com.APISmartFabric.Enums.TenantIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Identity_Admin_Tenants_By_TenantIdTest06 {
	

	private TenantIdsEnum TENANT;

	@Test
	public void getUserById() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsTenant") + TENANT.TENANT_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Admin_Tenants_By_TenantId" + CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsTenant") + TENANT.TENANT_OK1.getId());
	}

	@Test
	public void getUserByInvalidId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsTenant") + TENANT.TENANT_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Admin_Tenants_By_TenantId" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminTenantsTenant") + TENANT.TENANT_INVALID.getId());
	}
	
	@Test
	public void getUserByNullId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsTenant") + TENANT.TENANT_NULL.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Admin_Tenants_By_TenantId" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminTenantsTenant") + TENANT.TENANT_NULL.getId());
	}
	
	@Test
	public void getUserByIdNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLAdminTenantsTenant") + TENANT.TENANT_OK2.getId())
				.then().assertThat().statusCode(401);
		log.info("Identity_Admin_Tenants_By_TenantId" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLAdminTenantsTenant") + TENANT.TENANT_OK2.getId());
	}
}
