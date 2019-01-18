package com.APISmartFabric.Tests.authenticationController.GET;

import org.testng.annotations.Test;

import com.APISmartFabric.Enums.TenantDomainEnum;
import com.APISmartFabric.Enums.UserIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */


public class Identity_Auth_TenantAnonLogin_By_TenantDomainTest12 {
	

	private TenantDomainEnum TENANT_DOMAIN;

	@Test
	public void getTenantByTenantDomain() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_OK1.getId())
				.then().assertThat().statusCode(200);
	}

	@Test
	public void getTenantByInvalidTenantDomain() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_INVALID.getId())
				.then().assertThat().statusCode(404);
	}
	
	@Test
	public void getTenantByNULLTenantDomain() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_NULL.getId())
				.then().assertThat().statusCode(404);
	}
	
	@Test
	public void getTenantByTenantDomainNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType("application/json").get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_OK2.getId())
				.then().assertThat().statusCode(403);
	}
}
