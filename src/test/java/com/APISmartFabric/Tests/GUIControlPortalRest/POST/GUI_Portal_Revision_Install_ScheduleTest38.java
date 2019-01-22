package com.APISmartFabric.Tests.GUIControlPortalRest.POST;

import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import static com.jayway.restassured.RestAssured.given;


public class GUI_Portal_Revision_Install_ScheduleTest38 {
	
	private String active = "true";
	private String guiControlId ="2453645734-76345735-2576348534";
	private String installedGUIControlRevisionId ="275634583456-683458536-8338753";
	private String instanceId="7234wefjwes-82364382y45wefl-2634832";
	private String toBeInstalledGUIControlRevisionId="swjfsdjfweruew-8347nfkdsn-sakfjsd-84375";

	
	@Test
	public void postGUIPortalRevisionInstallSchedule() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType("application/json")
				.body("{\"active\":\"" + active + "\",\n" + "\"guiControlId\":\"" + guiControlId + "\", \n"
						+ "\"installedGUIControlRevisionId\":\"" + installedGUIControlRevisionId + "\", \n" + "\"instanceId\":\"" + instanceId 	+ "\", \n"
						+ "\"toBeInstalledGUIControlRevisionId\":\"" + toBeInstalledGUIControlRevisionId  + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUIPortalRevisionInstallList"))
				.then().statusCode(200);
		
	}

	@Test
	public void postGUIPortalRevisionInstallScheduleNoAuthentication() {
		given()
		.contentType("application/json")
				.body("{\"active\":\"" + active + "\",\n" + "\"guiControlId\":\"" + guiControlId + "\", \n"
						+ "\"installedGUIControlRevisionId\":\"" + installedGUIControlRevisionId + "\", \n" + "\"instanceId\":\"" + instanceId 	+ "\", \n"
						+ "\"toBeInstalledGUIControlRevisionId\":\"" + toBeInstalledGUIControlRevisionId  + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUIPortalRevisionInstallList"))
				.then().statusCode(403);
	}
}
