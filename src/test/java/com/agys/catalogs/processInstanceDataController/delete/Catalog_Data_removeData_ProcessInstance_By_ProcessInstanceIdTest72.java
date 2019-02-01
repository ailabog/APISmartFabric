package com.agys.catalogs.processInstanceDataController.delete;

import com.agys.Constants;
import com.agys.Endpoints;
import com.agys.enums.GroupIdsEnum;
import com.agys.enums.UserIdsEnum;
import com.agys.utils.CredentialsUtils;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;

import static com.agys.Constants.PRINCIPAL_HEADER_NAME;
import static com.jayway.restassured.RestAssured.given;

/**
 * 
 * @author aila.bogasieru@agys.ch Removes User Group Links
 */

public class Catalog_Data_Query_ProcessDefinition_By_ProcessDefinitionIdTest72 {

	private String processInstanceId ="4525f6a0-f5a3-4120-9c20-933260bf37a1";

	@Test
	public void deleteCatalogDataQueryProcessDefinitionByProcessDefinitionId() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUserGroups +GROUP.GROUP_INVALID.getId() + "/" + USER.USER_INVALID.getId())
				.then().statusCode(404);
	}

	@Test
	public void deleteCatalogDataQueryProcessDefinitionByInvalidProcessDefinitionId() {
		given().header(PRINCIPAL_HEADER_NAME, Constants.PRINCIPAL_HEADER_VALUE)
				.when().contentType(ContentType.JSON)
				.delete(CredentialsUtils.getProperty("baseURL")
						+ Endpoints.middleURLTenantsUserGroups +GROUP.GROUP_OK1.getId() + "/" + USER.USER_OK1.getId())
				.then().statusCode(200);
			
	}
	
	@Test
	public void deleteCatalogDataQueryProcessDefinitionByProcessDefinitionIdNoAuthentication() {
		given().
		when().contentType(ContentType.JSON)
		.delete(CredentialsUtils.getProperty("baseURL")
				+ Endpoints.middleURLTenantsUserGroups
				+GROUP.GROUP_OK1.getId() + "/" + USER.USER_OK1.getId())
				.then().statusCode(401);
	}
}
