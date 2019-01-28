package com.APISmartFabric.controller.Controllers;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 **/
 
  
public class SystemLoginRequest {
	
	
	public SystemLoginRequest(String tenantDomain, String userEmail, String userPassword){
		this.tenantDomain = tenantDomain;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	

    private String tenantDomain;
    private String userEmail;
    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

  

    public String getTenantDomain() {
        return tenantDomain;
    }

    public void setTenantDomain(String tenntDomain) {
        this.tenantDomain = tenntDomain;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
