package com.agys.identity.tenantController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Identity_Tenants_Users_AvatarTest {

	@Test
	public void getTenantsUsersAvatars() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsUsersAvatars+"/100x100")
				.then().assertThat().statusCode(200);
		log.info("Identity_Tenants_Users_Avatar" + CredentialsUtils.IDENTITY
		+ Endpoints.middleURLTenantsUsersAvatars);
	}

	
	@Test
	public void getTenantsUsersAvatarsNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsUsersAvatars)
				.then().assertThat().statusCode(401);
		log.info("Identity_Tenants_Users_Avatar" + CredentialsUtils.IDENTITY
		+ Endpoints.middleURLTenantsUsersAvatars);
	}
}
