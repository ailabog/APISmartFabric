package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.enums.UserIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Identity_Tenants_UsersTenantsTest {

    private UserIdsEnum USER;


    @Test
    public void postTenantsGroupsUsers() {
        String path = CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsUsersTenants;
        System.out.println("URL: " + path);
        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(USER.USER_OK6.getId()).when()
                .post(path)
                .then().statusCode(201);
    }

    @Test
    public void postWrongTenantsGroupsUsers() {
        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body("{\"code\":\"" + USER.USER_OK2.getId() + "\" ]").when()
                .post(CredentialsUtils.IDENTITY
                        + Endpoints.middleURLTenantsUsersTenants)
                .then().statusCode(404);
    }

    @Test
    public void postWrongTenantsGroupsUsersNoAuthentication() {
        given().contentType(ContentType.JSON).body("{\"code\":\"" + USER.USER_OK3.getId() + "\" ]").when().post(
                CredentialsUtils.IDENTITY + Endpoints.middleURLTenantsUsersTenants)
                .then().statusCode(401);
    }
}
