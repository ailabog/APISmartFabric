package com.APISmartFabric.controller.AdminController;
/**
 * @author aila.bogasieru@agys.ch
/identity/admin/users
createUser
 */
public class CreateTenantsGroupsRequest {


    private String code;
    private String id;
    private String name;
    private String tenantId;
    private String type;
  
    public CreateTenantsGroupsRequest(String code, String id, String name, String tenantId, String type){
    	
    	this.code = code;
    	this.id = id;
    	this.name = name;
    	this.tenantId = tenantId;
    	this.type = type;
      }
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}	
