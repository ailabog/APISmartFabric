package com.agys.gui.get;

import com.agys.Constants;
import com.agys.Endpoints;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
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
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
						+ Endpoints.middleURLGUIControlRevisionSave)
					.then().assertThat().statusCode(200);
		log.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURLGUI")
		+ Endpoints.middleURLGUIControlRevisionSave);
	}
	
	
	@Test
	public void getGUIControlRevisionSaveNoAuthentication() throws FileNotFoundException {
		given()	
		.when().contentType(ContentType.JSON).get(CredentialsUtils.getProperty("baseURLGUI")
				+ Endpoints.middleURLGUIControlRevisionSave)
		.then().assertThat().statusCode(401);
		log.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURLGUI")
		+ Endpoints.middleURLGUIControlRevisionSave);
	}
}
