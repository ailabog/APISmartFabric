package com.APISmartFabric.Tests.identity.GET.tenantController.GET;


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
public class Identity_Tenants_Users_AvatarTest26 {




	@Test
	public void getTenantsUsersAvatars() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersAvatars"))
				.then().assertThat().statusCode(404);
		log.info("Identity_Tenants_Users_Avatar" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLTenantsUsersAvatars"));
	}

	
	@Test
	public void getTenantsUsersAvatarsNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersAvatars"))
				.then().assertThat().statusCode(401);
		log.info("Identity_Tenants_Users_Avatar" + CredentialsUtils.getProperty("baseURL")
		+ CredentialsUtils.getProperty("middleURLTenantsUsersAvatars"));
	}
}
