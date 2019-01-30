package com.agys.identity.adminController.get;


import com.agys.Constants;
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
public class Identity_Admin_Users_ByUserIdTest10 {

	private UserIdsEnum USER;

	@Test
	public void getAdminUserByUserId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLUser") + USER.USER_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Admin_Users_ByUserId" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLUser") + USER.USER_OK1.getId());
	}

	@Test
	public void getAdminUserByInvalidUserId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLUser") + USER.USER_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Admin_Users_ByUserId" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLUser") + USER.USER_INVALID.getId());
	}

	@Test
	public void getAdminUserByNULLUserId() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLUser") + USER.USER_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Identity_Admin_Users_ByUserId" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLUser") + USER.USER_NULL.getId());
	}

	@Test
	public void getAdminUserByUserIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLUser") + USER.USER_OK2.getId()).then().assertThat()
				.statusCode(401);
		log.info("Identity_Admin_Users_ByUserId" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLUser") + USER.USER_OK2.getId());
	}

}
