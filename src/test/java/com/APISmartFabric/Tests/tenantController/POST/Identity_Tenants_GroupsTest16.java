package com.APISmartFabric.Tests.tenantController.POST;

import org.testng.annotations.Test;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.APISmartFabric.Utils.RensposeBodyDisplay;
import com.APISmartFabric.controller.AdminController.CreateTenantsGroupsRequest;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import static com.jayway.restassured.RestAssured.given;

@Slf4j
public class Identity_Tenants_GroupsTest16 {
	
	final String code = "67567";
	final String id = "45656786784";
	final String name = "John";
	final String tenantId = "27b8de05-a57c-4983-b07b-d0ef011a9f7c";
	final String type = "TYPE";

	CreateTenantsGroupsRequest createTenantGroup = new CreateTenantsGroupsRequest(code, id, name, tenantId, type);

	@Test
	public void postTenantsGroups() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"code\":\"" + createTenantGroup.getCode() + "\",\n" + "\"id\":\"" + createTenantGroup.getId() + "\", \n"
						+ "\"name\":\"" + createTenantGroup.getName() + "\", \n" + "\"tenantId\":\"" + createTenantGroup.getTenantId()
						+ "\"type\":\"" + createTenantGroup.getType() + "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTenantsGroups"))
				.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}

	@Test
	public void postWrongTenantsGroups() {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.contentType(ContentType.JSON)
				.body("{\"code\":\"" + createTenantGroup.getCode() + "\",\n" + "\"id\":\"" + createTenantGroup.getId() + "\", \n"
						+ "\"name\":\"" + createTenantGroup.getName() + "\", \n" + "\"tenantId\":\"" + createTenantGroup.getTenantId()
					+ "\" }")
				.when().post(CredentialsUtils.getProperty("baseURL") + CredentialsUtils.getProperty("middleURLTenantsGroups"))
				.then().statusCode(201);
		RensposeBodyDisplay responseR = new RensposeBodyDisplay();
		log.info("Response body" + responseR.response());
	}
}
