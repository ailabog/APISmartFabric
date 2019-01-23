package com.APISmartFabric.Tests.authenticationController.GET;

import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import com.APISmartFabric.Enums.TenantDomainEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Identity_Auth_TenantAnonLogin_By_TenantDomainTest12 {
	

	private TenantDomainEnum TENANT_DOMAIN;


	@Test
	public void getTenantByTenantDomain() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Auth_TenantAnonLogin_By_TenantDomain" + (CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_OK1.getId()));
	}

	@Test
	public void getTenantByInvalidTenantDomain() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Auth_TenantAnonLogin_By_TenantDomain" + (CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_INVALID.getId()));
	}
	
	@Test
	public void getTenantByNULLTenantDomain() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_NULL.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Auth_TenantAnonLogin_By_TenantDomain" + (CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_NULL.getId()));
	}
	
	@Test
	public void getTenantByTenantDomainNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_OK2.getId())
				.then().assertThat().statusCode(401);
		log.info("Identity_Auth_TenantAnonLogin_By_TenantDomain" + (CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenant") + TENANT_DOMAIN.TENANT_DOMAIN_OK2.getId()));
	}
}
