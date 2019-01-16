package com.APISmartFabric.controller.AdminController;
/**
 * @author aila.bogasieru@agys.ch
/identity/admin/users
createUser
 */
public class CreateAdminRequest {

  	private String code;
    private String id;
    private String name;
    private String tenanatId;
    private String type;
    
    public CreateAdminRequest(String code, String id, String name, String tenanatId, String type){
    	
    	this.code = code;
    	this.id = id;
    	this.name = name;
    	this.tenanatId = tenanatId;
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

  	public String getTenanatId() {
  		return tenanatId;
  	}

  	public void setTenanatId(String tenanatId) {
  		this.tenanatId = tenanatId;
  	}

  	public String getType() {
  		return type;
  	}

  	public void setType(String type) {
  		this.type = type;
  	}
}
