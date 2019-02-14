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
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class Identity_Tenants_Users_Manager_By_ManagerIdTest30 {

	private String managerId = "dc959990-42ba-4072-b056-c6eeb877b03a";
	private String notManagerId = "2c39c58f-b4a5-40a9-9826-9dce8b57a2fa";

	@Test
	public void getTenantsUsersManagerByManagerId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsUsersManager + managerId)
				.then().assertThat().statusCode(200);
		log.info("Identity_Tenants_Users_Manager_By_ManagerId" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenantsUsersManager + managerId);
	}

	@Test
	public void getTenantsUsersManagerByManagerIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsUsersManager + managerId)
				.then().assertThat().statusCode(401);
		log.info("Identity_Tenants_Users_Manager_By_ManagerId" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenantsUsersManager + managerId);
	}

	@Test
	public void getTenantsUsersManagerByNotManagerManagerId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.IDENTITY
						+ Endpoints.middleURLTenantsUsersManager + notManagerId)
				.then().assertThat().statusCode(200);
		log.info("Identity_Tenants_Users_Manager_By_ManagerId" + CredentialsUtils.IDENTITY
				+ Endpoints.middleURLTenantsUsersManager + notManagerId);
	}
}
