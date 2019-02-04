package com.agys.identity.tenantController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.TenantsGroupsPermission;
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
public class Identity_Tenants_Groups_PermissionsTest18 {

	private ObjectMapper mapper = new ObjectMapper();
	

	final String groupId = "da26c865-4ef0-4e33-87fe-54fdec501ec5";
	final String id = "45656786784";
	final String permission = "";
	final String permissionType = "DOCUMENT_TEMPLATE";
	final String targetId = "TYPE";
	TenantsGroupsPermission tenantGroupsPermissionJson = TenantsGroupsPermission.builder().groupId(groupId)
			.id(id).permission(permission).
					permissionType(permissionType).targetId(targetId).
					build();

	@Test
	public void postTenantsGroupsPermissions() throws JsonProcessingException {


		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantGroupsPermissionJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middlerURLTenantsGroupsPermissions).then()
				.statusCode(201);
	}

	@Test
	public void postWrongTenantsGroupsPermissions() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantGroupsPermissionJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middlerURLTenantsGroupsPermissions +5).then()
				.statusCode(404);
	}
	
	@Test
	public void postTenantsGroupsPermissionsNoAuthentication() throws JsonProcessingException {
		given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantGroupsPermissionJson)).when()
				.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middlerURLTenantsGroupsPermissions).then()
				.statusCode(401);
   }
}
