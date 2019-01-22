package com.APISmartFabric.Tests.tenantController.GET;


import org.testng.annotations.Test;
import com.APISmartFabric.Enums.GroupIdsEnum;
import com.APISmartFabric.Utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import static com.jayway.restassured.RestAssured.given;
import java.io.FileNotFoundException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */
@Slf4j
public class Identity_Tenants_Users_Group_By_GroupIdTest28 {

	private GroupIdsEnum GROUP;
	

	@Test
	public void getTenantsUsersGroupByGroupId() throws FileNotFoundException {
		given().header("principal",
				"{ \"tenantId\": \"d634b20d-128e-4a57-97cf-7b7b01aeb901\", \"tenantDomain\": \"DTSW\", \"userId\": \"2c39c58f-b4a5-40a9-9826-9dce8b57a2fa\", \"userEmail\": \"test_user@agys.ch (test_user@agys.ch)\", \"language\": null, \"userFirstName\": null, \"userLastName\": null, \"permissions\": [] }")
				.when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersGroups") + GROUP.GROUP_OK4.getId())
				.then().assertThat().statusCode(200);
		log.info("Identity_Tenants_Users_Group_By_GroupId" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUsersEmailByEmail") + GROUP.GROUP_OK4.getId());
	}

	@Test
	public void getTenantsUsersGroupByGroupIdNoAuthentication() throws FileNotFoundException {
		given().when().contentType(ContentType.JSON)
				.get(CredentialsUtils.getProperty("baseURL")
						+ CredentialsUtils.getProperty("middleURLTenantsUsersGroups") + GROUP.GROUP_OK5.getId())
				.then().assertThat().statusCode(403);
		log.info("Identity_Tenants_Users_Group_By_GroupId" + CredentialsUtils.getProperty("baseURL")
				+ CredentialsUtils.getProperty("middleURLTenantsUsersEmailByEmail") + GROUP.GROUP_OK5.getId());
	}
}
