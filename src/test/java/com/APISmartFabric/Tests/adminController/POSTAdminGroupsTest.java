package com.APISmartFabric.Tests.adminController;

import org.testng.annotations.Test;

/**
	 * @author aila.bogasieru@agys.ch
	 */

import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.controller.AdminController.CreateAdminRequest;

import static com.jayway.restassured.RestAssured.given;

public class POSTAdminGroupsTest {

	final String code = "4354646";
	final String id = "46546546";
	final String name = "Popescu";
	final String tenantId = "35345436ff-3534543-345435";
	final String type = "SYSTEM";
	CreateAdminRequest create = new CreateAdminRequest(code, id, name, tenantId, type);

	@Test
	public void postAdminGroup() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"code\":\"" + create.getCode() + "\",\n" + "\"Id\":\"" + create.getId() + "\", \n"
						+ "\"name\":\"" + create.getName() + "\", \n" + "\"tenantId\":\"" + create.getTenanatId()
						+ "\"type\":\"" + create.getType() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdmin"))
				.then().statusCode(422);
	}

	@Test
	public void postWrongAdminGroup() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"code\":\"" + create.getCode() + "\",\n" + "\"Id\":\"" + create.getId() + "\", \n"
						+ "\"name\":\"" + create.getName() + "\", \n" + "\"tenantId\":\"" + create.getTenanatId()
						+  "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLAdmin"))
				.then().statusCode(422);
	}

}
