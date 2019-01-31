package com.agys.identity.tenantController.get;

import com.agys.Constants;
import com.agys.Endpoints;
import org.testng.annotations.Test;
import com.agys.enums.UserIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class Identity_Tenants_UsersTenants_By_UserIdTest34 {

	private UserIdsEnum USERS;

	@Test
	public void getTenantsUsersByUserId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUsersTenants + USERS.USER_OK2.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Tenants_UsersTenants_By_UserId" + CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLTenantsUsersTenants + USERS.USER_OK2.getId());
	}

	@Test
	public void getTenantsUsersByInvalidUserId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUsersTenants + USERS.USER_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Tenants_UsersTenants_By_UserId" + CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLTenantsUsersTenants + USERS.USER_INVALID.getId());
	}

	@Test
	public void getTenantsUsersByNULLUserId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUsersTenants + USERS.USER_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Identity_Tenants_UsersTenants_By_UserId" + CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLTenantsUsersTenants + USERS.USER_NULL.getId());
	}

	@Test
	public void getTenantsUsersByUserIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUsersTenants + USERS.USER_OK1.getId())
				.then().assertThat().statusCode(401);
		log.info("Identity_Tenants_UsersTenants_By_UserId" + CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLTenantsUsersTenants + USERS.USER_OK1.getId());
	}
}
