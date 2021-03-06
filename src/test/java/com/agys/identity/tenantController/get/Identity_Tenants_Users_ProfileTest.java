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
public class Identity_Tenants_Users_ProfileTest {


	@Test
	public void getTenantsUsersProfile() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsUsersProfile)
				.then().assertThat().statusCode(200);
		log.info("Identity_Tenants_Users_Profile" + CredentialsUtils.IDENTITY
		+ Endpoints.middleURLTenantsUsersProfile);
	}

	
	@Test
	public void getTenantsUsersProfileNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON).get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsUsersProfile)
				.then().assertThat().statusCode(401);
		log.info("Identity_Tenants_Users_Profile" + CredentialsUtils.IDENTITY
		+ Endpoints.middleURLTenantsUsersProfile);
	}
}
