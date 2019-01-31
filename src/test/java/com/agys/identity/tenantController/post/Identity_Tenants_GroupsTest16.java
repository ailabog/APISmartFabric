package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.TenantsGroups;
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
public class Identity_Tenants_GroupsTest16 {

	private ObjectMapper mapper = new ObjectMapper();
	
	final String code = "67567";
	final String id = "45656786784";
	final String name = "John";
	final String tenantId = "27b8de05-a57c-4983-b07b-d0ef011a9f7c";
	final String type = "TYPE";
	TenantsGroups tenantGroupsJson = TenantsGroups.builder().code(code)
			.id(id).name(name).
					tenantId(tenantId).type(type).
					build();


	@Test
	public void postTenantsGroups() throws JsonProcessingException {


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantGroupsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLTenantsGroups).then()
				.statusCode(201);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongTenantsGroups() throws JsonProcessingException {
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantGroupsJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLTenantsGroups).then()
				.statusCode(401);

		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
