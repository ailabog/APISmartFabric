package com.APISmartFabric.Tests.gui.GUIControlPortalRest.POST;


import com.APISmartFabric.JsonBuilder.PortalRevisionInstall;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class GUI_Portal_Revision_Install_ScheduleTest38 {

	private ObjectMapper mapper = new ObjectMapper();
	
	private String active = "true";
	private String guiControlId ="2453645734-76345735-2576348534";
	private String installedGUIControlRevisionId ="275634583456-683458536-8338753";
	private String instanceId="7234wefjwes-82364382y45wefl-2634832";
	private String toBeInstalledGUIControlRevisionId="swjfsdjfweruew-8347nfkdsn-sakfjsd-84375";

	
	@Test
	public void postGUIPortalRevisionInstallSchedule() throws JsonProcessingException {
		PortalRevisionInstall portalRevisionInstallJson = PortalRevisionInstall.builder().active(active)
				.guiControlId(guiControlId).installedGUIControlRevisionId(installedGUIControlRevisionId).
				instanceId(instanceId).toBeInstalledGUIControlRevisionId(toBeInstalledGUIControlRevisionId)	.
				build();

		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(portalRevisionInstallJson)).when()
				.post(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUIPortalRevisionInstallList")).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postGUIPortalRevisionInstallScheduleNoAuthentication() throws JsonProcessingException {
		PortalRevisionInstall portalRevisionInstallJson = PortalRevisionInstall.builder().active(active)
				.guiControlId(guiControlId).installedGUIControlRevisionId(installedGUIControlRevisionId).
						instanceId(instanceId).toBeInstalledGUIControlRevisionId(toBeInstalledGUIControlRevisionId)	.
						build();

		given().contentType(ContentType.JSON).body(mapper.writeValueAsString(portalRevisionInstallJson)).when()
				.post(CredentialsUtils.getProperty("baseURLGUI") + CredentialsUtils.getProperty("middleURLGUIPortalRevisionInstallList")).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
