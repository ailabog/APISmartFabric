package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
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
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.UUID;

@Slf4j
public class Idenity_Tenants_UsersTest {

    private ObjectMapper mapper = new ObjectMapper();

    final String code = "35";
    final String email = UUID.randomUUID() + "@testfabric.ch";
    final String firstName = "Aila";
    final String lastName = "Bogasieru";
    final String gender = "FEMALE";
    final String language = "English";
    final String password = "Pawdfg";
    final String phone = "325345436";
    final String status = "ACTIVE";
    final String title = "Admin";
    final String token = "365456";
    final String tokenExpiry = "2019-01-11T13:31:19.825Z";

    TenantsUsers tenantUsersJson = TenantsUsers.builder().code(code)
            .email(email).firstName(firstName).
                    lastName(lastName).gender(gender).language(language).
                    password(password).phone(phone).status(status).
                    title(title).token(token).tokenExpiry(tokenExpiry).
                    build();

    @Test
    public void postIdenityTenantsUsers() throws JsonProcessingException {

        ValidatableResponse vr =
                given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                        .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantUsersJson)).when()
                        .post(CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsUsers).then()
                        .statusCode(201);

        String location = ((ValidatableResponseImpl) vr).originalResponse().header("Location");

        String response = given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(Factory.tenantsUsers)).when()
                .get(location)
                .then()
                .contentType(ContentType.JSON).extract().response().asString();

        TenantsUsers tenantsUsersClass = JsonHelper.readValue(response, TenantsUsers.class);
        assertEquals(Factory.tenantsUsers.getCode(), tenantsUsersClass.getCode(), "Codes are equals");
        assertEquals(Factory.tenantsUsers.getEmail(), tenantsUsersClass.getEmail(), "Emails are equals");
        assertEquals(Factory.tenantsUsers.getPhone(), tenantsUsersClass.getPhone(), "Phones are equals");
        assertEquals(Factory.tenantsUsers.getStatus(), tenantsUsersClass.getStatus(), "Statuses are equals");
        assertEquals(Factory.tenantsUsers.getTitle(), tenantsUsersClass.getTitle(), "Titles are equals");

        Factory.tenantsUsers.setCode(tenantsUsersClass.getCode());
        Factory.tenantsUsers.setEmail(tenantsUsersClass.getEmail());
        Factory.tenantsUsers.setPhone(tenantsUsersClass.getPhone());
        Factory.tenantsUsers.setStatus(tenantsUsersClass.getStatus());
    }

    @Test
    public void postWrongIdenityTenantsUsers() throws JsonProcessingException {

        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantUsersJson)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsUsers + 3).then()
                .statusCode(404);
    }

    @Test
    public void postIdenityTenantsUsersNoAuthentication() throws JsonProcessingException {
        given()
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(tenantUsersJson)).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsUsers).then()
                .statusCode(401);
    }
}
