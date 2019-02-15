package com.agys.identity.tenantController.post;


import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.UserIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Identity_Tenants_Groups_UsersTest19 {

    private ObjectMapper mapper = new ObjectMapper();

    private List<UserIdsEnum> userList = Arrays.asList(UserIdsEnum.USER_OK1, UserIdsEnum.USER_OK2, UserIdsEnum.USER_OK3,
            UserIdsEnum.USER_OK4, UserIdsEnum.USER_OK5);

    @Test
    public void postTenantsGroupsUsers() throws JsonProcessingException {
        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body(mapper.writeValueAsString(Arrays.asList(UserIdsEnum.USER_OK1.getId()))).when()
                .post(CredentialsUtils.IDENTITY + Endpoints.middleURLTennatsGroupsUsers)
                .then().statusCode(200);
    }

    @Test
    public void postWrongTenantsGroupsUsers() {
        given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
                .contentType(ContentType.JSON).body("[ \"usersIds\":\"" + userList + "\" ]").when()
                .post(CredentialsUtils.IDENTITY
                        + Endpoints.middleURLTennatsGroupsUsers)
                .then().statusCode(404);
    }

    @Test
    public void postWrongTenantsGroupsUsersNoAuthentication() {
        given().
                contentType(ContentType.JSON).body("[ \"usersIds\":\"" + userList + "\" ]").when()
                .post(CredentialsUtils.IDENTITY
                        + Endpoints.middleURLTennatsGroupsUsers)
                .then().statusCode(401);
    }
}
