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
public class Identity_Tenants_Group_CodesTest {

    final String code = "345436-46546-6-00045650-465445654";
    final String userId = "00000000-0000-0000-0000-000000000001";


    @Test
    public void postIdentityTenantsGroupCodes() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON)
                .body("{ \"code\":\"" + code + "\"}")
                .when().post(CredentialsUtils.IDENTITY
                + Endpoints.middleURLIdentityTenantsGroupsCodes + userId)
                .then().assertThat().statusCode(201);
    }

    @Test
    public void postWrongIdentityTenantsGroupCodes() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON)
                .when().post(CredentialsUtils.IDENTITY
                + Endpoints.middleURLIdentityTenantsGroupsCodes + userId)
                .then().assertThat().statusCode(404);
    }

    @Test
    public void postIdentityTenantsGroupCodesNoAutehentication() throws JsonProcessingException {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"code\":\"" + code + "\"}")
                .when().post(CredentialsUtils.IDENTITY
                + Endpoints.middleURLIdentityTenantsGroupsCodes + userId)
                .then().assertThat().statusCode(401);
    }
}
