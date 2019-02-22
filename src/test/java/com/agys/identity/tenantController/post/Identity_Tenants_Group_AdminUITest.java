package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.TenantsGroup;
import com.agys.jsonBuilder.TenantsUsers;
import com.agys.model.Factory;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.JsonHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.ValidatableResponseImpl;
import com.jayway.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.UUID;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Identity_Tenants_Group_AdminUITest {

	private ObjectMapper mapper = new ObjectMapper();

	final String code = "e3f72af2-cc56-4353-abaf-54af2ba47936";
	final String id="ee8e633a-f482-411f-96a5-e3ea154ed504";
	final String name = "Bogasieru";
	final String tenanatId = "3454-34654654-4654654";
	final String type = "type";
	final String groupId = "00000000-0000-0000-0000-000000000001";
	final String groupsPermisId = "4645-4565464";
	final String permission = "w";
	final String permissionType = "type";
	final String targetId = "34534534";
	final String groupIdUserGroup = "e1bf7e32-6846-473c-88df-0b59b4dd5870";
	final String idUserGroup = "e1bf7e32-6846-473c-88df-0b59b4dd5870";
	final String isManager = "true";
	final String userId = "3534534-534543534-3454353";


	TenantsGroup tenantsGroup = TenantsGroup.builder().code(code).id(id).name(name).
					tenanatId(tenanatId).type(type).groupId(groupId).
					groupsPermisId(groupsPermisId).permission(permission).permissionType(permissionType).
					targetId(targetId).groupIdUserGroup(groupIdUserGroup).idUserGroup(idUserGroup).
			        isManager(isManager).userId(userId).build();

	@Test
	public void postIdentityTenantsUsers() throws JsonProcessingException {

		ValidatableResponse vr =
				given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
						.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantsGroup)).when()
						.post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsGroupAdminUI).then()
						.statusCode(201);

		String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

		String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.tenantsGroupClass)).when()
				.get(location)
				.then()
				.contentType(ContentType.JSON).extract().response().asString();

		TenantsGroup tenantsGroup = JsonHelper.readValue(response, TenantsGroup.class);
		assertEquals(Factory.tenantsGroupClass.getCode(), tenantsGroup.getCode(), "Codes are equals");
		assertEquals(Factory.tenantsGroupClass.getId(), tenantsGroup.getId(), "Ids are equals");
		assertEquals(Factory.tenantsGroupClass.getTenanatId(), tenantsGroup.getTenanatId(), "Tenant ids are equals");
		assertEquals(Factory.tenantsGroupClass.getGroupId(), tenantsGroup.getGroupId(), "Group ids are equals");
		assertEquals(Factory.tenantsGroupClass.getIdUserGroup(), tenantsGroup.getIdUserGroup(), "User groups ids  are equals");

		Factory.tenantsGroupClass.setCode(tenantsGroup.getCode());
		Factory.tenantsGroupClass.setId(tenantsGroup.getId());
		Factory.tenantsGroupClass.setTenanatId(tenantsGroup.getTenanatId());
		Factory.tenantsGroupClass.setGroupId(tenantsGroup.getGroupId());
		Factory.tenantsGroupClass.setIdUserGroup(tenantsGroup.getIdUserGroup());
	}

	@Test
	public void postWrongIdentityTenantsUsers() throws JsonProcessingException {

		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantsGroup)).when()
				.post(CredentialsUtils.IDENTITY +  Endpoints.middleURLIdentityTenantsGroupAdminUI).then()
				.statusCode(201);
	}

	@Test
	public void postIdentityTenantsUsersNoAuthentication() throws JsonProcessingException {
			given()
				.contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantsGroup)).when()
				.post(CredentialsUtils.IDENTITY +  Endpoints.middleURLIdentityTenantsGroupAdminUI).then()
				.statusCode(201);
	}
}
