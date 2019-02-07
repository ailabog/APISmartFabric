package com.APISmartFabric.Tests.guiControlPortalRest.GET;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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

public class GUI_Portal_Detailed_ListTest35 {
	private Environments environment;

	@Parameters({"environment"})
	@BeforeTest
	public void setuUp(String environment) {
		this.environment = environment == null ? Environments.GUI : Environments.valueOf(environment);
	}

	@Test
	public void getGUIPortalDetailedList() throws FileNotFoundException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE).
				when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI")
						+ Endpoints.middleURLGUIPortalDetailedList)
				.then().assertThat().statusCode(200);
		log.info("GUI_Portal_Detailed_List" + CredentialsUtils.getProperty("baseURLGUI")
				+ Endpoints.middleURLGUIPortalDetailedList);
	}

	@Test
	public void getGUIPortalDetailedListNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURLGUI") +
						Endpoints.middleURLGUIPortalDetailedList)
				.then().assertThat().statusCode(401);
		log.info("GUI_Portal_Detailed_List" + CredentialsUtils.getProperty("baseURLGUI")
				+ Endpoints.middleURLGUIPortalDetailedList);
	}
}
