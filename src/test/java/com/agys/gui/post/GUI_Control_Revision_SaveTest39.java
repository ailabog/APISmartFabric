package com.agys.gui.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.GuiControlRevisionSave;
import com.agys.jsonBuilder.PortalRevisionInstall;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	private ObjectMapper mapper = new ObjectMapper();

	private String code = "34535";
	private String config ="34543";
	private String fileName ="trr";
	private String fileType="tert";
	private String fileUUID="3456464";
	private String guiControlId="46456";
	private String guiControlRevisionId="34645";
	private String revision ="10";

	GuiControlRevisionSave guiControlRevisionSave = GuiControlRevisionSave.builder().code(code)
			.config(config).fileName(fileName).
					fileType(fileType).fileUUID(fileUUID).guiControlId(guiControlId).guiControlRevisionId(guiControlRevisionId).revision(revision).
					build();

	@Test
	public void postGUIControlRevisionSave() throws FileNotFoundException, JsonProcessingException {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON).post(CredentialsUtils.getProperty("baseURLGUI")
						+ Endpoints.middleURLGUIControlRevisionSave)
					.then().assertThat().statusCode(201);
		log.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURLGUI")
		+ Endpoints.middleURLGUIControlRevisionSave);


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(guiControlRevisionSave)).when()
				.post(CredentialsUtils.getProperty("baseURLGUI") + Endpoints.middleURLGUIControlRevisionSave).then()
				.statusCode(201);
	}
	
	
	@Test
	public void postGUIControlRevisionSaveNoAuthentication() throws FileNotFoundException, JsonProcessingException {
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(guiControlRevisionSave)).when()
				.post(CredentialsUtils.getProperty("baseURLGUI") + Endpoints.middleURLGUIControlRevisionSave)
		.then().assertThat().statusCode(401);
		log.info("GUI_Control_Revision_Save" + CredentialsUtils.getProperty("baseURLGUI")
		+ Endpoints.middleURLGUIControlRevisionSave);
	}
}
