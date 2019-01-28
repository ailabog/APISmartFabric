package com.APISmartFabric.Tests.GUIRest.GET;


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
public class GUI_All_Version_By_VersionIdTest43 {
	
	private String versionId  ="e0216c9a-6f81-4d12-93f2-8b5f9bd2c2a6";
	private String invalidVersionId = "0";
	private  String nullVersionId ="null";

	@Test
	public void getGUIAllVersionByVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIAllVersion") + versionId)
				.then().assertThat().statusCode(200);
		log.info("GUI_All_Version_By_Version Id" + CredentialsUtils.getProperty("baseURLGUI")
		+ CredentialsUtils.getProperty("middleURLGUIAllVersion") + versionId);
	}
	
	@Test
	public void getGUIAllVersionByInvalidVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
						+ CredentialsUtils.getProperty("middleURLGUIAllVersion") + invalidVersionId)
				.then().assertThat().statusCode(404);
		log.info("GUI_All_Version_By_Version Id" + CredentialsUtils.getProperty("baseURLGUI")
		+ CredentialsUtils.getProperty("middleURLGUIAllVersion") + invalidVersionId);
	}
	
	@Test
	public void getGUIAllVersionByNULLVersionId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
		.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIAllVersion") + nullVersionId)
		.then().assertThat().statusCode(400);
		log.info("GUI_All_Version_By_Version Id" + CredentialsUtils.getProperty("baseURLGUI")
		+ CredentialsUtils.getProperty("middleURLGUIAllVersion") + nullVersionId);
	}

	
	@Test
	public void getGUIAllVersionByVersionIdNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
				+ CredentialsUtils.getProperty("middleURLGUIAllVersion") + versionId)
		.then().assertThat().statusCode(401);
		log.info("GUI_All_Version_By_Version Id" + CredentialsUtils.getProperty("baseURLGUI")
		+ CredentialsUtils.getProperty("middleURLGUIAllVersion") + versionId);
	}
}
