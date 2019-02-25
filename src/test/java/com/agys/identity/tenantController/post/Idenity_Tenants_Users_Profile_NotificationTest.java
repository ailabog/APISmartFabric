package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.TenantsUsers;
import com.agys.jsonBuilder.TenantsUsersProfileNotification;
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
public class Idenity_Tenants_Users_Profile_NotificationTest {

    private ObjectMapper mapper = new ObjectMapper();

    final String appNot = "true";
    final String diagramModifiedNot = "true";
    final String email = "true";
    final String inApp = "true";
    final String interfaceModifiedNot = "true";
    final String interfaceNot = "true";
    final String sms = "true";
    final String taskNot = "true";
    final String taskRoleNot = "true";
    final String userId = "78c38837-8af3-438a-8560-0d73d8915ceb";

    TenantsUsersProfileNotification tenantsUsersProfileNotification = TenantsUsersProfileNotification.builder().appNot(appNot)
            .diagramModifiedNot(diagramModifiedNot).inApp(inApp).
                    email(email).interfaceModifiedNot(interfaceModifiedNot).interfaceNot(interfaceNot).
                    sms(sms).taskNot(taskNot).taskRoleNot(taskRoleNot).
                    userId(userId).build();

    @Test
    public void postIdenityTenantsUsersProfileNotification() throws JsonProcessingException {

        ValidatableResponse vr =
                given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                        .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantsUsersProfileNotification)).when()
                        .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersProfileNotification).then()
                        .statusCode(201);

        String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

        String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.tenantsUsers)).when()
                .get(location)
                .then()
                .contentType(ContentType.JSON).extract().response().asString();

        TenantsUsersProfileNotification tenantsUsersProfileNotification = JsonHelper.readValue(response, TenantsUsersProfileNotification.class);
        assertEquals(Factory.tenantsUsersProfileNotificationClass.getUserId(), tenantsUsersProfileNotification.getUserId(), "User ids are equals");

        Factory.tenantsUsersProfileNotificationClass.setUserId(tenantsUsersProfileNotification.getUserId());
    }

    @Test
    public void postWrongIdenityTenantsUsersProfileNotification() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantsUsersProfileNotification)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersProfileNotification +3).then()
                .statusCode(400);
    }

    @Test
    public void postIdenityTenantsUsersProfileNotificationNoAuthentication() throws JsonProcessingException {
        given()
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantsUsersProfileNotification)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersProfileNotification).then()
                .statusCode(401);
    }
}
