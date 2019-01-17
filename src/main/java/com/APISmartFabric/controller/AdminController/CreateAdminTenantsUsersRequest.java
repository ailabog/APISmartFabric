package com.APISmartFabric.controller.AdminController;
/**
 * @author aila.bogasieru@agys.ch
/identity/admin/users
createUser
 */
public class CreateAdminTenantsUsersRequest {


    private String id;
    private String status;
    private String tenantId;
    private String userId;
  
    public CreateAdminTenantsUsersRequest(String id, String status, String tenantId, String userId){
    	
    	this.id = id;
    	this.status = status;
    	this.tenantId = tenantId;
    	this.userId = userId;
      }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}	
