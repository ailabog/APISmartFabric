package com.APISmartFabric.Tests.GUIRest.DELETE;

import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch Removes GUI Id
 */

public class GUI_By_IdTest41 {
	
	private String id="eb87f0c9-227e-9e90-3276-2d9980f1e03b";
	private String invalidId="4364";
	private String nullId="null";


	@Test
	public void deleteGUIByInvalidId() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLGUI") + invalidId)
				.then().statusCode(404);
	}

	@Test
	public void deleteGUIById() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLGUI") +id)
				.then().statusCode(200);
			
	}
	
	@Test
	public void deleteGUIByNULLId() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLGUI") +nullId)
				.then().statusCode(404);
			
	}
	
	@Test
	public void deleteGUIByIddNoAuthentication() {
		given().
		when().contentType(ContentType.JSON)
		.delete(CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLGUI")
				+id)
				.then().statusCode(401);
	}
}
