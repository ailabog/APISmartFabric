package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import com.agys.jsonBuilder.TenantsGroups;
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
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class Identity_Tenants_GroupsTest {

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

        ValidatableResponse vr =
                given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                        .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantGroupsJson)).when()
                        .post(CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsGroups).then()
                        .statusCode(201);

        String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

        String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.tenantsGroups)).when()
                .get(location)
                .then()
                .contentType(ContentType.JSON).extract().response().asString();

        TenantsGroups tenantsGroupsClass = JsonHelper.readValue(response, TenantsGroups.class);
        assertEquals(Factory.tenantsGroups.getCode(), tenantsGroupsClass.getCode(), "Codes are equals");
        assertEquals(Factory.tenantsGroups.getId(), tenantsGroupsClass.getId(), "Ids are equals");
        assertEquals(Factory.tenantsGroups.getTenantId(), tenantsGroupsClass.getTenantId(), "Tenant Ids are equals");

        Factory.tenantsGroups.setCode(tenantsGroupsClass.getCode());
        Factory.tenantsGroups.setId(tenantsGroupsClass.getId());
        Factory.tenantsGroups.setTenantId(tenantsGroupsClass.getTenantId());
    }

    @Test
    public void postWrongTenantsGroups() throws JsonProcessingException {
        System.out.println(CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsGroups);
        given()
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantGroupsJson)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsGroups).then()
                .statusCode(401);
    }
}
