package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.utils.CredentialsUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Idenity_Tenants_Users_ProfilesTest {

    private static final String avatar = "//download/pictures/img.jpg";
    private static final String firstName = "John";
    private static final String language = "en";
    private static final String lastName = "Johnmson";
    private static final String newPassword = "passw0rd1";
    private static final String oldPassword = "passw0rd";
    private static final String phone = "35436456";


    @Test
    public void postIdenityTenantsUsersProfiles() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON)
                .body("{ \"avatar\":\"" + avatar +
                        "firstName\":\"" + firstName +
                        "language\":\"" + language +
                        "lastName\":\"" + lastName +
                        "newPassword\":\"" + newPassword +
                        "oldPassword\":\"" + oldPassword +
                        "phone\":\"" + phone + "\"}")
                .when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersProfile).then()
                .statusCode(201);
    }

    @Test
    public void postWrongIdenityTenantsUsersProfiles() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON)
                .body("{ \"avatar\":\"" + avatar +
                        "firstName\":\"" + firstName +
                        "language\":\"" + language +
                        "lastName\":\"" + lastName +
                        "oldPassword\":\"" + oldPassword +
                        "phone\":\"" + phone + "\"}")
                .when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersProfile).then()
                .statusCode(404);
    }

    @Test
    public void postIdenityTenantsUsersProfilesNoAuthentication() throws JsonProcessingException {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"avatar\":\"" + avatar +
                        "firstName\":\"" + firstName +
                        "language\":\"" + language +
                        "lastName\":\"" + lastName +
                        "oldPassword\":\"" + oldPassword +
                        "phone\":\"" + phone + "\"}")
                .when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersProfile).then()
                .statusCode(401);
    }

    @Test
    public void postIdenityTenantsUsersProfilesNoParameters() throws JsonProcessingException {
        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON)
                .when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersProfile).then()
                .statusCode(404);
    }
}
