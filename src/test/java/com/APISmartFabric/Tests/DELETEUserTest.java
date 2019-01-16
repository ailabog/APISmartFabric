package com.APISmartFabric.Tests;

import org.testng.annotations.Test;

import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.controller.LoginRequest;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

public class DELETEUserTest {

	/**
	 * @author aila.bogasieru@agys.ch
	 * Removes User Group Links 
	 */

	@Test
	public void deleteGroupIdInvalid() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.pathParam("groupId", 27).pathParam("userIds", "ec210").when()
				.delete('"'+CredentialsUtils.getProperty("baseURL")  + CredentialsUtils.getProperty("middleURLUserGroup")+ "/1223/1456"+'"').then().statusCode(500);

	}

	@Test
	public void deleteGroupIdValid() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.pathParam("groupId", 27).pathParam("userIds", "533ab97d-c5dc-4a17-8990-afd9c15ec210").when()
				.delete('"'+CredentialsUtils.getProperty("baseURL")  + CredentialsUtils.getProperty("middleURLUserGroup")+ "/57567/1455676576"+'"').then().statusCode(200);

	}

}
