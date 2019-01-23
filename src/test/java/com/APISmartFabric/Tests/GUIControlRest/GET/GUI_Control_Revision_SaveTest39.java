package com.APISmartFabric.Tests.GUIControlRest.GET;

import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
@author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class GUI_Control_Revision_SaveTest39 {


	@Test
	public void getGUIControlRevisionSave() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIControlRevisionSave"))
					.then().assertThat().statusCode(200);
		log.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURLGUI")
		+ CredentialsUtils.getProperty("middleURLGUIControlRevisionSave"));
	}
	
	
	@Test
	public void getGUIControlRevisionSaveNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIControlRevisionSave"))
		.then().assertThat().statusCode(401);
		log.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURLGUI")
		+ CredentialsUtils.getProperty("middleURLGUIControlRevisionSave"));
	}
}
