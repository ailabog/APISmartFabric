package com.agys.identity.tenantController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class Identity_Auth_Tenant_System_LoginTest14 {


	@Test
	public void getTenantsUsersSystem() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUsersSystem)
				.then().assertThat().statusCode(200);
		log.info("Identity_Auth_Tenant_System_Login" + CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLTenantsUsersSystem);
	}

	@Test
	public void getUserByIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUsersSystem)
				.then().assertThat().statusCode(401);
		log.info("Identity_Auth_Tenant_System_Login" + CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLTenantsUsersSystem);
	}
}
