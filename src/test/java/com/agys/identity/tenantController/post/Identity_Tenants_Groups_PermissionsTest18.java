package com.agys.identity.tenantController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.TenantsGroupsPermission;
import com.agys.jsonBuilder.TenantsUsers;
import com.agys.model.Factory;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;

import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Identity_Tenants_Groups_PermissionsTest18 {

	private ObjectMapper mapper = new ObjectMapper();
	

	final String groupId = "da26c865-4ef0-4e33-87fe-54fdec501ec5";
	final String id = "45656786784";
	final String permission = "";
	final String permissionType = "DOCUMENT_TEMPLATE";
	final String targetId = "TYPE";
	private Environments environment;

	@Parameters({"environment"})
	@BeforeTest
	public void setuUp(String environment) {
		this.environment = environment == null ? Environments.IDENTITY : Environments.valueOf(environment);
	}
	TenantsGroupsPermission tenantGroupsPermissionJson = TenantsGroupsPermission.builder().groupId(groupId)
			.id(id).permission(permission).
					permissionType(permissionType).targetId(targetId).
					build();

	@Test
	public void postTenantsGroupsPermissions() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantGroupsPermissionJson)).when()
						.post(CredentialsUtils.getProperty("baseURL") + Endpoints.middlerURLTenantsGroupsPermissions).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.tenantsGroupsPermission)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		TenantsGroupsPermission tenantsGroupsPermissionClass = JsonHelper.readValue(response, TenantsGroupsPermission.class);
		assertEquals(Factory.tenantsGroupsPermission.getGroupId(), tenantsGroupsPermissionClass.getGroupId(), "Group Ids are equals");
		assertEquals(Factory.tenantsGroupsPermission.getId(), tenantsGroupsPermissionClass.getId(), "Ids are equals");
		assertEquals(Factory.tenantsGroupsPermission.getPermission(), tenantsGroupsPermissionClass.getPermission(), "Permissions are equals");

		Factory.tenantsGroupsPermission.setGroupId(tenantsGroupsPermissionClass.getGroupId());
		Factory.tenantsGroupsPermission.setId(tenantsGroupsPermissionClass.getId());
		Factory.tenantsGroupsPermission.setPermission(tenantsGroupsPermissionClass.getPermission());
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
