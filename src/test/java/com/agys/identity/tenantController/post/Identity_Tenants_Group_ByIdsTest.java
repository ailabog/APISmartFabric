package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.TenantsGroup;
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
public class Identity_Tenants_Group_ByIdsTest {

    private ObjectMapper mapper = new ObjectMapper();

    final String groupId = "00000000-0000-0000-0000-000000000001";


    @Test
    public void postIdentityTenantsGroupByIds() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON)
                .body("{ \"groupId\":\"" + groupId + "\"}")
                .when().post(CredentialsUtils.IDENTITY
                + Endpoints.middleURLIdentityTenantsGroups)
                .then().assertThat().statusCode(201);
    }

    @Test
    public void postWrongIdentityTenantsGroupByIds() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON)
                .when().post(CredentialsUtils.IDENTITY
                + Endpoints.middleURLIdentityTenantsGroups)
                .then().assertThat().statusCode(404);
    }

    @Test
    public void postWrongIdentityTenantsGroupByIdsNoAutehentication() throws JsonProcessingException {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"groupId\":\"" + groupId + "\"}")
                .when().post(CredentialsUtils.IDENTITY
                + Endpoints.middleURLIdentityTenantsGroups)
                .then().assertThat().statusCode(401);
    }
}
