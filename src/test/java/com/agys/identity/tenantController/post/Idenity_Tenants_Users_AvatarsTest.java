package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
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
public class Idenity_Tenants_Users_AvatarsTest {

    @Test
    public void postIdenityTenantsUsersAvatars() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersAvatars).then()
                .statusCode(201);
    }

    @Test
    public void postWrongIdenityTenantsUsersAvatars() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersAvatars + 4).then()
                .statusCode(400);
    }

    @Test
    public void postIdenityTenantsUsersAvatarsNoAuthentication() throws JsonProcessingException {
        given()
                .contentType(ContentType.JSON).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLIdentityTenantsUsersAvatars).then()
                .statusCode(401);
    }
}
