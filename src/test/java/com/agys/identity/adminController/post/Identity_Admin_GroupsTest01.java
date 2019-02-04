package com.agys.identity.adminController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.jsonBuilder.AdminGroups;
import com.agys.utils.CredentialsUtils;
import com.agys.utils.RensposeBodyDisplay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * @author aila.bogasieru@agys.ch
 */
@Slf4j
public class Identity_Admin_GroupsTest01 {

    private ObjectMapper mapper = new ObjectMapper();

    final String code = "43587784646";
    final String id = "4654677546";
    final String name = "Popescu1";
    final String tenantId = "d634b20d-128e-4a57-97cf-7b7b01aeb901";
    final String type = "SYSTEM";

    @Test
    public void postAdminGroup() throws JsonProcessingException {
        AdminGroups adminGroupsJson = AdminGroups.builder().code(code).id(id).name(name).tenantId(tenantId).type(type).build();

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsJson)).when()
                .post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLAdminGroupsUsers).then()
                .statusCode(201);
    }

    @Test
    public void postTheSameAdminGroup() throws JsonProcessingException {
        AdminGroups adminGroupsJson = AdminGroups.builder().code(code).id(id).name(name).tenantId(tenantId).type(type).build();

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsJson)).when()
                .post(CredentialsUtils.getProperty("baseURL") +  Endpoints.middleURLAdminGroupsUsers).then()
                .statusCode(409);
    }

    @Test
    public void postWrongAdminGroup() throws JsonProcessingException {
        AdminGroups adminGroupsJson = AdminGroups.builder().code(code).id(id).name(name).type(type).build();

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsJson)).when()
                .post(CredentialsUtils.getProperty("baseURL") +  Endpoints.middleURLAdminGroupsUsers).then()
                .statusCode(400);
    }

    @Test
    public void postAdminGroupNoAuthentication() throws JsonProcessingException {
        AdminGroups adminGroupsJson = AdminGroups.builder().code(code).id(id).name(name).tenantId(tenantId).type(type).build();

        given()
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(adminGroupsJson)).when()
                .post(CredentialsUtils.getProperty("baseURL") + Endpoints.middleURLAdminGroupsUsers).then()
                .statusCode(401);
    }
}
