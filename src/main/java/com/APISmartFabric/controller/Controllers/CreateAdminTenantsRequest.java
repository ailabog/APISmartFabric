package com.APISmartFabric.controller.Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aila.bogasieru@agys.ch 
 * 
 POST /identity/admin/tenants
 * 
 */
@Getter 
@Setter 
@AllArgsConstructor

public class CreateAdminTenantsRequest {

	private String defaultUserEmail;
	private String defaultUserPassword;
	private String domain;
	private String name;
	private String status;
	
}
