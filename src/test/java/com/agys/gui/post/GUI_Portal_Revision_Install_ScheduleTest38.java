package com.agys.gui.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.PortalRevisionInstall;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
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

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(portalRevisionInstallJson)).when()
				.post(CredentialsUtils.getProperty("baseURLGUI") + Endpoints.middleURLGUIPortalRevisionInstallList).then()
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
				.post(CredentialsUtils.getProperty("baseURLGUI") + Endpoints.middleURLGUIPortalRevisionInstallList).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
