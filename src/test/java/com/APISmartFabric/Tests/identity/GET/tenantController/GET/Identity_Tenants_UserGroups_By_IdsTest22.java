package com.APISmartFabric.Tests.identity.GET.tenantController.GET;

import com.APISmartFabric.Enums.UsersGroupsIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class Identity_Tenants_UserGroups_By_IdsTest22 {

	private UsersGroupsIdsEnum USERGROUPS;
	
	@Test
	public void getTenantsUserGroupsById() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups")
						+ USERGROUPS.USERSGROUPS_OK1.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Tenants_UserGroups_By_Ids" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUserGroups") + USERGROUPS.USERSGROUPS_OK1.getId());
	}

	@Test
	public void getTenantsUserGroupsByInvalidId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups")
						+ USERGROUPS.USERSGROUPS_INVALID.getId())
				.then().assertThat().statusCode(404);
		log.info("Identity_Tenants_UserGroups_By_Ids" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUserGroups") + USERGROUPS.USERSGROUPS_INVALID.getId());
	}

	@Test
	public void getTenantsUserGroupsByNULLId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch�(test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups")
						+ USERGROUPS.USERSGROUPS_NULL.getId())
				.then().assertThat().statusCode(400);
		log.info("Identity_Tenants_UserGroups_By_Ids" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUserGroups") + USERGROUPS.USERSGROUPS_NULL.getId());
	}

	@Test
	public void getTenantsUserGroupsByIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUserGroups")
						+ USERGROUPS.USERSGROUPS_OK1.getId())
				.then().assertThat().statusCode(401);
		log.info("Identity_Tenants_UserGroups_By_Ids" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUserGroups") + USERGROUPS.USERSGROUPS_OK1.getId());
	}
}