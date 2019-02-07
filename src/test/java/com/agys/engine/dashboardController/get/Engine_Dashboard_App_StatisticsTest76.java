package com.agys.engine.dashboardController.get;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class Engine_Dashboard_App_StatisticsTest76 {

	private String isTeamYes="true";
	private String isTeamNo="false";

	private Environments environment;

	@Parameters({"environment"})
	@BeforeTest
	public void setuUp(String environment) {
		this.environment = environment == null ? Environments.ENGINE : Environments.valueOf(environment);
	}

	@Test
	public void getEngineDashboardAppStatisticsYesTeam() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineDashboardAppStatistics + isTeamYes)
					.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineDashboardAppStatistics + isTeamYes);
	}

	@Test
	public void getEngineDashboardAppStatisticsNoTeam() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
						+ Endpoints.middleURLEngineDashboardAppStatistics + isTeamNo)
				.then().assertThat().statusCode(200);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineDashboardAppStatistics + isTeamNo);
	}

	@Test
	public void getEngineDashboardAppStatisticsNoAuthentication() throws FileNotFoundException {
		given()
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineDashboardAppStatistics)
				.then().assertThat().statusCode(401);
		log.info("Catalog_Data_Catalogs_Definition_Version_By_VersionId_ProcessDefinitionId_By_ProcessDefinitionId" + CredentialsUtils.getProperty("baseURLEngine")
				+ Endpoints.middleURLEngineDashboardAppStatistics);
	}
}
