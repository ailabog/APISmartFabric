package com.APISmartFabric.controller.AdminController;

/**
 * @author aila.bogasieru@agys.ch 
 * 
 POST /identity/admin/tenants
 * 
 */
public class CreateAdminTenantsRequest {

	private String defaultUserEmail;
	private String defaultUserPassword;
	private String domain;
	private String name;
	private String status;

	public CreateAdminTenantsRequest(String defaultUserEmail, String defaultUserPassword, String domain, String name, String status) {

		this.defaultUserEmail = defaultUserEmail;
		this.defaultUserPassword = defaultUserPassword;
		this.domain = domain;
		this.name = name;
		this.status = status;
	}
	
	public void setDefaultUserEmail(String defaultUserEmail) {
		this.defaultUserEmail = defaultUserEmail;
	}

	public String getDefaultUserPassword() {
		return defaultUserPassword;
	}

	public void setDefaultUserPassword(String defaultUserPassword) {
		this.defaultUserPassword = defaultUserPassword;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDefaultUserEmail() {
		return defaultUserEmail;
	}
}
