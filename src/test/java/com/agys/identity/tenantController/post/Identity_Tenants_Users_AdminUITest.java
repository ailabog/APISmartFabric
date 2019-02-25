package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.TenantsGroup;
import com.agys.jsonBuilder.TenantsUser;
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

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Identity_Tenants_Users_AdminUITest {

    private ObjectMapper mapper = new ObjectMapper();

    final String avatarPath = "//downloads/pictures/";
    final String code = "ee8e633a-f482-411f-96a5-e3ea154ed504";
    final String department = "";
    final String email = "admin@fabric.ch";
    final String firstName = "John";
    final String gender = "FEMALE";
    final String id = "4525f6a0-f5a3-4120-9c20-933260bf37a1";
    final String language = "en";
    final String lastName = "Petterson";
    final String password = "passw0rd";
    final String passwordLastUpdate = "";
    final String phone = "345436456";
    final String position = "";
    final String reportsTo = "";
    final String status = "ACT";
    final String title = "Mrs";
    final String username = "aila";
    final String groupId = "e3f72af2-cc56-4353-abaf-54af2ba47936";
    final String userGroupId = "ee8e633a-f482-411f-96a5-e3ea154ed504";
    final String isManager = "true";
    final String userId = "00000000-0000-0000-0000-000000000001";
    final String userTenantPermissionId = "";
    final String permission = "w";
    final String permissionType = "type";
    final String targetId = "943ce705-bda9-49cc-b499-6abf72422f2e";
    final String userTenantId = "930334d2-15fc-419c-9bfa-253ede554c33";


    TenantsUser tenantsUser = TenantsUser.builder().avatarPath(avatarPath).code(code).department(department).
            email(email).firstName(firstName).gender(gender).
            id(id).language(language).
            lastName(lastName).password(password).passwordLastUpdate(passwordLastUpdate).
            phone(phone).position(position).reportsTo(reportsTo).status(status).title(title).username(username).groupId(groupId).userGroupId(userGroupId).
            isManager(isManager).userId(userId).userTenantPermissionId(userTenantPermissionId).permission(permission).permissionType(permissionType).
            targetId(targetId).userTenantId(userTenantId).build();

    @Test
    public void postIdentityTenantsUsersAdminUI() throws JsonProcessingException {

        ValidatableResponse vr =
                given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                        .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantsUser)).when()
                        .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersAdminUI).then()
                        .statusCode(201);

        String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

        String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.tenantsGroupClass)).when()
                .get(location)
                .then()
                .contentType(ContentType.JSON).extract().response().asString();

        TenantsUser tenantsUser = JsonHelper.readValue(response, TenantsUser.class);
        assertEquals(Factory.tenantsUserClass.getCode(), tenantsUser.getCode(), "Codes are equals");
        assertEquals(Factory.tenantsUserClass.getId(), tenantsUser.getId(), "Ids are equals");
        assertEquals(Factory.tenantsUserClass.getEmail(), tenantsUser.getEmail(), "Emails are equals");
        assertEquals(Factory.tenantsUserClass.getGroupId(), tenantsUser.getGroupId(), "Group ids are equals");
        assertEquals(Factory.tenantsUserClass.getUsername(), tenantsUser.getUsername(), "User names are equals");
        assertEquals(Factory.tenantsUserClass.getUserId(), tenantsUser.getUserId(), "User ids are equals");
        assertEquals(Factory.tenantsUserClass.getUserTenantId(), tenantsUser.getUserTenantId(), "User tenant ids are equals");

        Factory.tenantsUserClass.setCode(tenantsUser.getCode());
        Factory.tenantsUserClass.setId(tenantsUser.getId());
        Factory.tenantsUserClass.setEmail(tenantsUser.getEmail());
        Factory.tenantsGroupClass.setGroupId(tenantsUser.getGroupId());
        Factory.tenantsGroupClass.setIdUserGroup(tenantsUser.getUsername());
        Factory.tenantsGroupClass.setIdUserGroup(tenantsUser.getUserId());
        Factory.tenantsGroupClass.setIdUserGroup(tenantsUser.getUserTenantId());
    }

    @Test
    public void postWrongIdentityTenantsUsersAdminUI() throws JsonProcessingException {

        TenantsUser tenantsUser1 = TenantsUser.builder().avatarPath(avatarPath).code(code).department(department).
                email(email).firstName(firstName).gender(gender).
                id(id).language(language).
                lastName(lastName).password(password).passwordLastUpdate(passwordLastUpdate).
                phone(phone).position(position).reportsTo(reportsTo).status(status).title(title).username(username).groupId(groupId).userGroupId(userGroupId).
                isManager(isManager).userId(userId).userTenantPermissionId(userTenantPermissionId).permission(permission).permissionType(permissionType).
                targetId(targetId).build();

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantsUser1)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersAdminUI).then()
                .statusCode(404);
    }

    @Test
    public void postIdentityTenantsUsersAdminUINoAuthentication() throws JsonProcessingException {
        given()
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantsUser)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersAdminUI).then()
                .statusCode(401);
    }
}
