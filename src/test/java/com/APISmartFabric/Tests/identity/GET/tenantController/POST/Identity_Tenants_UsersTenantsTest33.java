package com.APISmartFabric.Tests.identity.GET.tenantController.POST;

import com.APISmartFabric.Enums.UserIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Identity_Tenants_UsersTenantsTest33 {


    private UserIdsEnum USER;

    @Test
    public void postTenantsGroupsUsers() {
        String path = CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTenantsUsersTenants");
        System.out.println("URL: " + path);
        given().header("principal",
                "{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
                .contentType(ContentType.JSON).body(USER.USER_OK6.getId()).when()
                .post(path)
                .then().statusCode(201);
       // RensposeBodyDisplay responseR = new RensposeBodyDisplay();
//        log.info("Response body" + responseR.response());
    }

    @Test
    public void postWrongTenantsGroupsUsers() {
        given().header("principal",
                "{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
                .contentType(ContentType.JSON).body("{\"code\":\"" + USER.USER_OK2.getId() + "\" ]").when()
                .post(CredentialsUtils.getProperty("baseURL")
                        + CredentialsUtils.getProperty("middleURLTenantsUsersTenants"))
                .then().statusCode(404);
        RensposeBodyDisplay responseR = new RensposeBodyDisplay();
        log.info("Response body" + responseR.response());
    }

    @Test
    public void postWrongTenantsGroupsUsersNoAuthentication() {
        given().contentType(ContentType.JSON).body("{\"code\":\"" + USER.USER_OK3.getId() + "\" ]").when().post(
                CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTennatsGroupsUsers"))
                .then().statusCode(401);
        RensposeBodyDisplay responseR = new RensposeBodyDisplay();
        log.info("Response body" + responseR.response());
    }
}
