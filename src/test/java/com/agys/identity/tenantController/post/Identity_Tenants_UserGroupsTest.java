package com.agys.identity.tenantController.post;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.Environments;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.agys.enums.GroupIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Identity_Tenants_UserGroupsTest {

    private GroupIdsEnum GROUPS;

    @Test
    public void postTenantsGroupsUsers() {
        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).
                body("{ \"groupId\":\"" + GROUPS.GROUP_OK1.getId() + "\"}").when()
                .post(CredentialsUtils.IDENTITY
                        + Endpoints.middleURLTenantsUserGroups)
                .then().statusCode(201);
    }

    @Test
    public void postWrongTenantsGroupsUsersNoAuthentication() {
        given().
                contentType(ContentType.JSON).
                body("{ \"groupId\":\"" + GROUPS.GROUP_OK2.getId() + "\"}").when()
                .post(CredentialsUtils.IDENTITY
                        + Endpoints.middleURLTenantsUserGroups)
                .then().statusCode(401);
    }
}
